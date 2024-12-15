package SingleInheritance;

public class Main {
    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.eat();
        dog.bark();

        Cat cat=new Cat();
        cat.eat();
        cat.meow();

        RandomArrayList randomYeeArrayList=new RandomArrayList();
        randomYeeArrayList.add(1,12);

        randomYeeArrayList.getRandomElement();


    }
}
