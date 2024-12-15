package Animal;

public class Dog extends Animal{

//    public Dog(String name,String favouriteFood) {
//        setName(name);
//        setFavouriteFood(favouriteFood);
//    }


    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        //I am Rocky and my favourite food is Meat
        //DJAAF
        return String.format("I am %s and my favourite food is %s%nDJAAF%n",super.getName(),super.getFavouriteFood());
    }
}
