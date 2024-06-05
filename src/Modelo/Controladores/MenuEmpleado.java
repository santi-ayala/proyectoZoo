package Modelo.Controladores;

import Modelo.ColeccionArray;
import Modelo.Usuario;
import Modelo.Utils;
import Modelo.Zoologico;


import java.util.Random;

import static Modelo.Utils.scanner;

public class MenuEmpleado {
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
                    System.out.println("Que tarea fue completada?");
                    String tarea;
                    tarea= scanner.nextLine();
                    boolean verificacion;
                   verificacion = zoo.marcarTareaCompletada(tarea, empleado);

                   if(verificacion){
                       System.out.println("Tarea completada!");
                   }else{

                       System.out.println("No se encontro la tarea");
                   }


                    break;
                case "2":
                    Utils.limpiarPantalla();
                    System.out.println("Que animal fue curado?");
                    String especie;
                    especie = scanner.nextLine();
                   // boolean verificacion;
                    verificacion = zoo.curarAnimal(especie);

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

}
