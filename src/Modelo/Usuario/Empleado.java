package Modelo.Usuario;

import Modelo.Tarea;

import java.util.ArrayList;

public class Empleado extends Usuario {

private ArrayList<Tarea> tareas;

    public Empleado(String usuario, String contraseña) {
        super(usuario, contraseña);
        this.tareas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "tareas=" + tareas +
                '}';
    }
}
