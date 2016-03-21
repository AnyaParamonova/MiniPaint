package sample;

public class Star extends Shape{
    private int radius;

    public Star(int x, int y, int r){
        super(x, y);
        radius = r;
    }

    public int getRadius(){
        return radius;
    }
}
