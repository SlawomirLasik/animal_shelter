package com.slawomirlasik.animalshelter.model;

import com.slawomirlasik.animalshelter.view.Menu;

import java.io.IOException;
import java.util.HashSet;

public class Shelter extends ExtensionClass {

    private Integer maximumCapacityOfAnimalsInShelter;

    private String nameOfTheShelter;

    public Shelter(String nameOfTheShelter, Integer maximumCapacityOfAnimalsInShelter) {
        super();
        this.maximumCapacityOfAnimalsInShelter = maximumCapacityOfAnimalsInShelter;
        this.nameOfTheShelter = nameOfTheShelter;
    }

    public static void addNewAnimalToTheShelter(Animal animal) {
        Animal.getExtension(Animal.class).add(animal);
    }

    public static void printAllAnimalsCurrentlyInTheShelter() {
        getExtension(Animal.class).stream().forEach(System.out::println);
    }

    public static Animal pickAnimalFromShelter() throws IOException {
        System.out.println("Pick Animal ID for deletion:");
        printAllAnimalsCurrentlyInTheShelter();

        System.out.print(">");
        String input = Menu.console.readLine();

        return ((HashSet<Animal>) getExtension(Animal.class)).stream().
                filter(animal -> animal.getID().equals(new Long(input))).findFirst().get();
    }


    public static void deleteSelectedAnimalFromShelter(Animal pickedAnimalFromShelter) throws IOException {
        getExtension(Animal.class).remove(pickedAnimalFromShelter);
    }


    public String getNameOfTheShelter() {
        return nameOfTheShelter;
    }

    public void setNameOfTheShelter(String nameOfTheShelter) {
        this.nameOfTheShelter = nameOfTheShelter;
    }

    public Integer getMaximumCapacityOfAnimalsInShelter() {
        return maximumCapacityOfAnimalsInShelter;
    }

    public void setMaximumCapacityOfAnimalsInShelter(Integer maximumCapacityOfAnimalsInShelter) {
        this.maximumCapacityOfAnimalsInShelter = maximumCapacityOfAnimalsInShelter;
    }

}
