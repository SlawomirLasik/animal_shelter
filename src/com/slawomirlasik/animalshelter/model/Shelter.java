package com.slawomirlasik.animalshelter.model;

import com.slawomirlasik.animalshelter.view.Menu;

import java.io.IOException;
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

    public static Object pickAnimalFromShelter() throws IOException {
        System.out.println("Pick Animal ID for deletion:");
        printAllAnimalsCurrentlyInTheShelter();

        System.out.print(">");
        String input = Menu.console.readLine();

        Animal pickedAnimal = ((HashSet<Animal>)getExtension(Animal.class)).stream().
                filter(animal -> animal.getID().equals(new Long(input))).findFirst();
        System.out.println(pickedAnimal);
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
