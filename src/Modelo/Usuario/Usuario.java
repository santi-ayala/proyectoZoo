package Modelo.Usuario;

import Modelo.Tarea;

import java.util.ArrayList;

public class Usuario {

    //============================
    //ATRIBUTOS
    //============================
    private String usuario;
    private String contrasenia;
    private EnumTipoUsuario tipo;
    private ArrayList<Tarea> tareas;

    //============================
    //CONSTRUCTORES
    //============================
    public Usuario(String usuario, String contrasenia, EnumTipoUsuario tipo) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    //============================
    //METODOS
    //============================

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
