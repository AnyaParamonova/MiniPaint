package sample.Drawers;


import javafx.scene.canvas.GraphicsContext;
import sample.Figures.Hexagon;
import sample.Figures.Point;

import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;

public class HexagonDrawer extends Drawer<Hexagon>{
    @Override
    public void draw(GraphicsContext graphicsContext, Hexagon hexagon){
        Point center = hexagon.getCenter();
        int radius = hexagon.getRadius();
        double pi = 3.14;

        graphicsContext.moveTo(center.getX()+radius, center.getY());
        for(int i = 1; i < 7; i++) {
            graphicsContext.lineTo(center.getX() + radius*cos(i*2*pi/6), center.getY()+ radius*sin(i*2*pi/6));
        }
        graphicsContext.stroke();
    }
}
