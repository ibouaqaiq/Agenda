package com.example.issam.agenda.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

public class Persona extends RealmObject{
    private int id;
    private String nom;
    private String cognoms;
    private String edad;

    public Persona() {
    }


    public Persona(String nom, String cognoms, String edad) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.edad = edad;
    }

    protected Persona(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        cognoms = in.readString();
        edad = in.readString();
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEdad() {
        return edad;
    }


}