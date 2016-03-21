package sample;

public class Shape {

    private int center_x;
    private int center_y;

    public Shape(int x, int y){
        center_x = x;
        center_y = y;
    }

    public int getCenter_x(){
        return center_x;
    }

    public int getCenter_y(){
        return center_y;
    }
}
