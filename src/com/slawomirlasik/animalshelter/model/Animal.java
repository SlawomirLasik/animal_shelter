package com.slawomirlasik.animalshelter.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Animal extends ExtensionClass implements Serializable {

    private static Long Current_ID = 0l;

    private Long ID = Current_ID++;

    private String name;
    private String species;

    private Float weight;

    private LocalDate birthDate;
    private LocalDate admissionDate;

    public Animal(String name, String species, LocalDate birthDate, Float weight) {
        this(name, species, birthDate, weight, LocalDate.now());
    }

    public Animal(String name, String species, LocalDate birthDate, Float weight, LocalDate admissionDate) {
        super();
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

    public Integer getAge() {
        return LocalDate.now().getYear() - this.birthDate.getYear();
    }

    public Long getID() {
        return ID;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", birthDate=" + birthDate +
                ", admissionDate=" + admissionDate +
                '}';
    }
}
