package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class SecondMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command=scanner.nextLine();
        Map<String, List<Field>>fieldsMap=new HashMap<>();
        fieldsMap.put("private",new ArrayList<>());
        fieldsMap.put("public",new ArrayList<>());
        fieldsMap.put("protected",new ArrayList<>());
        List<Field>allFields=Arrays.asList(RichSoilLand.class.getDeclaredFields());
        fieldsMap.put("all",allFields);

        allFields.forEach(field -> {
            String modifier= Modifier.toString(field.getModifiers());
            switch (modifier){
                case "private":
                    fieldsMap.get("private").add(field);
                    break;
                case "public":
                    fieldsMap.get("public").add(field);
                    break;
                case "protected":
                    fieldsMap.get("protected").add(field);
                    break;
            }
        });
        while (!command.equals("HARVEST")){

             switch (command){
                 case "private":
                     fieldsMap.get("private").forEach(field -> System.out.println(Modifier.toString(field.getModifiers())+ " "+ field.getType().getSimpleName() + " "+field.getName()));
                     break;
                 case "public":
                     fieldsMap.get("public").forEach(field -> System.out.println(Modifier.toString(field.getModifiers())+ " "+ field.getType().getSimpleName() + " "+field.getName()));
                     break;
                 case "protected":
                     fieldsMap.get("protected").forEach(field -> System.out.println(Modifier.toString(field.getModifiers())+ " "+ field.getType().getSimpleName() + " "+field.getName()));
                     break;
                 case "all":
                     fieldsMap.get("all").forEach(field -> System.out.println(Modifier.toString(field.getModifiers())+ " "+ field.getType().getSimpleName() + " "+field.getName()));
                     break;
             }
            command=scanner.nextLine();
        }
    }
}
