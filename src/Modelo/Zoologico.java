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


    //Mostrar animales
    public void mostrarAnimales(){

     ArrayList<Animal> animales = coleccionAnimal.listado();

     for(int i=0; i<animales.size();i++){

         System.out.println(animales.get(i));

     }

    }



//FUNCIONES EMPLEADO////////////////////////////////////
    public boolean marcarTareaCompletada(String tarea, Usuario empleado){

        boolean verificacion = true;

        ArrayList<Tarea> tareas = empleado.tareas;

        for(int i=0; i<tareas.size(); i++){

         if(tareas.get(i).getAccion().equals(tarea)){

             tareas.get(i).setCompletado(true);

             verificacion=true;




         }else{

             verificacion=false;

         }

     }

    return verificacion;

    }

    public boolean curarAnimal(String especie){

        boolean verificacion = true;

        ArrayList<Animal> animales = coleccionAnimal.listado();

        for(int i=0; i<animales.size(); i++){

            if(animales.get(i).getEspecie().equals(especie)){

                animales.get(i).setSalud(true);

                verificacion=true;




            }else{

                verificacion=false;

            }

        }

        return verificacion;

    }




//////////////////////////////////////////




}
