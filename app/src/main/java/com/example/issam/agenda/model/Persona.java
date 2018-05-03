package com.example.issam.agenda.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.issam.agenda.MyApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class Persona extends RealmObject implements Parcelable{
    @PrimaryKey private int id;
    private String nom;
    private String cognoms;
    private int edad;
    @Index int nacimiento;

    public Persona() {
        this.id = MyApplication.PersonID.incrementAndGet();
    }

    public Persona( String nom, String cognoms, int edad) {
        this.id = MyApplication.PersonID.incrementAndGet();
        this.nom = nom;
        this.cognoms = cognoms;
        this.edad = edad;
        setNacimiento(edad);
    }


    protected Persona(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        cognoms = in.readString();
        edad = in.readInt();
        setNacimiento(edad);
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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int edad) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        this.nacimiento=year-edad;
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
        dest.writeInt(edad);
        dest.writeInt(nacimiento);
    }



}