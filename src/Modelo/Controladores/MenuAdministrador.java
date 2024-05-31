package Modelo.Controladores;

import Modelo.Utils;
import Modelo.Usuario;
import Modelo.Zoologico;

import static Modelo.Utils.scanner;

public class MenuAdministrador {
    Zoologico zoo;
    Usuario admin;

    public MenuAdministrador(Zoologico zoo, Usuario admin) {
        this.zoo = zoo;
        this.admin = admin;
    }

    //============================
    //MÉTODOS
    //============================
    public void mainLoop() {
        boolean quiereSalir = false;
        String eleccion;

        while (!quiereSalir) {
            System.out.println("Bienvenido " + admin.getNombre() + "!");
            System.out.println("1) Administrar Empleados");
            System.out.println("2) Administrar Animales");
            System.out.println("3) Asignar Tareas");
            System.out.println("4) Ver reportes");
            System.out.println("5) Salir");

            eleccion = scanner.nextLine();

            switch (eleccion) {
                case "1":
                    Utils.limpiarPantalla();
                    administrarEmpleados();
                    break;
                case "2":
                    Utils.limpiarPantalla();
                    administrarAnimales();
                    break;
                case "3":
                    Utils.limpiarPantalla();
                    asignarTareas();
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

        private void administrarEmpleados(){
            System.out.println("1) Dar de alta");
            System.out.println("2) Eliminar");



        }


        private void administrarAnimales () {

        System.out.println("1) Dar de alta");
        System.out.println("2) Eliminar");

        }

        private void asignarTareas () {


        }

        private void verReportes () {

            System.out.println("1) Reporte especifico");
            System.out.println("2) Ver todos los reportes");
            System.out.println("3) Animal Estrella del mes");
            System.out.println("4) Empleado Estrella del mes");

    }




        }


    }
}
