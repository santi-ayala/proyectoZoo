package Modelo;

import java.util.Collection;

public interface ICRUDE<T> {

    boolean darDeAlta(T t);
    boolean darDeBaja(T t);
    Collection<T> listado();
    boolean modificar(T objetoOriginal, T objetoModificado);
}
