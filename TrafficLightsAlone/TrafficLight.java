package TrafficLightsAlone;

public class TrafficLight {
    Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor() {
        switch (color){
            //is red -> green -> yellow -> red and so on
            case RED :
                color=Color.GREEN;
                break;
            case YELLOW:
                color=Color.RED;
                break;
            case GREEN:
                color=Color.YELLOW;
                break;
        }
    }
}
