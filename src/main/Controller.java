package main;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.scene.paint.Color;
import main.Drawers.*;
import main.Figures.*;
import main.Plugins.PluginLoader;
import plugin_api.*;
import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.ArrayList;

public class Controller {
    private Artist artist = new Artist();
    private Shape currentShape = null;
    private ArrayList<Plugin> plugins;

    @FXML
    private Canvas canvas;
    @FXML
    private FlowPane panel;

    @FXML
    public void initialize(){
        plugins = PluginLoader.getPlugins();
        for (Plugin plugin: plugins) {
            canvas.getGraphicsContext2D().setFill(Color.WHITE);
            canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            Button button = plugin.getButton();
            panel.getChildren().add(button);
            panel.setMargin(button, new Insets(0, 0, 10, 0));
            plugin.setArtist(artist);
        }
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
        for (Plugin plugin: plugins) {
            if(currentShape == null) currentShape = plugin.getCurrentShape();
        }
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

    public void onSaveItemAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(Main.getStage());

        if(file != null){
            try {
                WritableImage writableImage = new WritableImage((int)canvas.getWidth(), (int)canvas.getHeight());
                canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void onLoadItemAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(Main.getStage());

        if(file != null){
            try{
                Image image = new Image(new FileInputStream(file));
                canvas.getGraphicsContext2D().drawImage(image, 0, 0);
                artist.setImage(image);
                artist.clearList();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    public void onClearItemAction(ActionEvent actionEvent) {
        artist.setImage(null);
        artist.clearList();
        canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
