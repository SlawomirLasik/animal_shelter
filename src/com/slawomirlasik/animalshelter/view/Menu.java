package com.slawomirlasik.animalshelter.view;

import com.slawomirlasik.animalshelter.model.Animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Menu {

    static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    private final String STARTING_MESSAGE_INFO = "Welcome to AnimalShelter management system. \nWhat do you want to do?";
    private final String ADDING_NEW_ANIMAL_MESSAGE = "Add new animal";

    public Menu() {
    }

    public void showMenu() {
        Boolean exit = false;

        while (!exit) {
            System.out.printf("%s%n", STARTING_MESSAGE_INFO);
            ;
            System.out.printf("1 - %s?%n", ADDING_NEW_ANIMAL_MESSAGE);
            String inputString;
            try {
                System.out.print(">");
                inputString = console.readLine();


                switch (inputString) {
                    case "1": {
                        System.out.println("CREATING NEW ANIMAL");
                        addNewAnimalToShelter();
                    }
                    break;
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
            System.out.println(new Animal(
                    getDataFromUser("Give name of an animal"),
                    "",
                    LocalDate.now(),
                    2f)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create a class of new animal
        // add new animal to extention animal
    }

    private String getDataFromUser(String message) throws IOException {
        System.out.printf("%s%n", message);
        return console.readLine();
    }
}
