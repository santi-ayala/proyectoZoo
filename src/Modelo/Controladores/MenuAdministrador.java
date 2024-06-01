package Modelo.Controladores;

import Modelo.TipoUsuario;
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
            System.out.println("3) Administrar Tareas");
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

        private void administrarEmpleados(){
            boolean quiereSalir = false;
            while(!quiereSalir){
                System.out.println("1) Dar de alta");
                System.out.println("2) Eliminar");
                System.out.println("3) Cambiar usuario");
                System.out.println("4) Cambiar contraseña");

                String eleccion = scanner.nextLine();

                switch (eleccion){
                    case "1":
                        Utils.limpiarPantalla();
                        CRUDEmpleados.altaEmpleado();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    default:
                }
            }
        }
        private void administrarAnimales () {

        System.out.println("1) Dar de alta");
        System.out.println("2) Eliminar");

        }
        private void administrarTareas() {
            System.out.println("");

        }
        private void verReportes () {

            System.out.println("1) Buscar reporte por fecha");
            System.out.println("2) Ver listado de reportes");
            System.out.println("3) Animal Estrella del mes");
            System.out.println("4) Empleado Estrella del mes");

        }

        static class CRUDEmpleados{
            static void altaEmpleado(){
                Utils.limpiarScanner();
                System.out.println("Ingrese el nombre de su nuevo empleado:");
                String nombreApellido = scanner.nextLine();

                System.out.println("Ingrese un usuario:");
                String usuario = scanner.nextLine();

                System.out.println("Ingrese una contraseña");
                String contrasenia = scanner.nextLine();

                Usuario empleado = new Usuario(usuario, contrasenia, TipoUsuario.EMPLEADO, nombreApellido);


            }
        }
}

