package com.slawomirlasik.animalshelter.tests;

import com.slawomirlasik.animalshelter.model.Animal;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnimalTest {

    public void testIfAnimalClassIsCreatedNormally() throws IOException, ClassNotFoundException {
        // here test if when creating new animal class it is correctly added to extension
        // and if extension has this new object of animal class

        
        new Animal("shaki", "dog",
                LocalDate.parse("11-11-1111",  DateTimeFormatter.ofPattern("d-M-y")), 20.1f);

        Animal.printExtension(Animal.class);

        Animal.saveExtensionsToFile();

    }

    public static void main(String[] args) {
        AnimalTest animalTest = new AnimalTest();
        try {
            animalTest.testIfAnimalClassIsCreatedNormally();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
