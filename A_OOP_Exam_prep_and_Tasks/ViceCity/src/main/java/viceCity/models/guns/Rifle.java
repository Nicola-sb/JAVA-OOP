package viceCity.models.guns;

public class Rifle extends BaseGun{


    private static final int DEFAULT_BULLETS_PER_BAREL=50;
    private static final int DEFAULT_TOTAL_BULLETS=500;
    private static final int BULLETS_PER_SHOT=5;

    public Rifle(String name) {
        super(name, DEFAULT_BULLETS_PER_BAREL, DEFAULT_TOTAL_BULLETS);
    }
    @Override
    public int fire() {

        if(getBulletsPerBarrel() ==0 && getTotalBullets() > 0){
            reload();
        }

//        if(getBulletsPerBarrel() > 0){
//            setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_PER_SHOT);
//        }

        return BULLETS_PER_SHOT;
    }

    private void reload() {
        setTotalBullets(getTotalBullets() - DEFAULT_BULLETS_PER_BAREL);
        setBulletsPerBarrel(DEFAULT_BULLETS_PER_BAREL);
    }
}
