package Modelo;

public class Tarea {

    private String accion;

    private boolean completado;

    public Tarea(String accion, boolean completado) {
        this.accion = accion;
        this.completado = completado;
    }

    public String getAccion() {
        return accion;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

}
