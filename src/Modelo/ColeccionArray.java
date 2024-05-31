package Modelo;

import java.util.ArrayList;

public class ColeccionArray<T> implements ICRUDE<T> {
    //Atributos
    private ArrayList<T> tArrayList;


    //Constructor
    public ColeccionArray() {
        tArrayList = new ArrayList<>();
    }

    ///
    @Override
    public boolean darDeAlta(T t) {
        return tArrayList.add(t);
    }

    @Override
    public boolean darDeBaja(T t) {
        return tArrayList.remove(t);
    }
}
