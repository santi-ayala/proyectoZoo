package Modelo.Controladores;

import Modelo.*;


import java.util.ArrayList;
import java.util.Random;

import static Modelo.Utils.scanner;

public class MenuEmpleado {
    public static String archivoZoo = "ArchivoZoo.dat";
    Zoologico zoo;

    Usuario empleado;


    public MenuEmpleado(Zoologico zoo, Usuario empleado) {
        this.zoo = zoo;
        this.empleado = empleado;
    }

    //============================
    //MÉTODOS
    //============================

    //Generar numero random

    public static int getRandomNumber() {
        Random random = new Random();
        int min = 35;
        int max = 150;
        return random.nextInt((max - min + 1)) + min;
    }

    public void mainLoop() {
        boolean quiereSalir = false;
        String eleccion;

        while (!quiereSalir) {
            System.out.println("Bienvenido " + empleado.getNombre() + "!");
            System.out.println("1) Marcar tarea completada");
            System.out.println("2) Curar Animal");
            System.out.println("3) Ver entradas vendidas");
            System.out.println("4) Cambiar contraseña");
            System.out.println("5) Salir");

            eleccion = scanner.nextLine();

            switch (eleccion) {
                case "1":
                    Utils.limpiarPantalla();
                    mostrarTareas();
                    System.out.println("Que tarea fue completada?");
                    String tarea;
                    tarea= scanner.nextLine();
                    boolean verificacion;
                   verificacion = marcarTareaCompletada(tarea, empleado);

                   if(verificacion){
                       System.out.println("Tarea completada!");
                   }else{

                       System.out.println("No se encontro la tarea");
                   }


                    break;
                case "2":
                    Utils.limpiarPantalla();
                    mostrarAnimalesEnfermos();
                    System.out.println("Ingrese el animal?");
                    String especie;
                    especie = scanner.nextLine();
                   // boolean verificacion;
                    verificacion = curarAnimal(especie);

                    if(verificacion){
                        System.out.println("Felcitaciones, buen trabajo!");
                    }else{

                        System.out.println("No se encontro la especie");
                    }


                    break;
                case "3":
                    Utils.limpiarPantalla();
                    int randomNumber = getRandomNumber();
                    System.out.println("Las entradas vendidas son : " + randomNumber);

                    break;
                case "4":
                    Utils.limpiarPantalla();
                    System.out.println("Ingrese la nueva contraseña: ");
                    String contrasenia;
                    contrasenia=scanner.nextLine();
                    cambiarContraseniaEmpleado(contrasenia);
                    System.out.println("Contraseña cambiada con exito!");


                    break;
                case "5":
                    Utils.limpiarPantalla();
                    quiereSalir = true;
                    break;
                default:
                    System.out.println("Ingrese un valor válido!");
                    scanner.nextLine();
                    Utils.limpiarPantalla();
            }
        }
    }

    //FUNCIONES EMPLEADO////////////////////////////////////
    public boolean marcarTareaCompletada(String tarea, Usuario empleado){

        boolean verificacion = false;

        ArrayList<Tarea> tareas = empleado.getTareas();

        for(int i=0; i<tareas.size(); i++){

            if(tareas.get(i).getAccion().equals(tarea)){

                tareas.get(i).setCompletado(true);

                verificacion=true;

            }
        }
        return verificacion;

    }

    public boolean curarAnimal(String especie){

        boolean verificacion = true;

        ArrayList<Animal> animales = zoo.getColeccionAnimal().listado();

        for(int i=0; i<animales.size(); i++){

            if(animales.get(i).getEspecie().equals(especie)){

                animales.get(i).setEstaEnfermo(true);

                verificacion=true;

            }else{

                verificacion=false;
            }
        }
        return verificacion;

    }

    public void cambiarContraseniaEmpleado(String contrasenia){
        empleado.setContrasenia(contrasenia);
    }

    public void mostrarAnimalesEnfermos() {

        ArrayList<Animal> animales = zoo.getColeccionAnimal().listado();

        System.out.println("Animales enfermos: \n");
        for(int i=0; i<animales.size();i++){

            if(animales.get(i).getEstaEnfermo()){

                System.out.println(animales.get(i).toString());
                System.out.println("\n");
            }
        }


    }

    public void mostrarTareas(){

        ArrayList<Tarea> tareas= empleado.getTareas();

        for(int i=0; i<tareas.size();i++){

            if(!tareas.get(i).isCompletado()){

                System.out.println(tareas.get(i).toString());
                System.out.println("\n");
            }
        }

    }




}
