package Modelo;

import java.util.ArrayList;
import java.util.Collection;

public interface ICRUDE<T> {

    boolean darDeAlta(T t);
    boolean darDeBaja(T t);
    ArrayList<T> listado();
    boolean modificar(T objetoOriginal, T objetoModificado);
}
