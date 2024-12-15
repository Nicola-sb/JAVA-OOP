package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;

import java.util.*;
import java.util.stream.Collectors;

public class MagicianRepositoryImpl implements MagicianRepository {

    private Collection<Magician>data;

    public MagicianRepositoryImpl() {
        data=new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return this.data;
    }

    @Override
    public void addMagician(Magician model) {
     if(model == null){
         throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
     }
     data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return data.remove(model);
    }

//    @Override
//    public Magician findByUsername(String name) {
//        return data.stream().filter(magician -> magician.getUsername().equals(name)).findFirst().orElse(null);
//    }
@Override
public Object findByUsername(String name) {
    return data.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
}

//    @Override
//    public Object findByUsername(String name) {
////        return data.stream().filter(magician -> magician.getUsername().equals(name)).findFirst().orElse(null);
//        return data.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
//    }

//    @Override
//    public String toString() {
//        //Returns information about each magician separated with a new line
//        // . Order then by health ascending, then by username alphabetically, then by type alphabetically. You can use the overridden .toString() Magician method.
//        //"{magician type}: {magician username}
//        // Health: {magician health}
//        // Protection: {magician protection}
//        // Magic: {magician magic name}"
//        //Note: Use System.lineSeparator() for a new line and don't forget to trim if you use StringBuilder.
//        List<Magician>magicianList=
//                data.stream().sorted(Comparator.comparing(Magician::getHealth).
//                thenComparing(Magician::getUsername).
//                        thenComparing(type -> type.getClass().getSimpleName()).
//                thenComparing(Magician::getProtection)).collect(Collectors.toList());
//        StringBuilder sb=new StringBuilder();
//        for (Magician currentMagican : magicianList) {
//            sb.append(String.format("%s: %s",currentMagican.getClass().getSimpleName(),currentMagican.getUsername())).append(System.lineSeparator());
//            sb.append(String.format("Health: %d",currentMagican.getHealth())).append(System.lineSeparator());
//            sb.append(String.format("Protection: %d",currentMagican.getProtection())).append(System.lineSeparator());
//            sb.append(String.format("Magic: %s",currentMagican.getMagic().getName())).append(System.lineSeparator());
//        }
//
//        return sb.toString().trim();
//    }
}
