package com.example.issam.agenda.model;

import io.realm.RealmObject;

public class Persona extends RealmObject {
    private int id;
    private String nom;
    private String cognoms;
    private int edad;

    public Persona() {
    }


    public Persona(String nomPersona, String cognomsPersona, int edadPersona) {
        this.nom = nomPersona;
        this.cognoms = cognomsPersona;
        this.edad = edadPersona;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void posarNom(String valornom) {
        nom = valornom;
    }
    public void posarCognoms(String valorcognoms) {
        cognoms = valorcognoms;
    }
    public void posarEdad (int valoredad){edad = valoredad; }

    public String obtenirNom(){
        return nom;
    }
    public String obtenirCognoms(){
        return cognoms;
    }

    public int obtenirEdad(){
        return edad;
    }
}