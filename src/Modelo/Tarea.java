package Modelo;

import java.io.Serializable;

public class Tarea implements Serializable {

    private String accion;

    private boolean completado;

    public Tarea(String accion) {
        this.accion = accion;
        this.completado = false;
    }

    public String getAccion() {
        return accion;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

}
