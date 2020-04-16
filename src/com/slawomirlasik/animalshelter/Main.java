package com.slawomirlasik.animalshelter;

import com.slawomirlasik.animalshelter.model.Shelter;
import com.slawomirlasik.animalshelter.view.Menu;

public class Main {

    private static final Integer MAXIMUM_OF_ANIMALS_IN_THE_SHELTER = 10;

    public static void main(String[] args) {

        if(args.length > 0){
            Menu menu = new Menu(new Shelter("Animal Heaven", MAXIMUM_OF_ANIMALS_IN_THE_SHELTER));
            menu.runCommand(args);
        }
        else{
            Menu menu = new Menu(new Shelter("Animal Heaven", MAXIMUM_OF_ANIMALS_IN_THE_SHELTER));
            menu.showMenu();
        }
    }
}
