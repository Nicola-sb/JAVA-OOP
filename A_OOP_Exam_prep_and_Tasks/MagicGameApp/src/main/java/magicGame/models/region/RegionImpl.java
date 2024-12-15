package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region{


    @Override
    public String start(Collection<Magician> magicians) {
        //Separates the magicians into two types - Wizard and Black Widow.
        // The game continues until one of the teams is completely dead (all magicians have 0 health).
        // Both magician groups take a turn shooting at each other – first is the Wizards,
        // then the Black Widows inflict damage equal to their bullet fired from their Magic.
        // Make sure the Magician has enough bullets before he/she tries to attack!
        //The damage they deal comes from each magic property of each Magician.
        //If Wizards win return "Wizards win!" otherwise return "Black widows win!"

        //Трябва да разделя магьосниците на 2 типа : Wizard and Black Widow.
        //Цикъла трябва да ми продължи докато всичките играчи на някои от отборите не умрат
        //И двете групи се стрелят взаимно -> първо стрелят Магьосниците,след което Черната вдовица нанасят щети, равни на техния куршум, изстрелян от тяхната магия
        //Трябва да се подсигуря че Magican имат достатъчно куршуму преди да стрелят
        //Щетите, които нанасят, идват от всяко магическо свойство на всеки магьосник.
        List<Magician> wizardMagican=magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("Wizard")).collect(Collectors.toList());
        List<Magician> blackWiodwdMagican=magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow")).collect(Collectors.toList());

//        while (!wizardMagican.isEmpty() && !blackWiodwdMagican.isEmpty()){
//            for(int i=0 ;i<wizardMagican.size() ;i++){
//                Magician currentWizard=wizardMagican.get(0);
//                if(currentWizard.getMagic().getBulletsCount() > 0){
////                currentWizard.getMagic().fire();
//                    currentWizard.takeDamage(currentWizard.getMagic().fire());
//                    if(!currentWizard.isAlive()){
//                        wizardMagican.remove(i);
//                        i--;
//                    }
//                }
//            }
//
//            for(int i=0 ;i<blackWiodwdMagican.size() ;i++){
//                Magician currentBlackWidow=blackWiodwdMagican.get(0);
//                if(currentBlackWidow.getMagic().getBulletsCount()>0){
//                    currentBlackWidow.takeDamage(currentBlackWidow.getMagic().fire());
//                }
//                if(!currentBlackWidow.isAlive()){
//                    i--;
//                }
//            }
        while (!wizardMagican.isEmpty() && blackWiodwdMagican.isEmpty()){
            Wizard wizard= (Wizard) wizardMagican.get(0);
            BlackWidow blackWidow= (BlackWidow) blackWiodwdMagican.get(0);
            if(blackWidow.isAlive()){
                wizard.takeDamage(wizard.getMagic().fire());
                if(!wizard.isAlive()){
                    wizardMagican.remove(wizard);
                }
            }else{
                   blackWiodwdMagican.remove(blackWidow);
            }

        }
        if (wizardMagican.size() > blackWiodwdMagican.size()){
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }

//        if(wizardMagican.isEmpty()){
//            return "Black widows win!";
//        }else{
//            return "Wizards win!";
//        }
    }
}
