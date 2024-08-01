package com.rasteriser.core;

import com.rasteriser.addons.Converter;
import com.rasteriser.addons.Image;


public class Main {
    public static void main(String[] args) {
        Image image = new Image(720,1080);
        //Wireframe.create_wire_frame("src/main/java/com/rasteriser/models/cube.obj",image);
        //Wireframe.create_wire_frame("src/main/java/com/rasteriser/models/cone.obj",image);
        Wireframe.create_wire_frame("src/main/java/com/rasteriser/models/sphere.obj",image);
        Converter converter = new Converter();
        image.createFile("out.ppm");
        converter.convert(new String[]{"out.ppm", "out.png"});
    }
}
