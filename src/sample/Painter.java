package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import java.lang.reflect.Method;
import java.util.HashMap;
import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;

public class Painter {

    private GraphicsContext graphicsContext;
    private HashMap<String, Method> map;

    public Painter(GraphicsContext gc, Class...figures){
        graphicsContext = gc;
        graphicsContext.setStroke(Color.BLUE);
        createMap(figures);
    }

    private void createMap(Class[] figures){
        try {
            map = new HashMap<String, Method>();
            Method method;
            for (Class figure: figures) {
                method = Painter.class.getDeclaredMethod("drawFigure", figure);
                map.put(figure.getSimpleName(), method);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Error initializing map");
        }
    }

    public void draw(Shape shape){
        try {
            Method method = map.get(shape.getClass().getSimpleName());
            method.invoke(this, shape);
        } catch (Exception e) {
            System.out.println("Error drawing");
        }
    }

    private void drawFigure(Circle circle){
        int radius = circle.getRadius(),
            left_up_corner_x = circle.getCenter_x()-radius,
            left_up_corner_y = circle.getCenter_y()-radius;
        graphicsContext.strokeOval(left_up_corner_x, left_up_corner_y, 2*radius, 2*radius);
    }

    private void drawFigure(Rectangle rectangle){
        int left_up_corner_x = rectangle.getCenter_x()-rectangle.getWidht()/2,
            left_up_corner_y = rectangle.getCenter_y()-rectangle.getHeight()/2,
            weight = rectangle.getWidht(),
            height =  rectangle.getHeight();
        graphicsContext.strokeRect(left_up_corner_x, left_up_corner_y, weight, height);
    }

    private void drawFigure(Hexagon hexagon){
        int x = hexagon.getCenter_x(),
            y = hexagon.getCenter_y(),
            r = hexagon.getRadius();
        double pi = 3.14;
        graphicsContext.moveTo(x+r, y);
        for(int i = 1; i < 7; i++) {
            graphicsContext.lineTo(x + r*cos(i*2*pi/6), y + r*sin(i*2*pi/6));
        }
        graphicsContext.stroke();
    }

    private void drawFigure(Star star){
        int r = star.getRadius(),
            x = star.getCenter_x(),
            y = star.getCenter_y();
        double pi = 3.14;
        double angle = 18;

        graphicsContext.moveTo(x+r*cos(angle*2*pi/360), x-r*sin(angle*2*pi/360));
        for(int i = 0; i < 5; i++){
            angle += 36;
            graphicsContext.lineTo(x+r/2*cos(angle*2*pi/360), x-r/2*sin(angle*2*pi/360));
            angle += 36;
            if(angle > 360){
                angle = 18;
            }
            graphicsContext.lineTo(x+r*cos(angle*2*pi/360), x-r*sin(angle*2*pi/360));
        }
        graphicsContext.stroke();
    }

    private void drawFigure(Heart heart){
        int r = heart.getRadius(),
            x = heart.getCenter_x(),
            y = heart.getCenter_y();

        graphicsContext.strokeArc(x+r/2, y-r/2, r, r, -90, 270, ArcType.OPEN);
        graphicsContext.strokeArc(x-r/2, y-r/2, r, r, 0, 270, ArcType.OPEN);
        graphicsContext.strokeArc(x+r/2, y+r/2, r, r, 90, 90, ArcType.OPEN);
        graphicsContext.strokeArc(x-r/2, y+r/2, r, r, 0, 90, ArcType.OPEN);
    }

    private void drawFigure(Pika pika){
        int r = pika.getRadius(),
                x = pika.getCenter_x(),
                y = pika.getCenter_y();

        graphicsContext.strokeArc(x+r/2, y-r/2, r, r, 180, 90, ArcType.OPEN);
        graphicsContext.strokeArc(x-r/2, y-r/2, r, r, 270, 90, ArcType.OPEN);
        graphicsContext.strokeArc(x+r/2, y+r/2, r, r, 180, 270, ArcType.OPEN);
        graphicsContext.strokeArc(x-r/2, y+r/2, r, r, 90, 270, ArcType.OPEN);

        graphicsContext.strokeArc(x-r/2, y+r/2, r, 1.2*r, 270, 90, ArcType.OPEN);
        graphicsContext.strokeArc(x+r/2, y+r/2, r, 1.2*r, 180, 90, ArcType.OPEN);
        graphicsContext.strokeLine(x, y+1.7*r, x+r, y+1.7*r);
    }
}
