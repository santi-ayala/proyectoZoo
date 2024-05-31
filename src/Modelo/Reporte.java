package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reporte implements Serializable {

    //Atributos
    private float balance;
    private float ingreso;
    private float egreso;
    private Animal animalEstella;
    private ArrayList<Animal>  animalEnfermos;
    private Usuario empleadoEstrella;
    private LocalDate fecha;

    //Contructores
    public Reporte(float balance, float ingreso, float egreso, Animal animalEstella,
                   ArrayList<Animal> animalEnfermos, Usuario empleadoEstrella) {
        this.balance = balance;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.animalEstella = animalEstella;
        this.animalEnfermos = animalEnfermos;
        this.empleadoEstrella = empleadoEstrella;
        fecha = LocalDate.now();
    }
    //Getters and Setters

    public LocalDate getFecha() {
        return fecha;
    }


    //Metodos

    @Override
    public String toString() {
        return "Reporte{" +
                "balance=" + balance +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                ", animalEstella=" + animalEstella +
                ", animalEnfermos=" + animalEnfermos +
                ", empleadoEstrella=" + empleadoEstrella +
                ", fecha=" + fecha +
                '}';
    }
}
