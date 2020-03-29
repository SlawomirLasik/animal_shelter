package com.slawomirlasik.animalshelter.view;

public class Menu {

    private final String STARTING_MESSAGE_INFO = "Welcome to AnimalShelter management system. \nWhat do you want to do?";
    private final String ADDING_NEW_ANIMAL_MESSAGE = "Add new animal";

    public Menu() {

    }

    public void showMenu() {
        System.out.printf("%s", STARTING_MESSAGE_INFO);;
        System.out.printf("1 - %s", ADDING_NEW_ANIMAL_MESSAGE);
    }
}
