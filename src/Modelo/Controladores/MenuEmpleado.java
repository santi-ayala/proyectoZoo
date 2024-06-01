package Modelo.Controladores;

import Modelo.ColeccionArray;
import Modelo.Usuario;
import Modelo.Utils;
import Modelo.Zoologico;

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
                    administrarAnimales();
                    break;
                case "3":
                    Utils.limpiarPantalla();
                    administrarTareas();
                    break;
                case "4":
                    Utils.limpiarPantalla();
                    verReportes();
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
