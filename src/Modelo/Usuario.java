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

    //TODO: debería ser privado! hacerlo rompería las funciones en zoologico
    //me importa un carajo, hay un getter
    private ArrayList<Tarea> tareas;

    //============================
    //CONSTRUCTORES
    //============================
    public Usuario(String usuario, String contrasenia, TipoUsuario tipo, String nombre) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.nombre = nombre;

        tareas = new ArrayList<Tarea>();
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

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    //Nuestro equals compara unicamente nombres de usuario sin diferenciar letras mayusculas
    public boolean equals(Object o) {
        boolean sonIguales = false;
        if(o != null && o instanceof Usuario){
            Usuario usuario1 = (Usuario) o;
            if(usuario1.getUsuario().equalsIgnoreCase(usuario)){
                sonIguales = true;
            }
        }
        return sonIguales;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
