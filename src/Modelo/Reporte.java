package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reporte implements Serializable {
    //===================
    //Atributos
    //===================

    //FIXME: esto antes tenía ingresos y egresos
    //hay que hacer q arranque lo antes posible
    private float balance;
    private Animal animalEstrella;
    private ArrayList<Animal>  animalEnfermos;
    private Usuario empleadoEstrella;
    private LocalDate fecha;

    //Contructores
    public Reporte(float balance, Animal animalEstrella, ArrayList<Animal> animalEnfermos, Usuario empleadoEstrella, LocalDate fecha) {
        this.balance = balance;
        this.animalEstrella = animalEstrella;
        this.animalEnfermos = animalEnfermos;
        this.empleadoEstrella = empleadoEstrella;
        this.fecha = fecha;
    }
    //Getters and Setters

    public LocalDate getFecha() {
        return fecha;
    }

    public float getBalance() {
        return balance;
    }

    public Animal getAnimalEstrella() {
        return animalEstrella;
    }

    public ArrayList<Animal> getAnimalEnfermos() {
        return animalEnfermos;
    }

    public Usuario getEmpleadoEstrella() {
        return empleadoEstrella;
    }
    //Metodos

    @Override
    public String toString() {
        return "Reporte: [Fecha: " + fecha + ", Balance: $" + balance +
                ", Animal Estrella: " + animalEstrella.getEspecie() + " (Visitas: " + animalEstrella.getCantidadVisitas() + ")" +
                ", Empleado Estrella: " + empleadoEstrella.getNombre() +
                ", Cantidad de Animales Enfermos: " + animalEnfermos.size() + "]"+
                "\n";

    }
}
