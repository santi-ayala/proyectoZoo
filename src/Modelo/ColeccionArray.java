package Modelo;

import java.util.ArrayList;
import java.util.Collection;

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

    @Override
    public ArrayList<T> listado() {
        return tArrayList;
    }

    public boolean modificar(T objetoOriginal, T objetoModificado){
        boolean retorno = false;

        for(T elemento: tArrayList){
            if(elemento.equals(objetoOriginal)){
                int i = tArrayList.indexOf(elemento);
                tArrayList.set(i, objetoModificado);
                retorno = true;
            }
        }
        return retorno;
    }
}
