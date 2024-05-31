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
    private ArrayList<Usuario> plantilla;
    private ArrayList<Animal> animales;
    private float balance;

    // fecha de inicio:2024/30/05 ---> siempre va a haber un valor
    private LocalDate fechaDeInicio;

    //Cuando vayamos a avanzar la simulación, vamos a almacenar un reporte con
    //una clave fechaActual, y vamos a sumarle un día
    private LocalDate fechaActual;

    private HashMap<LocalDate, Reporte> historial;


    //============================
    //CONSTRUCTORES
    //============================
    public Zoologico(String nombreZoo, Usuario admin) {
        this.nombre = nombre;
        if(admin.getTipoUsuario() == TipoUsuario.ADMINISTRADOR)
            this.admin = admin;

        plantilla = new ArrayList<Usuario>();
        animales = new ArrayList<Animal>();
        balance = 0f;

        fechaDeInicio = LocalDate.now();
        fechaActual = fechaDeInicio;

        historial = new HashMap<LocalDate, Reporte>();
    }

    //============================
    //MÉTODOS
    //============================

    public void generar_y_guardar_reporte(){
        //Genera un reporte, y después lo guarda en nuestro hashmap!
        //utiliza como clave del hashmap fechaActual
    }

    public void avanzarSimulacion(){
        generar_y_guardar_reporte();

        //sumamos un día a nuestra fecha
        fechaActual.plusDays(1);
    }

}
