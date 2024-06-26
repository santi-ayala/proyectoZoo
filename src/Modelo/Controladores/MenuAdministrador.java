package Modelo.Controladores;

import Modelo.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import static Modelo.Utils.guardarZoo;
import static Modelo.Utils.scanner;

public class MenuAdministrador {
    public static String archivoZoo = "ArchivoZoo.dat";
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
            System.out.println("Bienvenido " + admin.getNombre() + " a " + zoo.getNombre() + "!");
            System.out.println("\nHoy es el " + zoo.getFechaActual());
            System.out.println("Su zoologico tiene un balance de $" + zoo.getBalance() + "\n");

            System.out.println("1) Administrar Empleados");
            System.out.println("2) Administrar Animales");
            System.out.println("3) Administrar Tareas");
            System.out.println("4) Ver reportes");
            System.out.println("5) Avanzar de día");
            System.out.println("6) Salir");

            eleccion = scanner.nextLine();

            switch (eleccion) {
                case "1":
                    Utils.limpiarPantalla();
                    administrarEmpleados();
                    guardarZoo(archivoZoo,zoo);
                    break;
                case "2":
                    Utils.limpiarPantalla();
                    administrarAnimales();
                    guardarZoo(archivoZoo,zoo);
                    break;
                case "3":
                    Utils.limpiarPantalla();
                    administrarTareas();
                    guardarZoo(archivoZoo,zoo);
                    break;
                case "4":
                    Utils.limpiarPantalla();
                    verReportes();
                    guardarZoo(archivoZoo,zoo);
                    break;
                case "5":
                    Utils.limpiarPantalla();
                    zoo.avanzarSimulacion();
                    guardarZoo(archivoZoo,zoo);
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

    private void administrarEmpleados() {
        boolean quiereSalir = false;
        while (!quiereSalir) {
            System.out.println("1) Dar de alta");
            System.out.println("2) Eliminar");
            System.out.println("3) Cambiar nombre de usuario");
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
                    System.out.println("Nombre y Apellido: ");
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
                        System.out.println("Ese usuario ya existe!");
                    }
                    break;

                case "2":
                    System.out.println("Usuario: ");
                    nombreUsuario = scanner.nextLine();

                    System.out.println("Contraseña: ");
                    contra = scanner.nextLine();

                    //devuelve -1 en posición no encontrada
                    pos = zoo.buscarXusuarioYcontra(nombreUsuario, contra);
                    if(pos!=-1) {
                        boolean esVerdadero = zoo.getColeccionUsuario().darDeBaja(zoo.getColeccionUsuario().listado().get(pos));
                        if (esVerdadero) {
                            System.out.println("Eliminado correctamente");
                        }
                    }else{
                        System.out.println("No se encontro el usuario");
                    }

                    break;

                case "3":
                    System.out.println("Nombre de usuario original: ");
                    nombreUsuario = scanner.nextLine();

                    System.out.println("Contraseña: ");
                    contra = scanner.nextLine();

                    pos = zoo.buscarXusuarioYcontra(nombreUsuario, contra);
                    if (pos != -1) {
                        Usuario usuario1 = zoo.getColeccionUsuario().listado().get(pos);

                        System.out.println("Nombre de usuario nuevo: ");
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
                        Usuario usuario1 = zoo.getColeccionUsuario().listado().get(pos);

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
            System.out.println("3) Listar animales");
            System.out.println("4) Salir");
            String eleccion = scanner.nextLine();
            String especie, habitat, dieta, edad,observaciones;
            int edadi = 0, posicion = 0;
            boolean esVerdadero;
            switch (eleccion) {
                case "1":
                    System.out.println("Especie: ");
                    especie = scanner.nextLine();

                    System.out.println("Habitat: ");
                    habitat = scanner.nextLine();

                    System.out.println("Dieta: ");
                    dieta = scanner.nextLine();

                    boolean cast;

                    do {
                        System.out.println("Edad: ");
                        edad = scanner.nextLine();
                        cast = true;
                        try {
                            edadi = Integer.parseInt(edad);
                        } catch (NumberFormatException e){
                            System.out.println("Ingrese un numero valido!");
                            cast = false;
                        }
                        //mientras el cast no se haga
                        //semanticamente se cae a pedazos, lo sé
                    }while(!cast);

                    System.out.println("Observaciones: ");
                    observaciones = scanner.nextLine();

                    Animal animal = new Animal(especie, habitat, edadi, dieta, observaciones);

                    esVerdadero = zoo.getColeccionAnimal().darDeAlta(animal);
                    if (esVerdadero) {
                        System.out.println("Agregado correctamente");
                        guardarZoo(archivoZoo,zoo);
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
                    edadi = scanner.nextInt();

                    posicion = zoo.buscarXespecieYhabitatYedad(especie, habitat, edadi);
                    if (posicion != -1) {

                        Animal animal1 = zoo.getColeccionAnimal().listado().get(posicion);

                        esVerdadero = zoo.getColeccionAnimal().darDeBaja(animal1);
                        if (esVerdadero) {
                            System.out.println("Se logro dar de baja al animal");
                            guardarZoo(archivoZoo,zoo);
                        } else {
                            System.out.println("No se logro, vuelva intentarlo");
                        }
                    } else {
                        System.out.println("No se encontro el animal");
                    }
                    break;
                case "3":
                    for (Animal a : zoo.getColeccionAnimal().listado()){
                        System.out.println(a);
                    }
                    break;
                case "4":
                    quieroSalir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }


        }
    }

    private void administrarTareas() { //Agrega una tarea a un empleado
        boolean quiereSalir = false, esVerdadero;
        String nombreUsuario, contra;
        int pos;
        while (!quiereSalir) {

            //TODO: un administrador deberia poder eliminar tareas
            System.out.println("1) Asignar una tarea");
            System.out.println("2) Salir");

            String eleccion = scanner.nextLine();
            switch (eleccion) {
                case "1":
                    System.out.println("Usuario: ");
                    nombreUsuario = scanner.nextLine();

                    Usuario user_a_buscar = null;

                    for(Usuario u: zoo.getColeccionUsuario().listado()){
                        if(u.getUsuario().equalsIgnoreCase(nombreUsuario)){
                            user_a_buscar = u;
                        }
                    }

                    if (user_a_buscar != null) {

                        System.out.println("Tarea a asignar: ");
                        String accion = scanner.nextLine();

                        Tarea tarea = new Tarea(accion);
                        user_a_buscar.getTareas().add(tarea);
                        user_a_buscar.setTareas(user_a_buscar.getTareas());

                        System.out.println("La tarea se asigno existosamente!");
                        guardarZoo(archivoZoo,zoo);
                    } else {
                        System.out.println("Error: Datos invalidos");
                    }
                    break;

                case "2":
                    quiereSalir = true;
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
            System.out.println("3) Animal Estrella de la semana");
            System.out.println("4) Empleado Estrella de la semana");
            System.out.println("5) Salir");
            eleccion = scanner.nextLine();

            switch (eleccion) {
                case "1":
                    System.out.println("Tenemos reportes desde el " + zoo.getFechaDeinicio() + " hasta " + zoo.getFechaActual());
                    System.out.println("Que fecha desea ver? (AAAA-MM-DD)");
                    String inputFecha = scanner.nextLine();

                    LocalDate fecha;
                    try {
                        fecha = LocalDate.parse(inputFecha);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato Invalido! Pulse cualquier tecla para continuar");
                        fecha = null;
                        scanner.nextLine();
                    }

                    if (fecha != null) {
                        boolean rangoInferior = (fecha.isAfter(zoo.getFechaDeinicio()) || fecha.isEqual(zoo.getFechaDeinicio()));
                        boolean rangoSuperior = (fecha.isBefore(zoo.getFechaActual()) || fecha.isEqual(zoo.getFechaActual()));

                        // si nuestra fecha ingresada se encuentra dentro de nuestro hashmap
                        if (rangoSuperior && rangoInferior) {
                            Reporte reporteBuscado = zoo.getHistorial().get(fecha);

                            //TODO: hacer un tostring fachero
                            System.out.println(reporteBuscado);
                        } else {
                            System.out.println("La fecha que pidió no esta en el registro. Por favor intente de nuevo");
                            scanner.nextLine();
                        }
                    }
                    Utils.limpiarPantalla();
                    break;

                case "2":
                    //todo: imprime todo a sout. debe haber alguna forma más elegante, aunque sea con un sout más coqueto.
                    //capaz se podria armar una clase de pager, donde muestre la cantidad de registros que faltan (es posible?)
                    //e incluya una función para romperlo
                    int i = 0;
                    boolean deseaSeguirViendo = true;

                    for (Map.Entry<LocalDate, Reporte> elemento : zoo.getHistorial().entrySet()) {
                        Reporte r = elemento.getValue();

                        if (i != 0 && i % 10 == 0) { // cada 10 reportes
                            System.out.println("Desea seguir viendo reportes? (s/n)");

                            boolean inputInvalido = true;

                            do {
                                String input = scanner.nextLine();
                                switch (input) {
                                    case "s":
                                        inputInvalido = false;
                                        break;
                                    case "n":
                                        inputInvalido = false;
                                        deseaSeguirViendo = false;
                                        break;
                                }
                            } while (inputInvalido);
                        }

                        if (!deseaSeguirViendo)
                            break;

                        System.out.println(r);
                        i++;
                    }


                    System.out.println("Fueron impresos " + i + " elementos");
                    System.out.println("Pulse cualquier tecla para continuar");
                    scanner.nextLine();
                    break;
                case "3":
                    LocalDate inicioSemanaActual = zoo.getFechaActual().minusWeeks(1);

                    boolean hay7diasDeRegistros = (zoo.getFechaDeinicio().plusWeeks(1)).isBefore(inicioSemanaActual);

                    if (!hay7diasDeRegistros) {
                        System.out.println("No contamos con los suficientes datos para calcular el animal estrella");

                    } else {

                        //este es posiblemente el código más feo que escribi jamás
                        //lo que hace es crear dos arrays, uno de animales unicos y otro directamente copiado de
                        //los reportes de la ultima semana

                        //despues iteramos por la lista de animales unicos, y en un arreglo paralelo (!)
                        //guardamos las veces que aparece cada animal

                        //luego determinamos el indice del mayor de ese arreglo, y determinamos a ese animal
                        //el ganador

                        //espero que no me dejen escribir código nunca más

                        ArrayList<Animal> animalesUnicos = new ArrayList<Animal>();
                        ArrayList<Animal> animalesReportes = new ArrayList<Animal>();

                        for (int j = 0; j < 7; j++) {
                            Reporte r = zoo.getHistorial().get(inicioSemanaActual);
                            animalesReportes.add(r.getAnimalEstrella());
                            inicioSemanaActual = inicioSemanaActual.plusDays(1);
                        }

                        //determinamos elementos no duplicados del array
                        for (Animal a : animalesReportes){
                            if (a != null && !animalesUnicos.contains(a)){
                                animalesUnicos.add(a);
                            }
                        }

                        //contamos mediante un arreglo paralelo las ocurrencias de cada animal
                        ArrayList<Integer> ocurrencias = new ArrayList<Integer>();
                        for (Animal a : animalesUnicos){
                            ocurrencias.add(Collections.frequency(animalesReportes, a));
                        }

                        //el sufrimiento terminó
                        int numeroMaximo = Collections.max(ocurrencias);
                        int indice = ocurrencias.indexOf(numeroMaximo);

                        Animal animalEstrella = animalesUnicos.get(indice);

                        System.out.println("El animal estrella de la semana es \n" + animalEstrella.getEspecie());
                        System.out.println("Edad: " + animalEstrella.getEdad());
                        System.out.println("Observaciones: " + animalEstrella.getObservaciones());
                    }
                    System.out.println("Presione una tecla para continuar");
                    scanner.nextLine();
                    Utils.limpiarPantalla();
                    break;
                case "4":
                    LocalDate inicioSemanaActualE = zoo.getFechaActual().minusWeeks(1);

                    boolean hay7diasDeRegistrosE = (zoo.getFechaDeinicio().plusWeeks(1)).isBefore(inicioSemanaActualE);

                    if (!hay7diasDeRegistrosE) {
                        System.out.println("No contamos con los suficientes datos para calcular el empleado estrella");

                    } else {
                        ArrayList<Usuario> empleadosReportes = new ArrayList<Usuario>();

                        //Ponemos todos los reportes de la ultima semana en un array
                        for (int j = 0; j < 7; j++) {
                            Reporte r = zoo.getHistorial().get(inicioSemanaActualE);
                            empleadosReportes.add(r.getEmpleadoEstrella());
                            inicioSemanaActualE = inicioSemanaActualE.plusDays(1);
                        }

                        //Determinamos cuales son los elementos no duplicados del array
                        ArrayList<Usuario> empleadosUnicos = new ArrayList<Usuario>();
                        for (Usuario u : empleadosReportes) {
                            if (u != null && !empleadosUnicos.contains(u)) {
                                empleadosUnicos.add(u);
                            }
                        }

                        //Contamos mediante un arreglo paralelo las ocurrencias de cada empleado
                        ArrayList<Integer> ocurrencias = new ArrayList<Integer>();
                        for (Usuario a : empleadosUnicos) {
                            ocurrencias.add(Collections.frequency(empleadosReportes, a));
                        }

                        //Determinamos el empleado con más ocurrencias mediante el arreglo paralelo
                        //y accedemos a él mediante el indice

                        if (!ocurrencias.isEmpty()) {
                            int numeroMaximo = Collections.max(ocurrencias);
                            int indice = ocurrencias.indexOf(numeroMaximo);

                            Usuario empleadoEstrella = empleadosUnicos.get(indice);

                            System.out.println("El empleado estrella de la semana es " + empleadoEstrella.getNombre());
                            int cantidadTareasCompletadas = 0;
                            for (Tarea t : empleadoEstrella.getTareas()) {
                                if (t.isCompletado()) {
                                    cantidadTareasCompletadas++;
                                }
                                System.out.println("Cantidad de tareas completadas: " + cantidadTareasCompletadas);
                            }
                        } else {
                            System.out.println("No hemos podido calcular el empleado estrella de la ultima semana");
                            System.out.println("Por favor, verifique si existen empleados!");
                        }
                        System.out.println("Presione una tecla para continuar");
                        scanner.nextLine();
                        Utils.limpiarPantalla();
                        break;
                    }
                case "5":
                    quiereSalir = true;
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
                    scanner.nextLine();
            }
        }
    }
}



