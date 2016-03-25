package sample.Drawers;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import sample.Figures.Pika;
import sample.Figures.Point;

public class PikaDrawer extends Drawer<Pika> {

    @Override
    public void draw(GraphicsContext graphicsContext, Pika pika) {
        Point leftUpConer = pika.getLeftUpCorner();
        int x = leftUpConer.getX(), y = leftUpConer.getY();
        int widthRadius = pika.getWidthRadius(), heightRadius = pika.getHeightRadius();

        graphicsContext.strokeArc(x+widthRadius, y, widthRadius, heightRadius, 270, 90, ArcType.OPEN);
        graphicsContext.strokeArc(x+2*widthRadius, y, widthRadius, heightRadius, 180, 90, ArcType.OPEN);
        graphicsContext.strokeArc(x+2*widthRadius, y+heightRadius, widthRadius, heightRadius, 180, 270, ArcType.OPEN);
        graphicsContext.strokeArc(x+widthRadius, y+heightRadius, widthRadius, heightRadius, 90, 270, ArcType.OPEN);

        graphicsContext.strokeArc(x+widthRadius, y+heightRadius, widthRadius, 1.2*heightRadius, 270, 90, ArcType.OPEN);
        graphicsContext.strokeArc(x+2*widthRadius, y+heightRadius, widthRadius, 1.2*heightRadius, 180, 90, ArcType.OPEN);
        graphicsContext.strokeLine(x+1.5*widthRadius, y+2.2*heightRadius, x+2.5*widthRadius, y+2.2*heightRadius);
    }
}