package com.rasteriser.core;

public class Vector {

    public double x;
    public double y;
    public double z;

    public Vector(){

    }

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public Vector add(Vector other){
        return new Vector(this.x + other.x , this.y+other.y, this.z+other.z);
    }

    public Vector subtract(Vector other){
        return new Vector(this.x - other.x , this.y- other.y, this.z-other.z);
    }

    public Vector multiply_by_scalar(double value){
        return new Vector(this.x *value, this.y*value, this.z*value);
    }

    public Vector divide_by_scalar(double value){
        return new Vector(this.x/value, this.y/value, this.z/value);
    }

    public double dot_product(Vector other){
        return this.x*other.x + this.y*other.y + this.z+other.z;
    }

    public Vector cross_product(Vector other) {
        return new Vector(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
        );
    }

    public double magnitude(){
        return Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
    }

    public Vector normalize(){
        double this_magnitude = magnitude();
        return new Vector(this.x/this_magnitude, this.y/this_magnitude, this.z/this_magnitude);
    }

    public double distance(Vector other){
        return Math.sqrt(
                (this.x-other.x)*(this.x-other.x)
                        + (this.y-other.y)*(this.y-other.y)
                        + (this.z-other.z)*(this.z-other.z)
        );
    }

    public double angle(Vector other){
        return Math.acos(this.dot_product(other) / (this.magnitude()*other.magnitude()));
    }

    public Vector project(Vector other){
        double val = this.dot_product(this)/ this.dot_product(other);

        return other.multiply_by_scalar(val);
    }

    public Vector reflect(Vector normal){
        return this.subtract(normal.multiply_by_scalar(2 * this.dot_product(normal)));
    }

    public Vector negate(){
        return new Vector(-this.x, -this.y, -this.z);
    }

}