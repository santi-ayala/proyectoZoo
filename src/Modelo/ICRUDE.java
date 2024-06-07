package Modelo;

import java.util.ArrayList;
import java.util.Collection;

public interface ICRUDE<T> {// es para implementar los metodos en las distintas colecciones (animales y empleados)

    boolean darDeAlta(T t);
    boolean darDeBaja(T t);
    ArrayList<T> listado();
    boolean modificar(T objetoOriginal, T objetoModificado);
}
