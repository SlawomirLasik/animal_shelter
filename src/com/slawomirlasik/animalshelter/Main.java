package com.slawomirlasik.animalshelter;

import com.slawomirlasik.animalshelter.model.Shelter;
import com.slawomirlasik.animalshelter.view.Menu;

public class Main {

    //TODO SL:Add limit of animals in shelter
    // TODO SL:Check before adding new animals to shelter if limit of them are reached or not

    public static void main(String[] args) {

        Menu menu = new Menu(new Shelter("Animal Heaven", 10));
        menu.showMenu();
    }
}
