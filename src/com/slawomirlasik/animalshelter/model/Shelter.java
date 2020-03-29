package com.slawomirlasik.animalshelter.model;

public class Shelter extends ExtensionClass {

    private String nameOfTheShelter;

    public Shelter(String nameOfTheShelter) {
        super();
        this.nameOfTheShelter = nameOfTheShelter;
    }


    public String getNameOfTheShelter() {
        return nameOfTheShelter;
    }

    public void setNameOfTheShelter(String nameOfTheShelter) {
        this.nameOfTheShelter = nameOfTheShelter;
    }
}
