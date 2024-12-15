package AbstractionTrainingPackage.Rectangle;

public class Rectangle {
    //the Rectangle should hold 2 Points – its bottom left and top right cornersthe Rectangle should hold 2 Points – its bottom left and top right corners
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
    //
    public boolean contains(Point point){
        boolean isInsideX=point.getX()>=bottomLeft.getX() && point.getX()<=topRight.getX();
        boolean isInsideY=point.getY()>=bottomLeft.getY() && point.getY()<=topRight.getY();
        return isInsideX && isInsideY;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }
}
