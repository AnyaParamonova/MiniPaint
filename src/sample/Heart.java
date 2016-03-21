package sample;

public class Heart extends Shape{
    private int radius;
    public Heart(int x, int y, int r){
        super(x, y);
        radius = r;
    }

    public int getRadius(){
        return radius;
    }
}
