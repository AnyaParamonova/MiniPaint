package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

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
        Painter painter = new Painter(graphicsContext, Circle.class, Rectangle.class, Hexagon.class, Star.class, Heart.class, Pika.class);
        ArrayList<Shape> list = createList();
        list.forEach(painter::draw);

    }

    private ArrayList<Shape> createList(){
        ArrayList<Shape> list = new ArrayList();
        list.add(new Circle(100,100,60));
        list.add(new Rectangle(400,600,100,150));
        list.add(new Hexagon(100,100,60));
        list.add(new Star(200, 200, 100));
        list.add(new Heart(200, 400, 50));
        list.add(new Pika(400, 200, 80));
        return list;
    }

}
