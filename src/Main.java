import Modelo.Controladores.MenuAdministrador;
import Modelo.Controladores.MenuEmpleado;
import Modelo.TipoUsuario;
import Modelo.Usuario;
import Modelo.Zoologico;
import Modelo.Utils;

import java.awt.*;

import static Modelo.Utils.*;


public class Main {
    public static String archivoZoo = "ArchivoZoo.date";

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
        guardarZoo(archivoZoo,zoo);

        System.out.println("Su zoolgico ha sido creado con exito!\nPulse cualquier tecla para continuar");
        scanner.nextLine();

        MenuAdministrador menuAdmin = new MenuAdministrador(zoo, admin);

        menuAdmin.mainLoop();
    }

    private static void cargarZoologico() {
        Utils.limpiarPantalla();
        Zoologico zoo = leerZoo(archivoZoo);
        System.out.println(zoo);
        System.out.println("Ingrese el nombre de usuario ");
        String usuario = scanner.nextLine();

        System.out.println("Ingrese su contraseña");
        String contrasenia = scanner.nextLine();

        int pos = zoo.buscarXusuarioYcontra(usuario,contrasenia);

        if (pos != -1){
            Usuario usuario1 = zoo.getColeccionUsuario().listado().get(pos);
            if(usuario1.getTipoUsuario().equals("EMPLEADO")){
                MenuEmpleado menuEmpleado = new MenuEmpleado(zoo,usuario1);
                menuEmpleado.mainLoop();
            }else {
                MenuAdministrador menuAdministrador = new MenuAdministrador(zoo,usuario1);
                menuAdministrador.mainLoop();
            }
        }else{
            System.out.println("No se encontro el usuario");
        }

    }

    //COMENTARIO DE PRUEBA

}
