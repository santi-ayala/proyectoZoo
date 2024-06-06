package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.random.RandomGenerator;

public class Zoologico implements Serializable {
    //============================
    //ATRIBUTOS
    //============================
    private String nombre;
    private Usuario admin;
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

    public ColeccionArray<Usuario> getColeccionUsuario() {
        return coleccionUsuario;
    }

    public void setColeccionUsuario(ColeccionArray<Usuario> coleccionUsuario) {
        this.coleccionUsuario = coleccionUsuario;
    }

    public ColeccionArray<Animal> getColeccionAnimal() {
        return coleccionAnimal;
    }

    public void setColeccionAnimal(ColeccionArray<Animal> coleccionAnimal) {
        this.coleccionAnimal = coleccionAnimal;
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

    public void setHistorial(HashMap<LocalDate, Reporte> historial) {
        this.historial = historial;
    }
    //============================
    //MÉTODOS
    //============================

    public int buscarXusuarioYcontra(String usuario, String contra){
        int posicion = 0, posicionReal = -1;
        for(Usuario usuario1: getColeccionUsuario().listado()){

            //si los strings pasados por parametro equivalen a alguno de los usuarios del array de nuestro zoo
            //TODO: este if ignora capitalización, dudoso
            if(usuario1.getUsuario().equalsIgnoreCase(usuario) && usuario1.getContrasenia().equalsIgnoreCase(contra)){
                posicionReal = posicion;
            }
            posicion++;
        }
        return posicionReal;
    }

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
    }

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
        Reporte reporte = new Reporte(balance, animalEstrella, animalesEnfermos, empleadoEstrella);
        historial.put(fechaActual, reporte);
        
        fechaActual = fechaActual.plusDays(1);
    }
    
    
    
    
    
    
    
    
    //TODO: mover todo esto a usuarios
    //Mostrar animales
    public void mostrarAnimales(){
     ArrayList<Animal> animales = coleccionAnimal.listado();
     for(int i=0; i<animales.size();i++){
         System.out.println(animales.get(i));
     }
    }
    
//FUNCIONES EMPLEADO////////////////////////////////////
    public boolean marcarTareaCompletada(String tarea, Usuario empleado){

        boolean verificacion = true;

        ArrayList<Tarea> tareas = empleado.getTareas();

        for(int i=0; i<tareas.size(); i++){

         if(tareas.get(i).getAccion().equals(tarea)){

             tareas.get(i).setCompletado(true);

             verificacion=true;




         }else{

             verificacion=false;

         }

        }

        return verificacion;

    }

    public boolean curarAnimal(String especie){

        boolean verificacion = true;

        ArrayList<Animal> animales = coleccionAnimal.listado();

        for(int i=0; i<animales.size(); i++){

            if(animales.get(i).getEspecie().equals(especie)){

                animales.get(i).setEstaEnfermo(true);

                verificacion=true;




            }else{

                verificacion=false;

            }

        }

        return verificacion;

    }






}
