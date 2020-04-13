package com.slawomirlasik.animalshelter.model;

import com.slawomirlasik.animalshelter.view.Menu;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;

public class Shelter extends ExtensionClass implements Serializable {

    private Integer maximumCapacityOfAnimalsInShelter;

    private String nameOfTheShelter;

    public Shelter(String nameOfTheShelter, Integer maximumCapacityOfAnimalsInShelter) {
        super();
        this.maximumCapacityOfAnimalsInShelter = maximumCapacityOfAnimalsInShelter;
        this.nameOfTheShelter = nameOfTheShelter;
    }

    public void addNewAnimalToTheShelter(Animal animal) {
        Animal.getExtension(Animal.class).add(animal);
        System.out.println("Animal added..");
    }

    public void printAllAnimalsCurrentlyInTheShelter() {
        Optional.ofNullable(getExtension(Animal.class)).map(Collection::stream).
                orElseGet(Stream::empty).forEach(System.out::println);
    }


    public Animal pickAnimalFromShelter() throws IOException {
        System.out.println("Pick Animal ID for deletion:");
        printAllAnimalsCurrentlyInTheShelter();

        System.out.print(">");
        String input = Menu.console.readLine();

        return ((HashSet<Animal>) getExtension(Animal.class)).stream().
                filter(animal -> animal.getID().equals(new Long(input))).findFirst().get();
    }

    public Animal getAnimalById(Long id){
        System.out.println("Animal deleted ...");
        return ((HashSet<Animal>) getExtension(Animal.class)).stream().
                filter(animal -> animal.getID().equals(id)).findFirst().get();
    }


    public void deleteSelectedAnimalFromShelter(Animal pickedAnimalFromShelter) throws IOException {
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

    public Integer getNumberAnimalsInTheShelter() {
        return getExtension(Animal.class) != null ? getExtension(Animal.class).size() : 0;
    }

    public Boolean checkIfShelterIsFull(){
        return getNumberAnimalsInTheShelter() == this.maximumCapacityOfAnimalsInShelter;
    }


}
