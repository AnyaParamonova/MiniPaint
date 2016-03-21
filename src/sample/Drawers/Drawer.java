package sample.Drawers;

import javafx.scene.canvas.GraphicsContext;

public abstract class Drawer <Shape> {
    public abstract void draw(GraphicsContext graphicsContext, Shape shape);
}
