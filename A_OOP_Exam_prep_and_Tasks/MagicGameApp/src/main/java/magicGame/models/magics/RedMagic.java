package magicGame.models.magics;

public class RedMagic extends MagicImpl{
    //The constructor should take the following values upon initialization:
    //(String name, int bulletsCount)
    //RedMagic can fire() 1 bullet at a time.


    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    private int bullets = getBulletsCount();
    @Override
    public int fire() {
        //изстрелва броя на куршумите, които има Магията, и намалява наличното им количество
        //1.Изстрелва броя на куршумите,които има магията
        //2.Намаляваме количеството им
        //3.Ако нямаме достатъчно куршуми метода трябва да връща 0;

//        setBulletsCount(getBulletsCount() - 1);
//        return Math.max(0,getBulletsCount());
        if (bullets - 1 < 0) {
            bullets = 0;
            return 0;
        } else {
            bullets -= 1;
            return 1;
        }
    }
}
