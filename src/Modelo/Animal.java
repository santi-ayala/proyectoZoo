package Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;



public class Animal {

    //Atributos
    private String especie;
    private String habitat;
    private int cantidadVisitas;
    private Boolean estaEnfermo;
    private int edad;
    private String dieta;
    private String observaciones;

    //Constructores
    public Animal(String observaciones) {
        int random = randomCantAnimalesJson();
        this.dieta = dietaJson(random);//json
        habitat = habitatJson(random);//json
        this.especie = especieJson(random); //json
        this.cantidadVisitas = visitas();
        this.estaEnfermo = estadoSalud();
        this.edad = edadRandom();
        this.observaciones = observaciones ;
    }

    public Animal(String especie, String habitat, int edad, String dieta, String observaciones) {
        this.especie = especie;
        this.habitat = habitat;
        this.cantidadVisitas = visitas();
        this.estaEnfermo =  estadoSalud();
        this.edad = edad;
        this.dieta = dieta;
        this.observaciones = observaciones;
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
    public Boolean getEstaEnfermo() {
        return estaEnfermo;
    }
    public void setEstaEnfermo(Boolean estaEnfermo) {
        this.estaEnfermo = estaEnfermo;
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
    public void setCantidadVisitas(int cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

    //Metodos
    public int visitas(){
        Random random =new Random();
        return random.nextInt(1500) + 1;
    } //Esta funcion te retorna de manera random las visitas
    public boolean estadoSalud(){
        boolean salud = false;
        Random random =new Random();
        int randomNumber = random.nextInt(2);
        if(randomNumber == 1){
            salud = true;
        }
        return salud;
    }//Esta funcion te retorna de manera random el estado Salud
    public int edadRandom(){
        Random random =new Random();
        return random.nextInt(50) + 1;
    }//Esta funcion te retorna de manera random la edad
    public String especieJson(int random){
        String jsonString = UtilesJson.leer("Animales");
        String especie ="";
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(random);
            especie = jsonObject.getString("especie");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return especie;
    } //Esta funcion busca en el Json y te devuelve una especie
    public String dietaJson(int random){
        String jsonString = UtilesJson.leer("Animales");
        String dieta ="";
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(random);
            dieta = jsonObject.getString("dieta");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return dieta;
    }//Esta funcion busca en el Json y te devuelve una dieta
    public String habitatJson(int random){
        String jsonString = UtilesJson.leer("Animales");
        String habitat ="";
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = jsonArray.getJSONObject(random);
            habitat = jsonObject.getString("habitat");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return habitat;
    }//Esta funcion busca en el Json y te devuelve una habitat
    public int randomCantAnimalesJson(){
        String jsonString = UtilesJson.leer("Animales");
        Random random = new Random();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            return random.nextInt(jsonArray.length());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }//Esta funcion devuelve de manera random segun la cantidad de objetos que hay en el Json

    @Override
    public String toString() {
        return "Animal{" +
                "especie='" + especie + '\'' +
                ", habitat='" + habitat + '\'' +
                ", cantidadVisitas=" + cantidadVisitas +
                ", salud=" + estaEnfermo +
                ", edad=" + edad +
                ", dieta='" + dieta + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
    public boolean equals(Object o) {
        boolean esFalso = false;
        if(o != null && o instanceof Animal){
            Animal animal = (Animal) o;
            if(animal.getEspecie().equalsIgnoreCase(especie) && animal.getEdad() == edad && animal.getHabitat().equalsIgnoreCase(habitat) ){
                esFalso = true;
            }
        }
        return esFalso;
    }
}
