package com.example.laborator4;

public class Melodie {
    private String titlu;  //editText
    private String artist;  //editText
    private String genMuzical;  //radioButton
    private int anLansare;      //spinner
    private float nota;       //ratingBar
    private boolean esteLansata; //checkBox

    public Melodie() {
    }

    public Melodie(String titlu, String artist, String genMuzical, int anLansare, float nota, boolean esteLansata){
        this.titlu=titlu;
        this.artist=artist;
        this.genMuzical=genMuzical;
        this.anLansare=anLansare;
        this.nota=nota;
        this.esteLansata=esteLansata;
    }

    public String getTitlu() {
        return titlu;
    }
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenMuzical() {
        return genMuzical;
    }
    public void setGenMuzical(String genMuzical) {
        this.genMuzical = genMuzical;
    }

    public int getAnLansare() {
        return anLansare;
    }
    public void setAnLansare(int anLansare) {
        this.anLansare = anLansare;
    }

    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }

    public boolean isEsteLansata() {
        return esteLansata;
    }
    public void setEsteLansata(boolean esteLansata) {
        this.esteLansata = esteLansata;
    }

    @Override
    public String toString() {
        return titlu + " - " + artist + "\nGen: " + genMuzical
                + "\nAn: " + anLansare
                + "\nRating: " + nota
                + "\nLansată: " + (esteLansata ? "da" : "nu");
    }
}
