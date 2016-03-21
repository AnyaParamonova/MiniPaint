package sample;

public class Hexagon extends Shape{
    private int radius;
    public Hexagon(int x, int y, int r){
        super(x, y);
        radius = r;
    }

    public int getRadius(){
        return radius;
    }
}
