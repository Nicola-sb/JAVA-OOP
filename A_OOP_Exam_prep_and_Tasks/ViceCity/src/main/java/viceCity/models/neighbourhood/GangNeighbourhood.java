package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood {


    @Override
    public void action(Player tommyVercetti, Collection<Player> civilPlayers) {
        //1.Ще ни трябва оръжията на mainPlayer - те седят в Repository
        Repository<Gun>tommyGunRepository= tommyVercetti.getGunRepository();//Това е репото с оръжията на Томми
        //Ние ще трябва да минаваме през всички оръжия --> в GunRepository имаме си метод public Collection<Gun> getModels(),
        //който ни взима моделите на всички оръжия
        Deque<Gun>tommyGuns=new ArrayDeque<>(tommyGunRepository.getModels());
//        Collection<Gun>tommyGuns=tommyGunRepository.getModels();//--> Това са всикчи оръжия,които нашият Томми има
        //Вече имаме оръжията,сега трябва да си вземем и хората по които ще стреля
        //Трябва да си измислим механизъм по които последовталено да си взимаме оръжия и да ги хвърляме,когато не ни трябват
        //и да започнем да стреляме по хора и да ги премахме,когато  не ни трябват

        //По същия начин ще трябва да боравим и с цивилните хора
        Deque<Player>players=new ArrayDeque<>(civilPlayers);
        //За да започне нашата стрелбя трябва да преминем през оръжията и през хората.Да преминаваме и през двете едновременно

        //I phase
        Player player=players.poll();//Взимам си първия цивилен по който ще стреляме
        Gun gun=tommyGuns.poll();//Взимам си първото оръжие
        //ВЕче съм готов да стрелмя с първото оръжие по първия човек
        //Това трябва да става в някакъв цикъл : Или хората по които стреляме не свършат или оръжията с които стреляме не свършат
        //Докато те неща са веррни ще продължаваме да стреляме.Ще минаваме през двете структури от данни и ще pollване или човек или оръжия
        //И докато можем да pollваме ще стреляме
        while (player !=null && gun !=null){
            //Сега трябва да опишем какво искаме да се случи,когато с едно оръжие стреляме по един човек
            while (gun.canFire() && player.isAlive()){
                int shot= gun.fire();//Ще стреляме с пистолета
                //И ще отнемем толкова точки живот от човека -->
                player.takeLifePoints(shot);
                //Така стреляме по човека или докато не ни свършат патроните или докато човека не умре
            }
            //Ако излезнем от този цъкъл или нямаме повече хора или не можем да стреляме повече
            //Трябва да вземем или ново оръжие или да вземем нов човек по когото да стреляме
            //Но за да го направим това трябва първо да разберем оръжието ли ни е свършило или сме убили човека
            if(gun.canFire()){
                players.poll();//Ако оръжието може да стреля значи ни трябва нова мишена
            }else {
                gun=tommyGuns.poll();
            }
        }

        //II phase
        for (Player civilPlayer : civilPlayers) {
            if(civilPlayer.isAlive()){
                //Ще минаваме през всеки един цивилен играч и ще трябва да им вземм оръжията(може да имам повече от едно оръжие)
                Repository<Gun>civilPlayerGunRepository=civilPlayer.getGunRepository();
                Deque<Gun>civilPlayersGuns=new ArrayDeque<>(civilPlayerGunRepository.getModels());
                //Сега имаме опашка с оръжията на цивилния играч
                //Вече сме взели оръжията на нашият цивилен играч и сега трябва да вземем едно оръжие и да започнем да стреляме
                Gun civilPlayerGun=civilPlayersGuns.poll();
                while (civilPlayerGun!=null){//Докато имаме оръжие можем да стреляме по Томми
                    //Ще стреляме или докато не ни свършат оръжията или докато Томми е жив
                    while (civilPlayerGun.canFire() && tommyVercetti.isAlive()){
                        int shot=civilPlayerGun.fire();
                        tommyVercetti.takeLifePoints(shot);
                    }
                    if(!tommyVercetti.isAlive()){
                        return;
                    }
                   civilPlayerGun= civilPlayersGuns.poll();
                }
            }

        }

    }
}
