package Modelo;

import java.util.Scanner;

public class Utils {
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
}
