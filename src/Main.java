import Modelo.Usuario.Administrador;
import Modelo.TipoUsuario;
import Modelo.Usuario;
import Modelo.Zoologico;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in); //instanciacion de scanner global

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

        scanner.close();
    }

    private static void nuevoZoologico() {
        Main.limpiarPantalla();
        Main.limpiarScanner();

        System.out.println("Ingrese el nombre de su nuevo administrador");
        String nombreAdmin = scanner.nextLine();

        System.out.println("Ingrese su contraseña");
        String contrasenia = scanner.nextLine();


        Usuario admin = new Usuario(nombreAdmin, contrasenia, TipoUsuario.ADMINISTRADOR);
        Zoologico<T> zoo = new Zoologico();


    }

    private static void cargarZoologico() {
        //todo: Sistema de carga de Zoologico




    }

    //COMENTARIO DE PRUEBA

}
