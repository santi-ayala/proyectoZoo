import Modelo.*;
import Modelo.Controladores.MenuAdministrador;

import java.awt.*;

import static Modelo.Utils.scanner;


public class Main {

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
                    Utils.limpiarPantalla();
            }
        }

        Utils.limpiarPantalla();
        System.out.println("Gracias por confiar en Zoo Manager!");

        scanner.close();
    }

    private static void nuevoZoologico() {
        Utils.limpiarPantalla();

        try{

            System.out.println("Ingrese el usuario de su nuevo administrador");
            String usuario = scanner.nextLine();

            System.out.println("Ingrese su contraseña");
            String contrasenia = scanner.nextLine();

            System.out.println("Ingrese Nombre y Apellido");
            String nombreApellido = scanner.nextLine();

            System.out.println("Ingrese un nombre para su zoologico!");
            String nombreZoo = scanner.nextLine();

            if (usuario.isEmpty() || contrasenia.isEmpty() || nombreApellido.isEmpty() || nombreZoo.isEmpty()) {
                throw new LoginException("Todos los campos son obligatorios");
            }

            Usuario admin = new Usuario(usuario, contrasenia, TipoUsuario.ADMINISTRADOR, nombreApellido);
            Zoologico zoo = new Zoologico(nombreZoo, admin);

            System.out.println("Su zoolgico ha sido creado con exito!\nPulse cualquier tecla para continuar");
            scanner.nextLine();

            MenuAdministrador menuAdmin = new MenuAdministrador(zoo, admin);

            menuAdmin.mainLoop();




        }catch (LoginException e){

            System.out.println("Error: " + e.getMessage());

        }


    }

    private static void cargarZoologico() {





    }

    //COMENTARIO DE PRUEBA

}
