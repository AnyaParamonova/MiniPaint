package sample;

public class Circle extends Shape {

    private int radius;

    public Circle(int x, int y, int r){
        super(x, y);
        radius = r;
    }

    public int getRadius(){
        return radius;
    }
}
