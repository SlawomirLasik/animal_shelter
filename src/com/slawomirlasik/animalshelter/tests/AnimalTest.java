package com.slawomirlasik.animalshelter.tests;

import com.slawomirlasik.animalshelter.model.Animal;
import com.slawomirlasik.animalshelter.model.Shelter;
import com.slawomirlasik.animalshelter.view.Menu;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnimalTest {

    public void testIfAnimalClassIsCreatedNormally(){
        // here test if when creating new animal class it is correctly added to extension
        // and if extension has this new object of animal class

        new Animal("shaki", "dog",
                LocalDate.parse("11-11-1111",  DateTimeFormatter.ofPattern("d-M-y")), 20.1f);



    }
}
