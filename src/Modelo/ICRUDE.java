package Modelo;

import java.util.ArrayList;
import java.util.Collection;

public interface ICRUDE<T> {

    boolean darDeAlta(T t);
    boolean darDeBaja(T t);
    boolean modificar(T objetoOriginal, T objetoModificado);
}
