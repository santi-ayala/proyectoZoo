package Modelo;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class Utils {
    public static Scanner scanner = new Scanner(System.in); //instanciacion de scanner global

    public static void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void limpiarScanner() throws IOException {
        while (System.in.available() > 0) {
            scanner.nextLine();
        }
    }
    public static void guardarReporte(String archivo, HashMap<LocalDate,Reporte> localDateReporteHashMap){
        ObjectOutputStream outputStream = null;
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            outputStream = new ObjectOutputStream(fileOutputStream);
            Iterator<Map.Entry<LocalDate,Reporte>> entryIterator = localDateReporteHashMap.entrySet().iterator();
            while(entryIterator.hasNext()){
                Map.Entry<LocalDate,Reporte> localDateReporteEntry = entryIterator.next();
                outputStream.writeObject(localDateReporteEntry.getValue());
            }
        }catch (IOException e){
            e.getMessage();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public static void guardarZoo(String archivo, Zoologico zoologico) {
        ObjectOutputStream outputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(zoologico);
        } catch (IOException e) {
            System.err.println("Error al guardar el zoológico: " + e.getMessage());
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el stream: " + e.getMessage());
                }
            }
        }
    }
    public static Zoologico leerZoo(String archivo) throws IOException {
        ObjectInputStream inputStream = null;
        Zoologico zoologico = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            inputStream = new ObjectInputStream(fileInputStream);
            zoologico = (Zoologico) inputStream.readObject();
        } catch (IOException e) {
            System.err.println("Error al leer el zoológico: " + e.getMessage());
            System.err.println("(Chequee si existe un zoológico guardado!)");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el stream: " + e.getMessage());
                }
            }
        }
        return zoologico;
    }

    public static HashMap<LocalDate,Reporte> leerReporte(String archivo){
        ObjectInputStream objectInputStream = null;
        HashMap<LocalDate,Reporte> localDateReporteHashMap = new HashMap<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            Iterator<Map.Entry<LocalDate,Reporte>> entryIterator = localDateReporteHashMap.entrySet().iterator();
            while(true){
                Reporte reporte = (Reporte) objectInputStream.readObject();
                localDateReporteHashMap.put(reporte.getFecha(),reporte);
            }
        }catch (IOException | ClassNotFoundException e){
            e.getMessage();

        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }

        return localDateReporteHashMap;
    }

    public static <E> int contarOcurrencias(E e, ArrayList<E> array){
        int i = 0;
        for (E elemento : array){
            if (elemento.equals(e))
                i++;
        }
        return i;
    }


}
