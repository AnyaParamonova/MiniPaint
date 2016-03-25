package sample.Figures;

public class Shape {

    private Point leftUpCorner;
    private Point rightDownCorner;

    public Point getLeftUpCorner(){
        int xUp = leftUpCorner.getX(), yUp = leftUpCorner.getY(),
                xDown = rightDownCorner.getX(), yDown = rightDownCorner.getY();
        if(xUp < xDown && yUp < yDown) {
            return leftUpCorner;
        }
        if(xUp > xDown && yUp > yDown) {
            return rightDownCorner;
        }
        if(xUp < xDown && yUp > yDown) {
            return new Point(xUp, yDown);
        }
        if(xUp > xDown && yUp < yDown) {
            return new Point(xDown, yUp);
        }
        return new Point(0,0);
    }

    public void setLeftUpCorner(Point lc){
        leftUpCorner = lc;
    }

    public void setRightDownCorner(Point rc){
        rightDownCorner = rc;
    }

    public int getHeight(){
        if(rightDownCorner.getY() > leftUpCorner.getY()) {
            return rightDownCorner.getY() - leftUpCorner.getY();
        } else{
            return leftUpCorner.getY() - rightDownCorner.getY();
        }
    }

    public int getWidth(){
        if(rightDownCorner.getX() > leftUpCorner.getX()) {
            return rightDownCorner.getX() - leftUpCorner.getX();
        } else{
            return leftUpCorner.getX() - rightDownCorner.getX();
        }
    }

    public Point getCenter(){
        int x = leftUpCorner.getX() + getWidth()/2;
        int y = leftUpCorner.getY() + getHeight()/2;
        return new Point(x, y);
    }
}
