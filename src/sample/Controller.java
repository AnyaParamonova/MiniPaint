package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import sample.Drawers.*;
import sample.Figures.*;

public class Controller {
    Drawer drawer;
    Shape shape;

    @FXML
    private Canvas canvas;
    Artist artist = new Artist(canvas);


    public void onPikaButtonAction(ActionEvent actionEvent) {
        drawer = new PikaDrawer();
        shape = new Pika();
        artist.setCurrentFigure(shape, drawer);
    }

    public void onCircleButtonAction(ActionEvent actionEvent) {
        drawer = new CircleDrawer();
        shape = new Circle();
        artist.setCurrentFigure(shape, drawer);
    }

    public void onRectangleButtonAction(ActionEvent actionEvent) {
        shape = new Rectangle();
        drawer = new RectangleDrawer();
        artist.setCurrentFigure(shape, drawer);
    }

    public void onHeartButtonAction(ActionEvent actionEvent) {
        shape = new Heart();
        drawer = new HeartDrawer();
        artist.setCurrentFigure(shape, drawer);
    }

    public void onStarButtonAction(ActionEvent actionEvent) {
        shape = new Star();
        drawer = new StarDrawer();
        drawer.draw(canvas.getGraphicsContext2D(), shape);
    }

    public void onHexagonButtonAction(ActionEvent actionEvent) {
        shape = new Hexagon();
        drawer = new HexagonDrawer();
        artist.setCurrentFigure(shape, drawer);
    }

}
