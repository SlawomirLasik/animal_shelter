package com.slawomirlasik.animalshelter.view;

import com.slawomirlasik.animalshelter.model.Animal;
import com.slawomirlasik.animalshelter.model.Shelter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class Menu {

    public static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    private final String STARTING_MESSAGE_INFO = "Welcome to AnimalShelter management system. \nWhat do you want to do?";
    private final String ADDING_NEW_ANIMAL_MESSAGE = "Add new animal";
    private final String PRINTING_ALL_ANIMALS_IN_SHELTER_MESSAGE = "Print All Animals currently in the shelter";
    private final String DELETE_AN_SELECTED_ANIMAL = "Delete animal from shelter";
    private final String EXIT_PROGRAM_MESSAGE = "Exit Program";

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
            System.out.printf("4 - %s?%n", EXIT_PROGRAM_MESSAGE);
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
                    case "4": {
                        closeProgram();
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

    private void closeProgram() {
        System.out.println("Saving current status of Shelter to a file...");
        try {
            Shelter.saveExtensionsToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("closing Shelter program, Bye!");
        System.exit(0);
    }

    private void printDetailedInformationAboutShelter() throws IOException {
        System.out.printf("Currently there are %d/%d animals in the shelter%n",
                shelter.getNumberAnimalsInTheShelter(),
                shelter.getMaximumCapacityOfAnimalsInShelter()
        );
        System.out.printf("Shelter can take %d new animals more%n",
                shelter.getMaximumCapacityOfAnimalsInShelter() - shelter.getNumberAnimalsInTheShelter()
        );

        final HashSet<Animal> animals = shelter.getExtension(Animal.class);

        HashSet<String> animalDistinctSpeciesInShelter = new HashSet<>();
        animals.stream().forEach(animal -> animalDistinctSpeciesInShelter.add(animal.getSpecies()));

//        System.out.println(animalDistinctSpeciesInShelter);

        for (String animalSpecies :
                animalDistinctSpeciesInShelter) {
            int counter = 0;
            for (Animal animal :
                    animals) {
                if (animal.getSpecies().equals(animalSpecies)) {
                    counter++;
                }
            }
            System.out.printf("There are %d of %s species in the shelter%n", counter, animalSpecies);

        }
        System.out.println("Press enter key to continue...");
        console.readLine();
        System.out.println();


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
        if (shelter.checkIfShelterIsFull()) {
            System.out.printf("I am sorry, but currently the are %d animals out of %d maximum capacity of the shelter." +
                            " Animal cannot be added here.", shelter.getNumberAnimalsInTheShelter(),
                    shelter.getMaximumCapacityOfAnimalsInShelter());
            return;
        }
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

    public void runCommand(String[] args) {
        String command = args[0];
        switch (command) {
            case "status": {
                try {
                    printDetailedInformationAboutShelter();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "help": {
                break;
            }
            case "?": {
                break;
            }
            case "add": {
                break;
            }
            case "animals": {
                printingAllAnimalsInTheShelter();
                break;
            }
            case "delete": {

                break;
            }
            default:{
                System.out.printf("Unrecognized command %s. run Main ? or Main help for command info", command);;
                System.exit(-1);
                break;
            }
        }
    }
}
