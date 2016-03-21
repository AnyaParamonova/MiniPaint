package sample.Drawers;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import sample.Figures.Pika;
import sample.Figures.Point;

public class PikaDrawer extends Drawer<Pika> {

    @Override
    public void draw(GraphicsContext graphicsContext, Pika pika) {
        Point center = pika.getCenter();
        int radius = pika.getRadius();

        graphicsContext.strokeArc(center.getX()+radius/2, center.getY()-radius/2, radius, radius, 180, 90, ArcType.OPEN);
        graphicsContext.strokeArc(center.getX()-radius/2, center.getY()-radius/2, radius, radius, 270, 90, ArcType.OPEN);
        graphicsContext.strokeArc(center.getX()+radius/2, center.getY()+radius/2, radius, radius, 180, 270, ArcType.OPEN);
        graphicsContext.strokeArc(center.getX()-radius/2, center.getY()+radius/2, radius, radius, 90, 270, ArcType.OPEN);

        graphicsContext.strokeArc(center.getX()-radius/2, center.getY()+radius/2, radius, 1.2*radius, 270, 90, ArcType.OPEN);
        graphicsContext.strokeArc(center.getX()+radius/2, center.getY()+radius/2, radius, 1.2*radius, 180, 90, ArcType.OPEN);
        graphicsContext.strokeLine(center.getX(), center.getY()+1.7*radius, center.getX()+radius, center.getY()+1.7*radius);
    }
}