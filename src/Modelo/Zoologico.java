package Modelo;


import Modelo.animal.Animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Zoologico {
    //============================
    //ATRIBUTOS
    //============================
    private String nombre;
    private Usuario admin;

    private ColeccionArray<T> coleccionArray;
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
    public Zoologico(String nombre, Usuario admin) {
        this.nombre = nombre;
        if(admin.getTipoUsuario() == TipoUsuario.ADMINISTRADOR)
            this.admin = admin;


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

    public boolean darDeBaja(String usuario, String contrasenia){

    }//Esta función lo que hace es dar de baja a un usuario, retorna un boolean si se realizo o no

    public boolean darDeAlta(String usuario, String contrasenia,TipoUsuario tipoUsuario){
        boolean esFalso = false;
        Usuario usuario1 = new Usuario(usuario,contrasenia,tipoUsuario);

        return esFalso;
    }//Esta función lo que hace es dar de baja a un usuario, retorna un boolean si se realizo o no
    public Usuario buscarSegunContraseniaUsuario(String usuario, String contra){
        Usuario usuario1= null;
        for (Usuario usuario2: plantilla){
            if(usuario2.getContrasenia() == contra && usuario2.getUsuario().equalsIgnoreCase(usuario)){
                usuario1 = usuario2;
            }
        }
        return usuario1;
    }


    @Override
    public boolean darDeBaja(T t) {
        boolean esFalso = false;
        if (t instanceof Usuario){
            Usuario usuario1 = (Usuario) t;
            int i = plantilla.indexOf(usuario1);
            if(i != -1){
                esFalso = plantilla.remove(usuario1);
            }

        }else{
            Modelo.animal.Animal animal = (Modelo.animal.Animal) t;

        }

        return esFalso;
    }

    @Override
    public boolean darDeAlta(T t) {
        return null;
    }
}
