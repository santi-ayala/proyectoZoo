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
                String nombre;
                String nombreUsuario;
                String contra;
                String usuarioAUX;
                String contraAUX;
                int pos;

                switch (eleccion){
                    case "1":
                        System.out.println("Nombre: ");
                         nombre = scanner.nextLine();

                        System.out.println("Usuario: ");
                         nombreUsuario = scanner.nextLine();

                        System.out.println("Contraseña: ");
                         contra = scanner.nextLine();

                        Usuario usuario = new Usuario(nombreUsuario,contra, TipoUsuario.EMPLEADO,nombre);

                        zoo.getColeccionUsuario().darDeAlta(usuario);
                        break;
                    case "2":
                        System.out.println("Usuario: ");
                        nombreUsuario = scanner.nextLine();

                        System.out.println("Contraseña: ");
                        contra = scanner.nextLine();

                        pos = zoo.buscarXusuarioYcontra(nombreUsuario,contra);
                        boolean esVerdadero = zoo.getColeccionUsuario().darDeBaja(zoo.getColeccionUsuario().gettArrayList().get(pos));
                        if(esVerdadero){
                            System.out.println("Eliminado correctamente");
                        }else {
                            System.out.println("Error... ");
                        }
                        break;
                    case "3":
                        System.out.println("Nombre de usuario original: ");
                        nombreUsuario = scanner.nextLine();

                        System.out.println("Contraseña: ");
                        contra = scanner.nextLine();

                        pos = zoo.buscarXusuarioYcontra(nombreUsuario, contra);
                        if(pos != -1) {
                            Usuario usuario1 = zoo.getColeccionUsuario().gettArrayList().get(pos);

                            System.out.println("Nombre nuevo: ");
                            usuarioAUX = scanner.nextLine();

                            Usuario nuevo = new Usuario(usuarioAUX, usuario1.getContrasenia(), usuario1.getTipoUsuario(),usuario1.getNombre());
                            boolean bo = zoo.getColeccionUsuario().modificar(usuario1,nuevo);
                            if(bo){
                                System.out.println("Proceso Exitoso");
                            }else{
                                System.out.println("Vuelva a intertarlo");
                            }
                        }else{
                            System.out.println("No se encontro el usuario");
                        }
                        break;
                    case "4":
                        System.out.println("Nombre de usuario: ");
                        nombreUsuario = scanner.nextLine();

                        System.out.println("Contraseña Original: ");
                        contra = scanner.nextLine();

                        pos = zoo.buscarXusuarioYcontra(nombreUsuario, contra);
                        if(pos != -1) {
                            Usuario usuario1 = zoo.getColeccionUsuario().gettArrayList().get(pos);

                            System.out.println("Contraseña nueva: ");
                            contraAUX = scanner.nextLine();
                            Usuario nuevo = new Usuario(usuario1.getUsuario(), contraAUX, usuario1.getTipoUsuario(),usuario1.getNombre());
                            boolean bo = zoo.getColeccionUsuario().modificar(usuario1,nuevo);
                            if(bo){
                                System.out.println("Proceso Exitoso");
                            }else{
                                System.out.println("Vuelva a intertarlo");
                            }
                        } else{
                            System.out.println("No se encontro el usuario");
                        }
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




}

