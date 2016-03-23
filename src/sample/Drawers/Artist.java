package sample.Drawers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import sample.Figures.Shape;

import java.util.ArrayList;

public class Artist {

    private Canvas canvas;
    private DrawingFigure drawingFigure;
    private ArrayList<DrawingFigure> figureList;

    public Artist(Canvas c){
        figureList = new ArrayList<>();
        canvas = c;
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

    public void resizeFigure(Shape sh){
        drawingFigure.setShape(sh);
    }
    public void addFigure(){
        figureList.add(drawingFigure);
        repaintAddedFigures();
    }

    private void repaintAddedFigures(){
        for(DrawingFigure figure : figureList){
            figure.drawFigure(canvas.getGraphicsContext2D());
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

        public Drawer getDrawer(){
            return drawer;
        }

        public void drawFigure(GraphicsContext graphicsContext){
            drawer.draw(graphicsContext, shape);
        }
    }
}
