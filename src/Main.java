import Modelo.Controladores.MenuAdministrador;
import Modelo.TipoUsuario;
import Modelo.Usuario;
import Modelo.Zoologico;
import Modelo.Utils;

import java.awt.*;

import static Modelo.Utils.scanner;


public class Main {

    public static void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void limpiarScanner(){
        while (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

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
                    Main.limpiarPantalla();
            }
        }

        Main.limpiarPantalla();
        System.out.println("Gracias por confiar en Zoo Manager!");
        scanner.nextLine();
        scanner.close();
    }

    private static void nuevoZoologico() {
        Main.limpiarPantalla();
        Main.limpiarScanner();

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

        System.out.println("Su zoolgico ha sido creado con exito!\nPulse cualquier tecla para continuar");
        scanner.nextLine();

        MenuAdministrador menuAdmin = new MenuAdministrador(zoo, admin);

        menuAdmin.mainLoop();
    }

    private static void cargarZoologico() {
        //todo: Sistema de carga de Zoologico




    }

    //COMENTARIO DE PRUEBA

}
