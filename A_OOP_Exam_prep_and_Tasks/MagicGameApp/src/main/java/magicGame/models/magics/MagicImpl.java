package magicGame.models.magics;

import magicGame.common.ExceptionMessages;

public abstract class MagicImpl implements Magic{

    private String name;
    private int bulletsCount;

    public MagicImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
        }
        this.name = name;
    }

    public void setBulletsCount(int bulletsCount) {
        if(bulletsCount < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }

    @Override
    public int fire() {
        //The fire() method fires the number of bullets the Magic has and reduces its available amount.
        // RedMagic can fire only 1 bullet and the BlackMagic only 10 at once, not more, not less.
        // If there are not enough bullets, the method should return 0.

        //изстрелва броя на куршумите, които има Магията, и намалява наличното им количество
        //1.Изстрелва броя на куршумите,които има магията
        //2.Намаляваме количеството им
        //3.Ако нямаме достатъчно куршуми метода трябва да връща 0;
        if(getBulletsCount() < 0){
            return 0;
        }
        return getBulletsCount();
    }
}
