package sample.Drawers;

import javafx.scene.canvas.GraphicsContext;
import sample.Figures.Point;
import sample.Figures.Star;

import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;

public class StarDrawer extends Drawer<Star>{
    @Override
    public void draw(GraphicsContext graphicsContext, Star star){
        Point center = star.getCenter();
        int radius = star.getRadius();
        double pi = 3.14;
        double angle = 18;

        graphicsContext.moveTo(center.getX()+radius*cos(angle*2*pi/360), center.getX()-radius*sin(angle*2*pi/360));
        for(int i = 0; i < 5; i++){
            angle += 36;
            graphicsContext.lineTo(center.getX()+radius/2*cos(angle*2*pi/360), center.getX()-radius/2*sin(angle*2*pi/360));
            angle += 36;
            if(angle > 360){
                angle = 18;
            }
            graphicsContext.lineTo(center.getX()+radius*cos(angle*2*pi/360), center.getX()-radius*sin(angle*2*pi/360));
        }
        graphicsContext.stroke();
    }

}
