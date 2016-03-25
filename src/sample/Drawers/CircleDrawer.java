package sample.Drawers;

import javafx.scene.canvas.GraphicsContext;
import sample.Figures.Circle;
import sample.Figures.Point;

public class CircleDrawer extends Drawer<Circle> {

    @Override
    public void draw(GraphicsContext graphicsContext, Circle circle) {
        Point leftUpCorner = circle.getLeftUpCorner();
        graphicsContext.strokeOval(leftUpCorner.getX(), leftUpCorner.getY(), circle.getWidth(), circle.getHeight());
    }
}
