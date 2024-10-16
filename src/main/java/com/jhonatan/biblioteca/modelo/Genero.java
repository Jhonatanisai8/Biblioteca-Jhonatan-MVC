package com.jhonatan.biblioteca.modelo;

public class Genero {

    private int idGenero;
    private String nombreGenero;

    public Genero() {
    }

    public Genero(int idGenero, String nombreGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    @Override
    public String toString() {
        return idGenero + " | " + nombreGenero;
    }

}
