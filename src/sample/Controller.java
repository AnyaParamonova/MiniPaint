package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import sample.Drawers.*;
import sample.Figures.*;

public class Controller {
    Shape currentShape = null;
    @FXML
    private Canvas canvas;
    Artist artist = new Artist();

    public void onPikaButtonAction(ActionEvent actionEvent) {
        Drawer drawer = new PikaDrawer();
        currentShape = new Pika();
        artist.setCurrentFigure(currentShape, drawer);
    }

    public void onCircleButtonAction(ActionEvent actionEvent) {
        Drawer drawer = new CircleDrawer();
        currentShape= new Circle();
        artist.setCurrentFigure(currentShape, drawer);
    }

    public void onRectangleButtonAction(ActionEvent actionEvent) {
        Drawer drawer = new RectangleDrawer();
        currentShape = new Rectangle();
        artist.setCurrentFigure(currentShape, drawer);
    }

    public void onHeartButtonAction(ActionEvent actionEvent) {
        Drawer drawer = new HeartDrawer();
        currentShape = new Heart();
        artist.setCurrentFigure(currentShape, drawer);
    }

    public void onStarButtonAction(ActionEvent actionEvent) {
        Drawer drawer = new StarDrawer();
        currentShape = new Star();
        artist.setCurrentFigure(currentShape, drawer);
    }

    public void onHexagonButtonAction(ActionEvent actionEvent) {
        Drawer drawer = new HexagonDrawer();
        currentShape = new Hexagon();
        artist.setCurrentFigure(currentShape, drawer);
    }

    public void canvasOnMousePressed(MouseEvent event) {
        if(currentShape !=null){
            artist.setCanvas(canvas);
            Point leftUpCorner = new Point((int)event.getX(),(int)event.getY());
            currentShape.setLeftUpCorner(leftUpCorner);
            artist.changeFigure(currentShape);
        }

    }
    public void canvasOnMouseDragged(MouseEvent event) {
        if(currentShape !=null){
            Point rightDownCorner = new Point((int)event.getX(), (int)event.getY());
            currentShape.setRightDownCorner(rightDownCorner);
            artist.changeFigure(currentShape);
            artist.drawCurrentFigure();
        }

    }

    public void canvasOnMouseReleased(MouseEvent event) {
        if(currentShape !=null){
            artist.addFigure();
            currentShape = null;
        }

    }


}
