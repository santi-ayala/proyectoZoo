package Modelo;

import java.util.ArrayList;

public class Usuario {

    //============================
    //ATRIBUTOS
    //============================
    private String nombre;
    private String usuario;
    private String contrasenia;
    private TipoUsuario tipo;
    private ArrayList<Tarea> tareas;




    //============================
    //CONSTRUCTORES
    //============================
    public Usuario(String usuario, String contrasenia, TipoUsuario tipo, String nombre) {
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

    public TipoUsuario getTipoUsuario() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }
}
