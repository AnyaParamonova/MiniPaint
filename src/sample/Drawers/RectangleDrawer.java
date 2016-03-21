package sample.Drawers;

import javafx.scene.canvas.GraphicsContext;
import sample.Figures.Point;
import sample.Figures.Rectangle;

public class RectangleDrawer extends Drawer<Rectangle>{
    @Override
    public void draw(GraphicsContext graphicsContext, Rectangle rectangle){
        Point center = rectangle.getCenter();
        Point leftUpCorner = new Point(center.getX()-rectangle.getWidht()/2, center.getY()-rectangle.getHeight()/2);

        graphicsContext.strokeRect(leftUpCorner.getX(), leftUpCorner.getY(), rectangle.getWidht(), rectangle.getHeight());
    }
}
