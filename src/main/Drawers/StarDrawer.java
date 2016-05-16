package main.Drawers;

import javafx.scene.canvas.GraphicsContext;
import plugin_api.*;
import main.Figures.Star;

import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;

public class StarDrawer extends Drawer<Star>{
    @Override
    public void draw(GraphicsContext graphicsContext, Star star){
        Point leftUpCorner = star.getLeftUpCorner();
        int widthRadius = star.getWidthRadius(), heightRadius = star.getHeightRadius();
        Point center = new Point(leftUpCorner.getX()+widthRadius, leftUpCorner.getY()+heightRadius);
        double pi = 3.14;
        double angle = 18;

        for(int i = 0; i < 10; i++){
            graphicsContext.strokeLine(center.getX()+widthRadius*cos(angle*pi/180), center.getY()-heightRadius*sin(angle*pi/180),
                    center.getX()+widthRadius/2*cos((angle+36)*pi/180), center.getY()-heightRadius/2*sin((angle+36)*pi/180));
            angle += 36;

            graphicsContext.strokeLine(center.getX()+widthRadius/2*cos(angle*pi/180), center.getY()-heightRadius/2*sin(angle*pi/180),
                    center.getX()+widthRadius*cos((angle+36)*pi/180), center.getY()-heightRadius*sin((angle+36)*pi/180));
            angle += 36;
            if(angle > 360){
                angle = 18;
            }
        }

    }


}
