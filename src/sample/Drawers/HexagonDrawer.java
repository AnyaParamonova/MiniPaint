package sample.Drawers;


import javafx.scene.canvas.GraphicsContext;
import sample.Figures.Hexagon;
import sample.Figures.Point;

import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;

public class HexagonDrawer extends Drawer<Hexagon>{
    @Override
    public void draw(GraphicsContext graphicsContext, Hexagon hexagon){
        Point leftUpCorner = hexagon.getLeftUpCorner();
        int widthRadius = hexagon.getWidthRadius(), heightRadius = hexagon.getHeightRadius();
        Point center = new Point(leftUpCorner.getX() + widthRadius, leftUpCorner.getY() + heightRadius);
        double pi = 3.14;

        for(int i = 1; i < 7; i++) {
            graphicsContext.strokeLine(center.getX() + widthRadius*cos((i-1)*2*pi/6), center.getY()+ heightRadius*sin((i-1)*2*pi/6),center.getX() + widthRadius*cos(i*2*pi/6), center.getY()+ heightRadius*sin(i*2*pi/6));
        }
    }
}
