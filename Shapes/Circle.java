package Shapes;

public class Circle extends Shape{
   private final Double radius;

    public final Double getRadius() {
        return radius;
    }


    public Circle(Double radius) {
        this.radius = radius;
        this.setArea(calculateArea());
        this.setPerimeter(calculatePerimeter());
    }

    @Override
    Double calculatePerimeter() {
        //2*PI*R
//        return 2 * 3.14 * radius;
        return 2 * Math.PI * radius;
    }

    @Override
    Double calculateArea() {
      //  return radius *2 * 3.14;
        return Math.PI * radius * radius;
    }
}
