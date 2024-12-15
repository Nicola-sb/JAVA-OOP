package viceCity.models.players;

import viceCity.common.ExceptionMessages;
import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

public abstract class BasePlayer implements Player{

    private String name;
    private int lifePoints;
    private Repository<Gun>gunRepository;

    public BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository=new GunRepository();
    }

    private void setName(String name){
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.PLAYER_NULL_USERNAME);
        }
        this.name=name;
    }
    private void setLifePoints(int lifePoints){
        if(lifePoints < 0){
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints=lifePoints;
    }
    @Override
    public boolean isAlive(){
        return this.lifePoints > 0;
    }
    @Override
    public void takeLifePoints(int pointsTaken){
//        this.lifePoints=this.lifePoints-pointsTaken;
//        if(lifePoints < 0){
//            this.lifePoints=0;
//        }
        this.lifePoints=Math.max(0,this.lifePoints-pointsTaken);//Реално Math.max ще върне или 0 или изваждането lifePoints-pointsTaken
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return gunRepository;
    }
}
