package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

import java.util.List;

public abstract class MagicianImpl implements Magician{

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        isAlive=true;
        this.setMagic(magic);
    }

    public void setUsername(String username) {
        if(username == null || username.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if(health < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    public void setProtection(int protection) {
        if(protection < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    public void setMagic(Magic magic) {
        if(magic == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void takeDamage(int points) {
        //The takeDamage() method decreases the Magician's protection and health. First, you need to reduce the protection.
        // If the protection reaches 0, transfer the damage to health points.
        // If the health points are less than or equal to zero, the magician is dead.

        //методът намалява защитата и здравето на магьосника. Първо, трябва да намалите защитата.
        // Ако защитата достигне 0, прехвърлете щетите върху здравни точки.
        // Ако здравните точки са по-малки или равни на нула, магьосникът е мъртъв

        //Намалява на Магьосника защитата и кръвта.
        //1.Първо трябва да намаля защитата
        //1.1Ако защитиата стане 0, прехвърлете damage  в точките кръв
        //2.Ако точките живота са под 0,значи магьосника е мъртъв
        setProtection(getProtection() - points);
        if(getProtection() ==0){
            setHealth(getHealth() - points);
        }
        if (getHealth() <= 0) {
            isAlive=false;
        }
//        this.protection -= points;
//                if (this.protection < 0){
//                    health += this.protection;
//                }
//                if (health <= 0){
//                    isAlive = false;
//                }
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }


}
