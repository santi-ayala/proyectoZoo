package Modelo;

import Modelo.animal.Animal;

import java.util.ArrayList;

public class ColeccionArray<T> implements ICRUDE<T> {
    //Atributos
    private ArrayList<Usuario> plantilla;
    private ArrayList<Animal> animalArrayList;

    //Constructor
    public ColeccionArray() {
        plantilla = new ArrayList<Usuario>();
        animalArrayList = new ArrayList<Animal>();
    }

    @Override
    public boolean darDeAlta(T t) {
        return false;
    }

    @Override
    public boolean darDeBaja(T t) {
        return false;
    }
}
