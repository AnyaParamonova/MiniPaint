package sample.Drawers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import sample.Figures.Shape;

import java.util.ArrayList;

public class Artist {

    private Canvas canvas;
    private DrawingFigure drawingFigure;
    private ArrayList<DrawingFigure> figureList;

    public Artist(){
        figureList = new ArrayList<>();
    }

    public void setCanvas(Canvas c){
        canvas = c;
    }

    public void setCurrentFigure(Shape shape, Drawer drawer) {
        drawingFigure = new DrawingFigure(shape, drawer);
    }

    public void drawCurrentFigure(){
        repaintAddedFigures();
        drawingFigure.drawFigure(canvas.getGraphicsContext2D());
    }

    public void changeFigure(Shape sh){
        drawingFigure.setShape(sh);
    }

    public void addFigure(){
        figureList.add(drawingFigure);
        repaintAddedFigures();
    }

    private void clearCanvas(){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0,0,canvas.getWidth(),canvas.getHeight() );
    }

    private void repaintAddedFigures(){
        clearCanvas();
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        for(DrawingFigure figure : figureList){
            figure.drawFigure(graphicsContext);
        }
    }

    private class DrawingFigure{
        private Shape shape;
        private Drawer drawer;

        public DrawingFigure(Shape sh, Drawer dr){
            shape = sh;
            drawer = dr;
        }

        public void setShape(Shape sh){
            shape = sh;
        }
        public Shape getShape(){
            return shape;
        }

        public void drawFigure(GraphicsContext graphicsContext){
            drawer.draw(graphicsContext, shape);
        }
    }
}
