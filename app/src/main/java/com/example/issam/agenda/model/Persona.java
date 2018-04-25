package com.example.issam.agenda.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.issam.agenda.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Persona extends RealmObject implements Parcelable{
    @PrimaryKey private int id;
    private String nom;
    private String cognoms;
    private String edad;

    public Persona() {
        this.id = MyApplication.PersonID.incrementAndGet();
    }

    public Persona( String nom, String cognoms, String edad) {
        this.id = MyApplication.PersonID.incrementAndGet();
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

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(cognoms);
        dest.writeString(edad);
    }
}