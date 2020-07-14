package com.example.conversion.models;


public class Conversion {
    
    private final double value;
    private final String unit;



    public Conversion(double value, String unit){

        this.value = value;
        this.unit = unit; 
    }

    public double getValue(){
        return value;
    }

    public String getUnit(){
        return unit;
    }


}