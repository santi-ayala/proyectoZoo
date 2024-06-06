package Modelo.Controladores;

import Modelo.*;

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

    private void administrarEmpleados() {
        boolean quiereSalir = false;
        while (!quiereSalir) {
            System.out.println("1) Dar de alta");
            System.out.println("2) Eliminar");
            System.out.println("3) Cambiar usuario");
            System.out.println("4) Cambiar contraseña");
            System.out.println("5) Salir");

            String eleccion = scanner.nextLine();
            String nombre;
            String nombreUsuario;
            String contra;
            String usuarioAUX;
            String contraAUX;
            int pos;

            switch (eleccion) {
                case "1":
                    System.out.println("Nombre: ");
                    nombre = scanner.nextLine();

                    System.out.println("Usuario: ");
                    nombreUsuario = scanner.nextLine();

                    System.out.println("Contraseña: ");
                    contra = scanner.nextLine();

                    Usuario usuario = new Usuario(nombreUsuario, contra, TipoUsuario.EMPLEADO, nombre);

                    boolean b = zoo.getColeccionUsuario().darDeAlta(usuario);
                    if(b){
                        System.out.println("Se agrego correctamente");
                    }else{
                        System.out.println("Se elimino correctamente");
                    }
                    break;

                case "2":
                    System.out.println("Usuario: ");
                    nombreUsuario = scanner.nextLine();

                    System.out.println("Contraseña: ");
                    contra = scanner.nextLine();

                    pos = zoo.buscarXusuarioYcontra(nombreUsuario, contra);
                    if(pos!=-1) {
                        boolean esVerdadero = zoo.getColeccionUsuario().darDeBaja(zoo.getColeccionUsuario().gettArrayList().get(pos));
                        if (esVerdadero) {
                            System.out.println("Eliminado correctamente");
                        } else {
                            System.out.println("Error... ");
                        }
                    }
                    break;
                case "3":
                    System.out.println("Nombre de usuario original: ");
                    nombreUsuario = scanner.nextLine();

                    System.out.println("Contraseña: ");
                    contra = scanner.nextLine();

                    pos = zoo.buscarXusuarioYcontra(nombreUsuario, contra);
                    if (pos != -1) {
                        Usuario usuario1 = zoo.getColeccionUsuario().gettArrayList().get(pos);

                        System.out.println("Nombre aux: ");
                        usuarioAUX = scanner.nextLine();
                        Usuario nuevo = new Usuario(usuarioAUX, usuario1.getContrasenia(), usuario1.getTipoUsuario(), usuario1.getNombre());
                        boolean bo = zoo.getColeccionUsuario().modificar(usuario1, nuevo);
                        if (bo) {
                            System.out.println("Proceso Exitoso");
                        } else {
                            System.out.println("Vuelva a intertarlo");
                        }
                    } else {
                        System.out.println("No se encontro el usuario");
                    }
                    break;
                case "4":
                    System.out.println("Nombre de usuario: ");
                    nombreUsuario = scanner.nextLine();

                    System.out.println("Contraseña Original: ");
                    contra = scanner.nextLine();

                    pos = zoo.buscarXusuarioYcontra(nombreUsuario, contra);
                    if (pos != -1) {
                        Usuario usuario1 = zoo.getColeccionUsuario().gettArrayList().get(pos);

                        System.out.println("Contraseña nueva: ");
                        contraAUX = scanner.nextLine();
                        Usuario nuevo = new Usuario(usuario1.getUsuario(), contraAUX, usuario1.getTipoUsuario(), usuario1.getNombre());
                        boolean bo = zoo.getColeccionUsuario().modificar(usuario1, nuevo);
                        if (bo) {
                            System.out.println("Proceso Exitoso");
                        } else {
                            System.out.println("Vuelva a intertarlo");
                        }
                    } else {
                        System.out.println("No se encontro el usuario");
                    }
                    break;
                case "5":
                    quiereSalir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }
    }


    private void administrarAnimales() {
        boolean quieroSalir = false;
        while (!quieroSalir) {

            System.out.println("1) Dar de alta");
            System.out.println("2) Eliminar");
            String eleccion = scanner.nextLine();
            String especie, habitat, dieta, observaciones;
            int edad, posicion = 0;
            boolean esVerdadero;
            switch (eleccion) {
                case "1":
                    System.out.println("Especie: ");
                    especie = scanner.nextLine();

                    System.out.println("Habitat: ");
                    habitat = scanner.nextLine();

                    System.out.println("Dieta: ");
                    dieta = scanner.nextLine();

                    System.out.println("Edad: ");
                    edad = scanner.nextInt();

                    System.out.println("Observaciones: ");
                    observaciones = scanner.nextLine();

                    Animal animal = new Animal(especie, habitat, edad, dieta, observaciones);

                    esVerdadero = zoo.getColeccionAnimal().darDeAlta(animal);
                    if (esVerdadero) {
                        System.out.println("Agregado correctamente");
                    } else {
                        System.out.println("No se pudo agregar");
                    }
                    break;
                case "2":
                    System.out.println("Especie: ");
                    especie = scanner.nextLine();

                    System.out.println("Habitat: ");
                    habitat = scanner.nextLine();

                    System.out.println("Edad: ");
                    edad = scanner.nextInt();

                    posicion = zoo.buscarXespecieYhabitatYedad(especie, habitat, edad);
                    if (posicion != -1) {

                        Animal animal1 = zoo.getColeccionAnimal().gettArrayList().get(posicion);

                        esVerdadero = zoo.getColeccionAnimal().darDeBaja(animal1);
                        if (esVerdadero) {
                            System.out.println("Se logro dar de baja al animal");
                        } else {
                            System.out.println("No se logro, vuelva intentarlo");
                        }
                    } else {
                        System.out.println("No se encontro el animal");
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }


        }
    }

    private void administrarTareas() {//Agrega una tarea a un empleado
        boolean quiereSalir = false, esVerdadero;
        String nombreUsuario, contra;
        int pos;
        while (!quiereSalir) {

            System.out.println("1) Asignar una tarea");

            String eleccion = scanner.nextLine();
            switch (eleccion) {
                case "1":
                    System.out.println("Usuario: ");
                    nombreUsuario = scanner.nextLine();

                    System.out.println("Contraseña: ");
                    contra = scanner.nextLine();

                    pos = zoo.buscarXusuarioYcontra(nombreUsuario, contra);
                    if (pos != -1) {
                        Usuario usuario = zoo.getColeccionUsuario().gettArrayList().get(pos);

                        System.out.println("Tarea a asignar: ");

                        Tarea tarea = new Tarea(scanner.nextLine());
                        usuario.getTareas().add(tarea);
                        usuario.setTareas(usuario.getTareas());
                    } else {
                        System.out.println("Error: Datos invalidos");
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }
    }

    private void verReportes() {
        boolean quiereSalir = false;
        String eleccion;

        while (!quiereSalir) {
            System.out.println("1) Buscar reporte por fecha");
            System.out.println("2) Ver listado de reportes");
            System.out.println("3) Animal Estrella del mes");
            System.out.println("4) Empleado Estrella del mes");
            System.out.println("5) Salir");
            eleccion = scanner.nextLine();

            switch (eleccion) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    quiereSalir = true;
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
            }
        }

    }
}



