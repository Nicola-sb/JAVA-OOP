package CardPower;

public enum CardsPower {
////                ACE(),
////                TWO,
////                THREE,
////                FOUR,
////                FIVE,
////                SIX,
////                SEVEN,
////                EIGHT,
////                TEN,
////                JACK,
////                QUEEN,
////                KING;
//    //Rank powers are as follows:
//    // (ACE - 14, TWO - 2, THREE - 3, FOUR - 4, FIVE - 5, SIX - 6, SEVEN - 7, EIGHT - 8, NINE - 9, TEN - 10, JACK - 11, QUEEN - 12, KING - 13).
//    ACE("ACE",14),
//    TWO("TWO",2),
//    THREE("THREE",3),
//    FOUR("FOUR",4),
//    FIVE("FIVE",5),
//    SIX("SIX",6),
//    SEVEN("SEVEN",7),
//    EIGHT("EIGHT",8),
//    NINE("NINE",9),
//    TEN("TEN",10),
//    JACK("JACK",11),
//    QUEEN("QUEEN",12),
//    KING("KING",13);
//    private String name;
//    private int power;
//
//    CardsPower(String name, int power) {
//        this.name = name;
//        this.power = power;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getPower() {
//        return power;
//    }
//
//    public void setPower(int power) {
//        this.power = power;
//    }
                ACE(14),
                TWO(2),
                THREE(3),
                FOUR(4),
                FIVE(5),
                SIX(6),
                SEVEN(7),
                EIGHT(8),
                NINE(9),
                TEN(10),
                JACK(11),
                QUEEN(12),
                KING(13);


                private int power;

    CardsPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
