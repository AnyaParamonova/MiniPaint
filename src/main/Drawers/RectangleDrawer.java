package main.Drawers;

import javafx.scene.canvas.GraphicsContext;
import plugin_api.*;
import main.Figures.Rectangle;

public class RectangleDrawer extends Drawer<Rectangle>{
    @Override
    public void draw(GraphicsContext graphicsContext, Rectangle rectangle){
        Point leftUpCorner = rectangle.getLeftUpCorner();
        graphicsContext.strokeRect(leftUpCorner.getX(), leftUpCorner.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
}
