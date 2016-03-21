package sample;

public class Rectangle extends Shape{

    private int widht;
    private int height;

    public Rectangle(int x, int y, int w, int h){
        super(x, y);
        widht = w;
        height = h;
    }

    public int getWidht(){
        return widht;
    }

    public int getHeight(){
        return height;
    }
}
