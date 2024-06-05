package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Zoologico {
    //============================
    //ATRIBUTOS
    //============================
    private String nombre;
    private Usuario admin;
    private ColeccionArray<Usuario> coleccionUsuario;
    private ColeccionArray<Animal> coleccionAnimal;
    private float balance;
    private LocalDate fechaDeinicio;
    private LocalDate fechaActual;
    private HashMap<LocalDate, Reporte> historial;


    //============================
    //CONSTRUCTORES
    //============================
    public Zoologico(String nombreZoo, Usuario admin) {
        this.nombre = nombre;
        if(admin.getTipoUsuario() == TipoUsuario.ADMINISTRADOR)
            this.admin = admin;


        balance = 0f;

    }
    //============================
    //Getter and Setters
    //============================

    public ColeccionArray<Usuario> getColeccionUsuario() {
        return coleccionUsuario;
    }

    public void setColeccionUsuario(ColeccionArray<Usuario> coleccionUsuario) {
        this.coleccionUsuario = coleccionUsuario;
    }

    public ColeccionArray<Animal> getColeccionAnimal() {
        return coleccionAnimal;
    }

    public void setColeccionAnimal(ColeccionArray<Animal> coleccionAnimal) {
        this.coleccionAnimal = coleccionAnimal;
    }


    //============================
    //MÉTODOS
    //============================

    public void generar_y_guardar_reporte(){
        //Genera un reporte, y después lo guarda en nuestro hashmap!
        //utiliza como clave del hashmap fechaActual
    }
    public int buscarXusuarioYcontra(String usuario, String contra){
        int posicion = 0, posicionReal = -1;
        for(Usuario usuario1: getColeccionUsuario().gettArrayList()){
            if(usuario1.getUsuario().equalsIgnoreCase(usuario) && usuario1.getContrasenia().equalsIgnoreCase(contra)){
                posicionReal = posicion;
            }
            posicion++;
        }
        return posicionReal;
    }





}
