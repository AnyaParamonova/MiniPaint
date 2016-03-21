package sample.Drawers;

import javafx.scene.canvas.GraphicsContext;
import sample.Figures.Circle;
import sample.Figures.Point;

public class CircleDrawer extends Drawer<Circle> {

    @Override
    public void draw(GraphicsContext graphicsContext, Circle circle) {
        int radius = circle.getRadius();
        Point center = circle.getCenter();
        int left_up_corner_x = center.getX()-radius, left_up_corner_y = center.getY()-radius;
        graphicsContext.strokeOval(left_up_corner_x, left_up_corner_y, 2*radius, 2*radius);
    }
}
