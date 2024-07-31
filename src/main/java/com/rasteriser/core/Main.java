package com.rasteriser.core;

import com.rasteriser.addons.Converter;
import com.rasteriser.addons.Image;

public class Main {
    public static void main(String[] args) {

        Image image = new Image(100,100);

         Line.draw_line(0,0,99,99,image, new Color(0,1,0));
         Line.draw_line(99,0,0,99,image, new Color(0,0,1));
         Line.draw_line(50,0,99,50,image, new Color(1,0,0));
         Line.draw_line(99,50,50,99,image, new Color(1,0,0));
         Line.draw_line(50,99,0,50,image, new Color(1,0,0));
         Line.draw_line(0,50,50,0,image, new Color(1,0,0));


        image.createFile("out.ppm");

        Converter converter = new Converter();

        converter.convert(new String[]{"out.ppm", "out.png"});
    }
}
