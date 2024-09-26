package com.rasteriser.core;

import com.rasteriser.addons.Image;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Wireframe {

    public Wireframe(String file_path, Image image) {
        create_wire_frame(file_path, image);
    }

    public static void create_wire_frame(String path, Image image) {

        List<String[]> vertices = new ArrayList<>();

        int height = image.rows/2;
        int width = image.cols/2;

        System.out.println(height+" "+width);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty() && line.charAt(0) == 'v' && line.charAt(1) == ' ') {
                    String[] curr = line.trim().split("\\s+");
                    vertices.add(curr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = br.readLine()) != null){
                if (!line.isEmpty() && line.charAt(0) == 'f' && !line.contains("/")) {

                    String[] face = line.split(" ");

                    String[] vertex0 = vertices.get(Integer.parseInt(face[1])-1);
                    String[] vertex1 = vertices.get(Integer.parseInt(face[2])-1);
                    String[] vertex2 = vertices.get(Integer.parseInt(face[3])-1);


                    int x1 = (int) Double.parseDouble(vertex0[1])+width;
                    int x2 = (int) Double.parseDouble(vertex1[1])+width;
                    int x3 = (int) Double.parseDouble(vertex2[1])+width;

                    int y1 = (int) Double.parseDouble(vertex0[2])+height;
                    int y2 = (int) Double.parseDouble(vertex1[2])+height;
                    int y3 = (int) Double.parseDouble(vertex2[2])+height;

                    Line.draw_line(x1, y1, x2, y2, image, new Color(1,0,0));
                    Line.draw_line(x2, y2, x3, y3, image, new Color(1,0,0));
                    Line.draw_line(x1, y1, x3, y3, image, new Color(1,0,0));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
