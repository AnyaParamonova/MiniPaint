package sample.Figures;

public class Shape {

    private Point center;

    public Shape(int x, int y){
        center = new Point(x, y);
    }

    public Point getCenter(){
        return center;
    }

    public void setCenter(Point c){
        center = c;
    }
}
