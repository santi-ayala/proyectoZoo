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
    public Reporte(float balance, Animal animalEstrella, ArrayList<Animal> animalEnfermos, Usuario empleadoEstrella) {
        this.balance = balance;
        this.animalEstrella = animalEstrella;
        this.animalEnfermos = animalEnfermos;
        this.empleadoEstrella = empleadoEstrella;
        fecha = LocalDate.now();
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
        //FIXME: esta re varela este tostring
        return "Reporte{" +
                "balance=" + balance +
                //", ingreso=" + ingreso +
                //", egreso=" + egreso +
                ", animalEstella=" + animalEstrella +
                ", animalEnfermos=" + animalEnfermos +
                ", empleadoEstrella=" + empleadoEstrella +
                ", fecha=" + fecha +
                '}';
    }
}
