package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Zoologico {
    //============================
    //ATRIBUTOS
    //============================
    private String nombre;
    private Usuario admin;
    private ICRUDE<Usuario> coleccionUsuario;
    private ICRUDE<Animal> coleccionAnimal;
    private float balance;

    LocalDate fechaDeInicio;
    LocalDate fechaActual;

    private HashMap<LocalDate, Reporte> historial;


    //============================
    //CONSTRUCTORES
    //============================
    public Zoologico(String nombreZoo, Usuario admin) {
        this.nombre = nombre;

        if(admin.getTipoUsuario() == TipoUsuario.ADMINISTRADOR)
            this.admin = admin;

        coleccionUsuario = new ColeccionArray<Usuario>();
        coleccionAnimal = new ColeccionArray<Animal>();

        fechaDeInicio = LocalDate.now();
        fechaActual = fechaDeInicio;
        balance = 0f;
    }

    //============================
    //MÉTODOS
    //============================

    public void generar_y_guardar_reporte(){
        //Genera un reporte, y después lo guarda en nuestro hashmap!
        //utiliza como clave del hashmap fechaActual
    }





}
