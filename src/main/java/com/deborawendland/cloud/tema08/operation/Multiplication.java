package com.deborawendland.cloud.tema08.operation;

public class Multiplication implements Operation {

    private double firstTerm;
    private double secondTerm;

    public Multiplication(double firstTerm, double secondTerm) {
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
    }

    @Override
    public double doOperation() {
        return firstTerm * secondTerm;
    }

    @Override
    public String toString(){
        return "{\"" + this.getClass().getSimpleName() + "\": {" +
                "\"terms\": [" + firstTerm + ", " + secondTerm  + "]}}";
    }
}
