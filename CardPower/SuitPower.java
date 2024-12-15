package CardPower;

public enum SuitPower {


    //Suit powers are as follows: (CLUBS - 0, DIAMONDS - 13, HEARTS - 26, SPADES - 39).
//    CLUBS("CLUBS",0),
//    DIAMONDS("DIAMONDS",13),
//    HEARTS("HEARTS",26),
//    SPADES("SPADES",39);
//    private String name;
//    private int power;
//
//    SuitPower(String name, int power) {
//        this.name = name;
//        this.power = power;
//    }
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suitPower;

    SuitPower(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return suitPower;
    }
}
