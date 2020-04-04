package com.slawomirlasik.animalshelter.model;

import java.util.HashSet;

public class Shelter extends ExtensionClass {

    private String nameOfTheShelter;

    public Shelter(String nameOfTheShelter) {
        super();
        this.nameOfTheShelter = nameOfTheShelter;
    }

    public static void addNewAnimalToTheShelter(Animal animal) {
        Animal.getExtension(Animal.class).add(animal);
    }

    public static void printAllAnimalsCurrentlyInTheShelter(){
        getExtension(Animal.class).stream().forEach(System.out::println);
    }

    public static Object pickAnimalFromShelter() {

        return null;
    }

    public static void deleteSelectedAnimalFromShelter(Object pickAnimalFromShelter) {
    }


    public String getNameOfTheShelter() {
        return nameOfTheShelter;
    }

    public void setNameOfTheShelter(String nameOfTheShelter) {
        this.nameOfTheShelter = nameOfTheShelter;
    }
}
