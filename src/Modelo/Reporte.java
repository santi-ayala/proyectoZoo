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
    private Animal animalEstella;
    private ArrayList<Animal>  animalEnfermos;
    private Usuario empleadoEstrella;
    private LocalDate fecha;

    //Contructores
    public Reporte(float balance, Animal animalEstella, ArrayList<Animal> animalEnfermos, Usuario empleadoEstrella) {
        this.balance = balance;
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
                ", animalEstella=" + animalEstella +
                ", animalEnfermos=" + animalEnfermos +
                ", empleadoEstrella=" + empleadoEstrella +
                ", fecha=" + fecha +
                '}';
    }
}
