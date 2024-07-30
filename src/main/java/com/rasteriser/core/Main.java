package com.rasteriser.core;

import com.rasteriser.addons.Converter;
import com.rasteriser.addons.Image;

public class Main {
    public static void main(String[] args) {

        Image image = new Image(1,10);

        image.setPixel(0,0, new Color(0.5,1,1));

        image.createFile("out.ppm");

        Converter converter = new Converter();

        converter.convert(new String[]{"out.ppm", "out.jpg"});
    }
}
