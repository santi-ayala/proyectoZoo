package Modelo;

import java.util.ArrayList;

public class ColeccionArray<T> implements ICRUDE<T> {
    //Atributos
    private ArrayList<T> tArrayList;


    //Constructor
    public ColeccionArray() {
        tArrayList = new ArrayList<T>();
    }



    ///Metodos
    @Override
    public boolean darDeAlta(T t) {
        boolean duplicado = false;

        for (T elemento: tArrayList){
            if (t.equals(elemento)){
                duplicado = true;
            }
        }

        if (!duplicado){
            tArrayList.add(t);
        }

        //semanticamente raro, devuelve false negado en caso de exito
        return !duplicado;
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
