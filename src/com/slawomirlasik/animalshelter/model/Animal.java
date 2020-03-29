package com.slawomirlasik.animalshelter.model;

import java.time.LocalDate;

public class Animal {

    private String name;
    private String species;

    private Float weight;

    private LocalDate birthDate;
    private LocalDate admissionDate;

    public Animal(String name, String species, LocalDate birthDate, Float weight) {
      this(name, species, birthDate, weight, LocalDate.now());
    }

    public Animal(String name, String species, LocalDate birthDate, Float weight, LocalDate admissionDate) {
        this.name = name;
        this.species = species;
        this.birthDate = birthDate;
        this.weight = weight;
        this.admissionDate = admissionDate;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public Float getWeight() {
        return weight;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getAge(){
        return LocalDate.now().getYear() - this.birthDate.getYear();
    }
}
