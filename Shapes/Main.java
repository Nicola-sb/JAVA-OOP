package Shapes;

public class Main {
    public static void main(String[] args) {

     Shape shape=new Rectangle(5.5,5.5);
     Shape shape1=new Circle(3d);

        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());
        System.out.println(shape1.getArea());
        System.out.println(shape1.getPerimeter());
    }
}
