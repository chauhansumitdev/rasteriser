package com.rasteriser.core;

public class Color {

    public double x;
    public double y;
    public double z;

    public Color(){

    }

    public Color(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public Color add(Color other){
        return new Color(this.x + other.x , this.y+other.y, this.z+other.z);
    }

    public Color subtract(Color other){
        return new Color(this.x - other.x , this.y- other.y, this.z-other.z);
    }

    public Color multiply_by_scalar(double value){
        return new Color(this.x *value, this.y*value, this.z*value);
    }

    public Color divide_by_scalar(double value){
        return new Color(this.x/value, this.y/value, this.z/value);
    }

}