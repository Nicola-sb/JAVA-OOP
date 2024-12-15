package handball.repositories;

import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;

import java.util.ArrayList;
import java.util.Collection;

public class EquipmentRepository implements Repository {

    private Collection<Equipment> equipments;

    public EquipmentRepository() {
        this.equipments=new ArrayList<>();
    }

    @Override
    public void add(Equipment equipment) {
               equipments.add(equipment);
    }

    @Override
    public boolean remove(Equipment equipment) {
        return equipments.remove(equipment);
    }

    @Override
    public Equipment findByType(String type) {
//        //•	Returns the first equipment of the given type, if there is. Otherwise, returns null
//        Equipment equipment;
//             switch (type){
//                 case "ElbowPad":
//                     equipment=new ElbowPad();
//                     break;
//                 case "KneePad":
//                     equipment=new Kneepad();
//                     break;
//                 default:
//                     return null;
//             }
//             return equipment;
        return this.equipments.stream().filter(e -> e.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
