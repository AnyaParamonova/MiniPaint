package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import sample.Drawers.*;
import sample.Figures.*;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();

        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(800, 800);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        drawShapes(graphicsContext);
        root.getChildren().add(canvas);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void drawShapes(GraphicsContext graphicsContext){
        Drawer drawer;
        Shape shape;

        shape = new Circle(100,100,60);
        drawer = new CircleDrawer();
        drawer.draw(graphicsContext, shape);

        shape = new Rectangle(400,600,100,150);
        drawer = new RectangleDrawer();
        drawer.draw(graphicsContext, shape);

        shape = new Hexagon(100,100,60);
        drawer = new HexagonDrawer();
        drawer.draw(graphicsContext, shape);

        shape = new Star(200, 200, 100);
        drawer = new StarDrawer();
        drawer.draw(graphicsContext, shape);

        shape = new Heart(200, 400, 50);
        drawer = new HeartDrawer();
        drawer.draw(graphicsContext, shape);

        shape = new Pika(400, 200, 80);
        drawer = new PikaDrawer();
        drawer.draw(graphicsContext, shape);

    }

}
