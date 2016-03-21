package sample;

public class Pika extends Shape{
    private int radius;

    public Pika(int x, int y, int r){
        super(x, y);
        radius = r;
    }

    public int getRadius(){
        return radius;
    }
}
