package viceCity.models.guns;

public class Pistol extends BaseGun{


    private static final int DEFAULT_BULLETS_PER_BAREL=10;
    private static final int DEFAULT_TOTAL_BULLETS=100;
    private static final int BULLETS_PER_SHOT=1;


    public Pistol(String name) {
        super(name, DEFAULT_BULLETS_PER_BAREL, DEFAULT_TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        //1.Check if we have bullets in our barrel? - shoot
        //AKo имаме трябва да ги намалим с 1 и да върнем 1.Защо с 1?Защото с 1 патрон стрелям с нашия Пистол
        //2.Ако нямаме патрони в нашия пълнител трябва да презаредим - reload (Презареждането е пълненето на нашият пълнител с куршим от патрондажа)
        if(getBulletsPerBarrel()==0 && getTotalBullets() > 0){//Първо ако си вземем куршумите в нашият пълнител и те са 0 трябва да презаредим -> създавам си reload метод
            reload();
        }
        //След като сме презаредили трябва да изкараме куршум от нашия пълнител
        if(getBulletsPerBarrel() > 0){
           setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_PER_SHOT);
        }

        return BULLETS_PER_SHOT;
    }

    private void reload() {
        //Трябва да вземем куршуми от общия брой куршуми и да си напълним целия пълнител
        setTotalBullets(getTotalBullets() - DEFAULT_BULLETS_PER_BAREL);
        //И трябва да кажа,че вече в пълнителя си имам 10патрона DEFAULT_BULLETS_PER_BAREL
        setBulletsPerBarrel(DEFAULT_BULLETS_PER_BAREL);
    }
}
