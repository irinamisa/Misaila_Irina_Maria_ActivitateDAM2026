package com.example.exercitiu_extra_s9;

import java.io.Serializable;

public class Automobil implements Serializable {
    private int idAutomobil;           //edittext
    private String marca;              //spinner
    private String model;              //edittext
    private float capacitateAutomobil; //edittext
    private int anFabricatie;         //numberpicker
    private boolean esteElectric;     //checkbox

    public Automobil() {
    }

    public Automobil(int anFabricatie, float capacitateAutomobil, boolean esteElectric, int idAutomobil, String marca, String model) {
        this.anFabricatie = anFabricatie;
        this.capacitateAutomobil = capacitateAutomobil;
        this.esteElectric = esteElectric;
        this.idAutomobil = idAutomobil;
        this.marca = marca;
        this.model = model;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public float getCapacitateAutomobil() {
        return capacitateAutomobil;
    }

    public void setCapacitateAutomobil(float capacitateAutomobil) {
        this.capacitateAutomobil = capacitateAutomobil;
    }

    public boolean isEsteElectric() {
        return esteElectric;
    }

    public void setEsteElectric(boolean esteElectric) {
        this.esteElectric = esteElectric;
    }

    public int getIdAutomobil() {
        return idAutomobil;
    }

    public void setIdAutomobil(int idAutomobil) {
        this.idAutomobil = idAutomobil;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Automobil{" +
                "anFabricatie=" + anFabricatie +
                ", idAutomobil=" + idAutomobil +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", capacitateAutomobil=" + capacitateAutomobil +
                ", esteElectric=" + esteElectric +
                '}';
    }
}
