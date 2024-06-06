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
            System.out.println("1) Cargar Zoologico");
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

        System.out.println("Ingrese el usuario de su nuevo administrador");
        String usuario = scanner.nextLine();

        System.out.println("Ingrese su contraseña");
        String contrasenia = scanner.nextLine();

        System.out.println("Ingrese Nombre y Apellido");
        String nombreApellido = scanner.nextLine();

        System.out.println("Ingrese un nombre para su zoologico!");
        String nombreZoo = scanner.nextLine();



        Usuario admin = new Usuario(usuario, contrasenia, TipoUsuario.ADMINISTRADOR, nombreApellido);
        Zoologico zoo = new Zoologico(nombreZoo, admin);

        for(int i = 0 ; i <15 ; i++){
            Animal animal = new Animal("");
            zoo.getColeccionAnimal().darDeAlta(animal);
        }
        guardarZoo(archivoZoo,zoo);


        System.out.println("Su zoolgico ha sido creado con exito!\nPulse cualquier tecla para continuar");
        scanner.nextLine();

        MenuAdministrador menuAdmin = new MenuAdministrador(zoo, admin);

        menuAdmin.mainLoop();
    }

    private static void cargarZoologico() {
        limpiarPantalla();
        boolean err = false;
        Zoologico zoo = null;
        try{
            zoo = leerZoo(archivoZoo);
        } catch (Exception e){
            System.out.println("Ocurrió un error!");
            err = true;
        }

        if (!err) {
            System.out.println("LOGIN");
            System.out.println("Ingrese el nombre de usuario ");
            String usuario = scanner.nextLine();

            System.out.println("Ingrese su contraseña");
            String contrasenia = scanner.nextLine();

            int pos = zoo.buscarXusuarioYcontra(usuario,contrasenia);

            if(zoo.getAdmin().getUsuario().equals(usuario) && zoo.getAdmin().getContrasenia().equals(contrasenia)){
                System.out.println("Bienvenido al administrador " + zoo.getAdmin().getNombre());
                MenuAdministrador menuAdministrador = new MenuAdministrador(zoo,zoo.getAdmin());
                menuAdministrador.mainLoop();
            }else {
                if (pos != -1){
                    Usuario usuario1 = zoo.getColeccionUsuario().listado().get(pos);
                    if(usuario1.getTipoUsuario().equals(TipoUsuario.EMPLEADO)){
                        System.out.println("Bienvenido al empleado " + usuario1.getNombre());
                        MenuEmpleado menuEmpleado = new MenuEmpleado(zoo,usuario1);
                        menuEmpleado.mainLoop();
                    }
                }else{
                    System.out.println("No se encontro el usuario");
                }
    
            }
        }


    }


}
