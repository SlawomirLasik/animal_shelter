package com.slawomirlasik.animalshelter.view;

import com.slawomirlasik.animalshelter.model.Animal;
import com.slawomirlasik.animalshelter.model.Shelter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Menu {

    public static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    private final String STARTING_MESSAGE_INFO = "Welcome to AnimalShelter management system. \nWhat do you want to do?";
    private final String ADDING_NEW_ANIMAL_MESSAGE = "Add new animal";
    private final String PRINTING_ALL_ANIMALS_IN_SHELTER_MESSAGE = "Print All Animals currently in the shelter";
    private final String DELETE_AN_SELECTED_ANIMAL = "Delete animal from shelter";

    private Shelter shelter;


    public Menu(Shelter shelter) {
        this.shelter = shelter;
    }

    public void showMenu() {
        Boolean exit = false;

        while (!exit) {
            System.out.printf("%s%n", STARTING_MESSAGE_INFO);
            ;
            System.out.printf("1 - %s?%n", ADDING_NEW_ANIMAL_MESSAGE);
            System.out.printf("2 - %s?%n", PRINTING_ALL_ANIMALS_IN_SHELTER_MESSAGE);
            System.out.printf("3 - %s?%n", DELETE_AN_SELECTED_ANIMAL);
            // TODO SL:Add option to finish program
            String inputString;
            try {
                System.out.print(">");
                inputString = console.readLine();


                switch (inputString) {
                    case "1": {
                        addNewAnimalToShelter();
                        break;
                    }
                    case "2": {
                        printDetailedInformationAboutShelter();
                        break;
                    }
                    case "3": {
                        shelter.deleteSelectedAnimalFromShelter(shelter.pickAnimalFromShelter());
                        break;
                    }
                    default:
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException ex) {
                continue;
            }
        }


    }

    private void printDetailedInformationAboutShelter() {
        // TODO SL:set maximum capacity animals that shelter can adopt
        // TODO SL:add info how many maximum space left for new animals
        // TODO SL:add info how many spaces from the pool of maximum are taken
        // TODO SL:add info how many species of each animal there are in shelter


    }

    private void printingAllAnimalsInTheShelter() {
        shelter.printAllAnimalsCurrentlyInTheShelter();
    }

    private void addNewAnimalToShelter() {
//        private String name;
//        private String species;
//
//        private Float weight;
//
//        private LocalDate birthDate;
//        private LocalDate admissionDate;
        // get all data from user for a new animal (String name, String species, LocalDate birthDate, Float weight)
        try {
            shelter.addNewAnimalToTheShelter(new Animal(
                    getDataFromUser("Give name of an animal"),
                    getDataFromUser("Give species of an animal"),
                    getDateFromString(getDataFromUser("Give birth date of an animal [DD-MM-YYYY]")),
                    Float.parseFloat(getDataFromUser("Give animal weight (in kilograms)")))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create a class of new animal
        // add new animal to extention animal
    }

    private LocalDate getDateFromString(String dataFromUser) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-y");
        return LocalDate.parse(dataFromUser, formatter);
    }

    private String getDataFromUser(String message) throws IOException {
        System.out.printf("%s%n", message);
        return console.readLine();
    }
}
