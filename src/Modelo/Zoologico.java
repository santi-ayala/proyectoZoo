package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.random.RandomGenerator;

public class Zoologico implements Serializable {
    //============================
    //ATRIBUTOS
    //============================
    private String nombre;

    private Usuario admin;

    //Coleccion usuario podría ser un hashmap. Mal ahí
    private ColeccionArray<Usuario> coleccionUsuario;
    private ColeccionArray<Animal> coleccionAnimal;
    private float balance;
    private LocalDate fechaDeinicio;
    private LocalDate fechaActual;
    private HashMap<LocalDate, Reporte> historial;


    //============================
    //CONSTRUCTORES
    //============================
    public Zoologico(String nombreZoo, Usuario admin) {
        this.nombre = nombreZoo;
        if(admin.getTipoUsuario() == TipoUsuario.ADMINISTRADOR)
            this.admin = admin;

        coleccionUsuario = new ColeccionArray<Usuario>();
        coleccionAnimal = new ColeccionArray<Animal>();
        balance = 0f;
        fechaDeinicio = LocalDate.now();
        fechaActual = fechaDeinicio;

        historial = new HashMap<LocalDate, Reporte>();
    }
    public  Zoologico(){
        this.nombre = "";
        coleccionUsuario = new ColeccionArray<Usuario>();
        coleccionAnimal = new ColeccionArray<Animal>();
        balance = 0f;
        fechaDeinicio = LocalDate.now();
        fechaActual = fechaDeinicio;

        historial = new HashMap<LocalDate, Reporte>();

    }
    //============================
    //Getter and Setters
    //============================


    public float getBalance() {
        return balance;
    }

    public String getNombre() {
        return nombre;
    }

    public ColeccionArray<Usuario> getColeccionUsuario() {
        return coleccionUsuario;
    }

    public Usuario getAdmin() {
        return admin;
    }

    public ColeccionArray<Animal> getColeccionAnimal() {
        return coleccionAnimal;
    }

    public LocalDate getFechaDeinicio() {
        return fechaDeinicio;
    }

    public LocalDate getFechaActual() {
        return fechaActual;
    }

    public HashMap<LocalDate, Reporte> getHistorial() {
        return historial;
    }

    //============================
    //MÉTODOS
    //============================

    public int buscarXusuarioYcontra(String usuario, String contra){
        int posicion = 0, posicionReal = -1;
        for(Usuario usuario1: getColeccionUsuario().listado()){

            if(usuario1.getUsuario().equalsIgnoreCase(usuario) && usuario1.getContrasenia().equalsIgnoreCase(contra)){
                posicionReal = posicion;
            }
            posicion++;
        }
        return posicionReal;
    }//Busca un usuario en el array usuario y retorna la posicion

    @Override
    public String toString() {
        return "Zoologico{" +
                "nombre='" + nombre + '\'' +
                ", admin=" + admin +
                ", coleccionUsuario=" + coleccionUsuario +
                ", coleccionAnimal=" + coleccionAnimal +
                ", balance=" + balance +
                ", fechaDeinicio=" + fechaDeinicio +
                ", fechaActual=" + fechaActual +
                ", historial=" + historial +
                '}';
    }

    public int buscarXespecieYhabitatYedad(String especie, String habitat, int edad){
        int posicion = 0, posicionReal = -1;
        for(Animal animal: getColeccionAnimal().listado()){
            if(animal.getHabitat().equalsIgnoreCase(habitat) && animal.getEspecie().equalsIgnoreCase(especie) && animal.getEdad() == edad){
                posicionReal = posicion;
            }
            posicion++;
        }
        return posicionReal;
    }//Busca un animal en el array animal y retorna la posicion

    public void avanzarSimulacion() {
        //suponemos q vendemos x cantidad de entradas
        //digamos q cada entrada sale 20 dolares
        // 20* 10000 = 200.000
        //no creo que un zoologico haga más de eso por día

        RandomGenerator random = RandomGenerator.getDefault();
        balance = +random.nextFloat(100, 200000);

        float perdida = random.nextFloat(100, 50000);
        float x = balance;

        //si no nos deja quebrados restalo
        if ((x -= perdida) > 0f)
            balance -= perdida;


        // si el animal no esta enfermo, tiene 10% de chances (ponele) de enfermar
        for(Animal a: coleccionAnimal.listado()){
            if ( (a.getEstaEnfermo() == false) && 90 <= random.nextInt(1, 100) ){
                a.setEstaEnfermo(true);
            }

            a.setCantidadVisitas(random.nextInt(0, 1000));
        }

        //iteramos de vuelta porque no me siento bien
        ArrayList<Animal> animalesEnfermos = new ArrayList<Animal>();
        int contadorVisitas = 0;
        Animal animalEstrella = null;

        for(Animal a: coleccionAnimal.listado()){
            if (a.getEstaEnfermo()){
                animalesEnfermos.add(a);
            }

            if(a.getCantidadVisitas() > contadorVisitas){
                animalEstrella = a;
                contadorVisitas = a.getCantidadVisitas();
            }
        }

        //pido disculpas por todo este método
        //es tarde

        int topTareasHechas = 0;
        Usuario empleadoEstrella = null;
        for (Usuario u: coleccionUsuario.listado()){
            ArrayList<Tarea> listaTareas = u.getTareas();
            int tareasHechas = 0;

            for (Tarea t : listaTareas){
                if(t.isCompletado()){
                    tareasHechas++;
                }
            }

            if (tareasHechas > topTareasHechas){
                topTareasHechas = tareasHechas;
                empleadoEstrella = u;
            }

        }

        //TODO: escribir reportes a disco
        Reporte reporte = new Reporte(balance, animalEstrella, animalesEnfermos, empleadoEstrella, fechaActual);
        historial.put(fechaActual, reporte);
        
        fechaActual = fechaActual.plusDays(1);
    }//Avanza un dia
}
