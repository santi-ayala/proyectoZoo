package Modelo;

import java.util.Random;

public class Animal {

    //Atributos
    private String especie;
    private String habitat;
    private int cantidadVisitas;
    private Boolean salud;
    private int edad;
    private String dieta;
    private String observaciones;

    //Constructores
    public Animal(String observaciones) {
        this.especie =  ; //json
        this.dieta = ;//json
        habitat = ;//json
        this.cantidadVisitas = visitas();
        this.salud = estadoSalud();
        this.edad = edadRandom();
        this.observaciones = observaciones ;
    }

    //Getters and Setters
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getHabitat() {
        return habitat;
    }
    public void setHabitat(String habitat) {
        habitat = habitat;
    }
    public int getCantidadVisitas() {
        return cantidadVisitas;
    }
    public Boolean getSalud() {
        return salud;
    }
    public void setSalud(Boolean salud) {
        this.salud = salud;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDieta() {
        return dieta;
    }
    public void setDieta(String dieta) {
        this.dieta = dieta;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    //Metodos
    public int visitas(){
        Random random =new Random();
        return random.nextInt(1500) + 1;
    }
    public boolean estadoSalud(){
        boolean salud = false;
        Random random =new Random();
        int randomNumber = random.nextInt(2);
        if(randomNumber == 1){
            salud = true;
        }
        return salud;
    }
    public int edadRandom(){
        Random random =new Random();
        return random.nextInt(50) + 1;
    }




}
