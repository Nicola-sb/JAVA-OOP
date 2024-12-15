package magicGame.models.magics;

public class BlackMagic extends MagicImpl{

//The constructor should take the following values upon initialization:
//(String name, int bulletsCount)
//BlackMagic can fire() 10 bullets at a time.


    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }
    private int bullets = getBulletsCount();
    @Override
    public int fire() {
        //изстрелва броя на куршумите, които има Магията, и намалява наличното им количество
        //1.Изстрелва броя на куршумите,които има магията
        //2.Намаляваме количеството им
        //3.Ако нямаме достатъчно куршуми метода трябва да връща 0;
//        setBulletsCount(getBulletsCount() - 10);
//        return Math.max(0,getBulletsCount());
        if (bullets - 10 < 0) {
            bullets = 0;
            return 0;
        } else {
            bullets -= 10;
            return 10;
        }
    }
}
