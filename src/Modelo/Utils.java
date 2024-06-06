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

    public static void limpiarScanner(){
        while (scanner.hasNextLine()) {
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
        }catch (IOException e){
            e.getMessage();

        } catch (ClassNotFoundException e) {
            e.getMessage();;
        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }

        return localDateReporteHashMap;

    }
}
