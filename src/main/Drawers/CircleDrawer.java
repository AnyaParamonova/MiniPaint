package main.Drawers;

import javafx.scene.canvas.GraphicsContext;
import main.Figures.Circle;
import plugin_api.*;

public class CircleDrawer extends Drawer<Circle> {

    @Override
    public void draw(GraphicsContext graphicsContext, Circle circle) {
        Point leftUpCorner = circle.getLeftUpCorner();
        graphicsContext.strokeOval(leftUpCorner.getX(), leftUpCorner.getY(), circle.getWidth(), circle.getHeight());
    }
}
