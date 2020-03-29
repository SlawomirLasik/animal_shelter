package com.slawomirlasik.animalshelter.view;

public class Menu {

    private final String STARTING_MESSAGE_INFO = "Welcome to AnimalShelter management system. \nWhat do you want to do?";

    public Menu() {

    }

    public void showMenu() {
        System.out.printf("%s", STARTING_MESSAGE_INFO);;
    }
}
