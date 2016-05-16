package main.Figures;

import plugin_api.*;

public class Star extends Shape {

    public int getWidthRadius(){
        return getWidth()/2;
    }

    public  int getHeightRadius(){
        return getHeight()/2;
    }
}
