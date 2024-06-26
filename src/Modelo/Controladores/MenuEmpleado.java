package Modelo.Controladores;

import Modelo.*;


import java.util.ArrayList;
import java.util.Random;

import static Modelo.Utils.guardarZoo;
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
        String eleccion, especie = null, habitat = null;
        int edad = 0;

        while (!quiereSalir) {
            System.out.println("Bienvenido " + empleado.getNombre() + "!");
            System.out.println("1) Marcar tarea completada");
            System.out.println("2) Curar Animal");
            System.out.println("3) Cambiar contraseña");
            System.out.println("4) Anotar observaciones");
            System.out.println("5) Mostrar Animales");
            System.out.println("6) Salir");

            eleccion = scanner.nextLine();

            switch (eleccion) {
                case "1":
                    Utils.limpiarPantalla();

                    boolean verificacion;
                    if (mostrarTareas() != 0) {
                        System.out.println("Que tarea fue completada?");
                        String tarea;
                        tarea= scanner.nextLine();
                        verificacion = marcarTareaCompletada(tarea, empleado);

                        if(verificacion){
                            System.out.println("Tarea completada!");
                        }else{

                            System.out.println("No se encontro la tarea");
                        }

                        guardarZoo(archivoZoo,zoo);
                    } else {
                        System.out.println("Usted no tiene tareas asignadas");
                        scanner.nextLine();
                    }
                    break;
                case "2":
                    Utils.limpiarPantalla();
                    mostrarAnimalesEnfermos();
                    System.out.println("Ingrese el animal?");
                    especie = scanner.nextLine();
                   // boolean verificacion;
                    verificacion = curarAnimal(especie);

                    if(verificacion){
                        System.out.println("Felcitaciones, buen trabajo!");
                    }else{

                        System.out.println("No se encontro la especie");
                    }

                    guardarZoo(archivoZoo,zoo);
                    break;
                case "3":
                    Utils.limpiarPantalla();
                    System.out.println("Ingrese la nueva contraseña: ");
                    String contrasenia;
                    contrasenia=scanner.nextLine();
                    cambiarContraseniaEmpleado(contrasenia);
                    System.out.println("Contraseña cambiada con exito!");

                    guardarZoo(archivoZoo,zoo);
                    break;
                case "4":
                    try {
                        mostrarAnimales();
                        System.out.println("Ingrese la especie: ");
                        especie = scanner.nextLine();

                        System.out.println("Ingrese el habitat: ");
                        habitat = scanner.nextLine();

                        System.out.println("Ingrese la edad: ");
                        edad = scanner.nextInt();
                    }catch (Exception e){
                        System.out.println("Error en el ingreso de datos");;
                    }

                    int pos = zoo.buscarXespecieYhabitatYedad(especie,habitat,edad);
                    if(pos != -1){
                        scanner.nextLine();
                        System.out.println("Asigna las observaciones: \n");
                        String observaciones = scanner.nextLine();
                        zoo.getColeccionAnimal().listado().get(pos).setObservaciones(observaciones);
                    }else{
                        System.out.println("Animal inexistente");
                    }
                    guardarZoo(archivoZoo,zoo);
                    break;
                case "5":
                    for (Animal a : zoo.getColeccionAnimal().listado()){
                        System.out.println(a);
                        System.out.println();
                    }

                    System.out.println("Pulse una tecla para continuar");
                    scanner.nextLine();
                    break;
                case "6":
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

        boolean verificacion = false;

        ArrayList<Animal> animales = zoo.getColeccionAnimal().listado();

        for(int i=0; i<animales.size(); i++){

            if(animales.get(i).getEspecie().equals(especie)){

                animales.get(i).setEstaEnfermo(false);

                verificacion=true;

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
    public void mostrarAnimales() {

        ArrayList<Animal> animales = zoo.getColeccionAnimal().listado();

        System.out.println("-------------ANIMALES-------------");
        for(int i=0; i<animales.size();i++){
                System.out.println(animales.get(i).toString());
                System.out.println("\n");
        }


    }
    //FIXME: el numero de retorno debería ser un reflejo filedigno de la cantidad de tareas, pero nuestro único caller
    //en menú empleado necesita que le pasemos únicamente las tareas que no esten completadas.
    public int mostrarTareas(){

        ArrayList<Tarea> tareas= empleado.getTareas();

        int numeroDeTareas = 0;

        for (Tarea t : tareas){
            if (!t.isCompletado()){
                numeroDeTareas++;
            }
        }


        //raro el uso de tareas.size aca
        for(int i=0; i<tareas.size();i++){

            if(!tareas.get(i).isCompletado()){

                System.out.println(tareas.get(i).toString());
                System.out.println("\n");
            }
        }

        return numeroDeTareas;
    }




}
