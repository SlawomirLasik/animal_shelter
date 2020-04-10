package com.slawomirlasik.animalshelter;

import com.slawomirlasik.animalshelter.model.Shelter;
import com.slawomirlasik.animalshelter.view.Menu;

public class Main {


    public static void main(String[] args) {

        if(args.length > 0){
            Menu menu = new Menu(new Shelter("Animal Heaven", 1));
            menu.runCommand(args);
        }
        else{
            Menu menu = new Menu(new Shelter("Animal Heaven", 1));
            menu.showMenu();
        }
    }
}
