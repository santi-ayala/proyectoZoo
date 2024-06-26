import Modelo.*;
import Modelo.Controladores.MenuAdministrador;
import Modelo.Controladores.MenuEmpleado;

import java.awt.*;

import static Modelo.Utils.*;


public class Main {
    public static String archivoZoo = "ArchivoZoo.dat";

    public static void main(String[] args) throws Exception {
        boolean x = true;
        String eleccion;
        while (x) {
            System.out.println("Hola! Bienvenido a Zoo Manager!");
            System.out.println("1) Iniciar Sesión");
            System.out.println("2) Crear nuevo Zoologico");

            eleccion = scanner.nextLine();
            switch (eleccion) {
                case "1":
                    x = false;
                    cargarZoologico();
                    break;
                case "2":
                    x = false;
                    nuevoZoologico();
                    break;
                default:
                    limpiarPantalla();
            }
        }

        limpiarPantalla();
        System.out.println("Gracias por confiar en Zoo Manager!");

        scanner.close();
    }

    private static void nuevoZoologico() {
        limpiarPantalla();

        boolean existeZoologico = true;
        boolean quiereSobreescribir = true;

        try{
            leerZoo(archivoZoo);
        } catch (Exception e){
            existeZoologico = false;
        } finally {
            if (existeZoologico) {
                System.out.println("Atencion! Ya existe un zoologico en su sistema!");
                System.out.println("Crear un zoologico nuevo sobreescribira su zoologico existente");
                System.out.println("¿Desea continuar de todas formas? (s/n)");

                boolean inputInvalido = true;

                do {
                    String input = scanner.nextLine();
                    switch (input){
                        case "s":
                            inputInvalido = false;
                            break;
                        case "n":
                            quiereSobreescribir = false;
                            inputInvalido = false;
                            break;
                        default:
                            System.out.println("Ingrese una opción válida!");
                            break;
                    }
                } while (inputInvalido);
            }


            if (quiereSobreescribir) {
                try{
                    System.out.println("Ingrese el usuario de su nuevo administrador");
                    String usuario = scanner.nextLine();
                    if (usuario.isEmpty()) {
                        throw new LoginException("El campo de usuario no puede estar vacío");
                    }

                    System.out.println("Ingrese su contrasenia");
                    String contrasenia = scanner.nextLine();
                    if (contrasenia.isEmpty()) {
                        throw new LoginException("El campo de contraseña no puede estar vacío");
                    }

                    System.out.println("Ingrese Nombre y Apellido");
                    String nombreApellido = scanner.nextLine();
                    if (nombreApellido.isEmpty()) {
                        throw new LoginException("El campo de nombre y apellido no puede estar vacío");
                    }

                    System.out.println("Ingrese un nombre para su zoologico!");
                    String nombreZoo = scanner.nextLine();
                    if (nombreZoo.isEmpty()) {
                        throw new LoginException("El campo de nombre del zoológico no puede estar vacío");
                    }


                    Usuario admin = new Usuario(usuario, contrasenia, TipoUsuario.ADMINISTRADOR, nombreApellido);
                    Zoologico zoo = new Zoologico(nombreZoo, admin);

                    for(int i = 0 ; i <15 ; i++){
                        Animal animal = new Animal("");
                        zoo.getColeccionAnimal().darDeAlta(animal);
                    }
                    guardarZoo(archivoZoo,zoo);


                    System.out.println("Su zoológico ha sido creado con exito!\nPulse cualquier tecla para continuar");
                    scanner.nextLine();

                    MenuAdministrador menuAdmin = new MenuAdministrador(zoo, admin);

                    menuAdmin.mainLoop();


                }catch (LoginException e){
                    System.out.println("Error: " + e.getMessage());



                }

            } else {
                System.out.println("Abortando...");
            }
        }



    }

    private static void cargarZoologico() {
        limpiarPantalla();
        boolean err = false;
        Zoologico zoo = null;
        try{
            zoo = leerZoo(archivoZoo);
        } catch (Exception e){
            err = true;
        }

        if (!err && zoo != null) {
            System.out.println("LOGIN");
            System.out.println("Ingrese el nombre de usuario ");
            String usuario = scanner.nextLine();

            System.out.println("Ingrese su contraseña");
            String contrasenia = scanner.nextLine();


            int pos = zoo.buscarXusuarioYcontra(usuario,contrasenia);

            if(zoo.getAdmin().getUsuario().equals(usuario) && zoo.getAdmin().getContrasenia().equals(contrasenia)){
                MenuAdministrador menuAdministrador = new MenuAdministrador(zoo,zoo.getAdmin());
                menuAdministrador.mainLoop();
            }else {
                if (pos != -1){
                    Usuario usuario1 = zoo.getColeccionUsuario().listado().get(pos);
                    if(usuario1.getTipoUsuario().equals(TipoUsuario.EMPLEADO)){
                        MenuEmpleado menuEmpleado = new MenuEmpleado(zoo,usuario1);
                        menuEmpleado.mainLoop();
                    }
                }else{
                    System.out.println("No se encontro el usuario");
                }
    
            }
        } else {
            System.out.println("Ocurrio un error! (cerro mal el programa?)");
        }


    }

}

//comit necesario
