package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }
    //+ 	Box (double length, double width, double height)
    //-	setLength(double): void
    //-	setWidth(double): void
    //-	setHeight(double): void
    //+	calculateSurfaceArea (): double
    //+	calculateLateralSurfaceArea (): double
    //+	calculateVolume (): double


//    private void setLength(double length) {
//        if(length<=0){
//            throw new IllegalArgumentException("Length cannot be zero or negative.");
//        }
//        this.length = length;
//    }
//
//    private void setWidth(double width) {
//        if(width<=0){
//            throw new IllegalArgumentException("Width cannot be zero or negative.");
//        }
//        this.width = width;
//    }
//
//    private void setHeight(double height) {
//        if(height<=0){
//            throw new IllegalArgumentException("Height cannot be zero or negative.");
//        }
//        this.height = height;
//    }
    //Volume = lwh
    //Lateral Surface Area = 2lh + 2wh
    //Surface Area = 2lw + 2lh + 2wh

    public double calculateSurfaceArea (){
      return  2 * length * width + 2 * length* height + 2 * width * height;
    }
    public double calculateLateralSurfaceArea(){
             return 2 * length * height + 2 * width * height;
    }
    public double calculateVolume (){
        return length*height*width;
    }

    //Мога да си създаме метод в който да си валидирам 3те сетъра
    private  double setAll3(double argument,String argumentType){
        if(argument<=0){
            throw new IllegalArgumentException(argumentType+" cannot be zero or negative.");
        }
        return argument;
    }
    private void setLength(double length) {
        if(length<=0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if(width<=0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if(height<=0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }
}
