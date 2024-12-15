package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepository;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepository;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{

    //You need to keep track of some things; this is why you need some private fields in your controller class:
    //•	magics - MagicRepositoryImpl
    //•	magicians – MagicianRepositoryImpl
    //•	region - Region
    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        magics=new MagicRepositoryImpl();
        magicians=new MagicianRepositoryImpl();
        region=new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        //Adds a Magic and adds it to the MagicRepositoryImpl. Valid types are "RedMagic" and "BlackMagic".
        //If the Magic type is invalid, you have to throw an IllegalArgumentException with the following message:
        //•	"Invalid magic type!"
        //If the Magic is added successfully, the method should return the following String:
        //•	"Successfully added magic {magicName}."
        Magic magic;
        switch (type){
            case "RedMagic":
                magic=new RedMagic(name,bulletsCount);
                break;
            case "BlackMagic":
                magic=new BlackMagic(name,bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }
        magics.addMagic(magic);

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC,name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        //Creates a Magician of the given type and adds it to the MagicianRepositoryImpl. Valid types are: "Wizard" and "BlackWidow".
        //If the magic is not found throw NullPointerException with a message:
        //•	"Magic cannot be found!"
        //If the magician type is invalid, throw an IllegalArgumentException with the message:
        //•	"Invalid magician type!"
        //The method should return the following String if the operation is successful:
        //•	"Successfully added magician {username}."
        Magician magician;
        Magic currentMagic= (Magic) magics.findByName(magicName);
        if(currentMagic==null){
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }

        switch (type){
            case "Wizard":
                magician=new Wizard(username,health,protection,currentMagic);
                break;
            case "BlackWidow":
                magician=new BlackWidow(username,health,protection,currentMagic);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }
        magicians.addMagician(magician);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN,username);
    }

    @Override
    public String startGame() {
        //The game starts with all magicians that are alive! Returns the result from the start() method.
        //Collection<Magician> magicians

//        List<Magician>aliveMagican=magicians.getData().stream().filter(magician -> magician.getHealth() > 0).collect(Collectors.toList());
////        List<Magician>aliveMagican=magicians.getData().stream().filter(magician -> magician.isAlive()).collect(Collectors.toList());
//
//        Region region1=new RegionImpl();
//
//        return region1.start(aliveMagican);
          return region.start(this.magicians.getData());
    }

    @Override
    public String report() {
        //Returns information about each magician separated with a new line. Order then by health ascending,
        // then by username alphabetically, then by type alphabetically. You can use the overridden .toString() Magician method.
        //"{magician type}: {magician username}
        // Health: {magician health}
        // Protection: {magician protection}
        // Magic: {magician magic name}"
        //Note: Use System.lineSeparator() for a new line and don't forget to trim if you use StringBuilder.

//        List<Magician>magicianList=magicians.getData().stream().sorted(Comparator.comparing(Magician::getHealth).thenComparing(Magician::getUsername)
//                .thenComparing(type -> type.getClass().getSimpleName())).collect(Collectors.toList());
//        // List<Magician> magicianList = magicians.getData().stream().
//        // sorted(Comparator.comparing(Magician::getHealth).thenComparing(Magician::getUsername)).collect(Collectors.toList());
//        StringBuilder sb=new StringBuilder();
//        for (Magician currentMagican : magicianList) {
//            sb.append(String.format("%s: %s",currentMagican.getClass().getSimpleName(),currentMagican.getUsername())).append(System.lineSeparator());
//            sb.append(String.format("Health: %d",currentMagican.getHealth())).append(System.lineSeparator());
//            sb.append(String.format("Protection: %d",currentMagican.getProtection())).append(System.lineSeparator());
//            sb.append(String.format("Magic: %s",currentMagican.getMagic().getName())).append(System.lineSeparator());
//        }
//
//        return sb.toString().trim();
        StringBuilder sb=new StringBuilder();
         List<Magician> magicianList = magicians.getData().stream().
         sorted(Comparator.comparing(Magician::getHealth).thenComparing(Magician::getUsername)).collect(Collectors.toList());
        for (Magician magician : magicianList) {
            int health = magician.getHealth();
            if (magician.getHealth() < 0){
                health = 0;
            }
            int protection = magician.getProtection();
            if (magician.getProtection() < 0){
                protection = 0;
            }
            sb.append(String.format("%s: %s", magician.getClass().getSimpleName(), magician.getUsername())).append(System.lineSeparator())
                    .append(String.format("Health: %d", health)).append(System.lineSeparator())
                    .append(String.format("Protection: %d", protection)).append(System.lineSeparator())
                    .append(String.format("Magic: %s", magician.getMagic().getName())).append(System.lineSeparator());
        }
        return sb.toString().trim();

    }
}
