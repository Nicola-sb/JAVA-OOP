package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		String command=scanner.nextLine();
		Consumer<Field>printLines= field -> System.out.println(Modifier.toString(field.getModifiers()) + " "+ field.getType().getSimpleName() + " " + field.getName());

		Map<String, List<Field>>fieldsMap=getFields();
		while (!command.equals("HARVEST")){
			switch (command){
				//"{access modifier} {field type} {field name}"
				case "private":
//					fieldsMap.get("private").forEach( field -> {
//						System.out.println(Modifier.toString(field.getModifiers()) + " "+ field.getType().getSimpleName() + " " + field.getName());
//					});

					fieldsMap.get("private").forEach(printLines::accept);
					break;
				case "public":
//					fieldsMap.get("public").forEach( field -> {
//						System.out.println(Modifier.toString(field.getModifiers()) + " "+ field.getType().getSimpleName() + " " + field.getName());
//					});
					fieldsMap.get("public").forEach(printLines);
					break;
				case "protected":
//					fieldsMap.get("protected").forEach( field -> {
//						System.out.println(Modifier.toString(field.getModifiers()) + " "+ field.getType().getSimpleName() + " " + field.getName());
//					});
					fieldsMap.get("protected").forEach(printLines);
					break;
				case "all":
					fieldsMap.get("all").forEach( field -> {
						System.out.println(Modifier.toString(field.getModifiers()) + " "+ field.getType().getSimpleName() + " " + field.getName());
					});
					break;
			}
			command=scanner.nextLine();
		}

	}

	private static Map<String, List<Field>> getFields() {
		Map<String,List<Field>>map=new HashMap<>();
		map.put("private",new ArrayList<>());
		map.put("public",new ArrayList<>());
		map.put("protected",new ArrayList<>());

		List<Field>allFields=Arrays.asList(RichSoilLand.class.getDeclaredFields());
		map.put("all",allFields);

		allFields.forEach(field -> {
			String modifier= Modifier.toString(field.getModifiers());
			switch (modifier){
				case "private":
					map.get("private").add(field);
					break;
				case "public":
					map.get("public").add(field);
					break;
				case "protected":
					map.get("protected").add(field);
					break;
			}
		});
		return map;
	}
}
