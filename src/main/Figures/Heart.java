package main.Figures;

import plugin_api.*;

public class Heart extends Shape {
    public int getWidthRadius(){
        return getWidth()/4;
    }

    public  int getHeightRadius(){
        return getHeight()/2;
    }
}
