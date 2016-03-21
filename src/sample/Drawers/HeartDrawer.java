package sample.Drawers;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import sample.Figures.Heart;
import sample.Figures.Point;

public class HeartDrawer extends Drawer<Heart> {

    @Override
    public void draw(GraphicsContext graphicsContext, Heart heart) {
        int radius = heart.getRadius();
        Point center = heart.getCenter();

        graphicsContext.strokeArc(center.getX()+radius/2, center.getY()-radius/2, radius, radius, -90, 270, ArcType.OPEN);
        graphicsContext.strokeArc(center.getX()-radius/2, center.getY()-radius/2, radius, radius, 0, 270, ArcType.OPEN);
        graphicsContext.strokeArc(center.getX()+radius/2, center.getY()+radius/2, radius, radius, 90, 90, ArcType.OPEN);
        graphicsContext.strokeArc(center.getX()-radius/2, center.getY()+radius/2, radius, radius, 0, 90, ArcType.OPEN);
    }
}
