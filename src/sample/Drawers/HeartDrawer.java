package sample.Drawers;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import sample.Figures.Heart;
import sample.Figures.Point;

public class HeartDrawer extends Drawer<Heart> {

    @Override
    public void draw(GraphicsContext graphicsContext, Heart heart) {
        Point leftUpConer = heart.getLeftUpCorner();
        int x = leftUpConer.getX(), y = leftUpConer.getY();
        int widthRadius = heart.getWidthRadius(), heightRadius = heart.getHeightRadius();

        graphicsContext.strokeArc(x+2*widthRadius, y, widthRadius, heightRadius, -90, 270, ArcType.OPEN);
        graphicsContext.strokeArc(x+widthRadius, y, widthRadius, heightRadius, 0, 270, ArcType.OPEN);
        graphicsContext.strokeArc(x+2*widthRadius, y+heightRadius, widthRadius, heightRadius, 90, 90, ArcType.OPEN);
        graphicsContext.strokeArc(x+widthRadius, y+heightRadius, widthRadius, heightRadius, 0, 90, ArcType.OPEN);

    }
}
