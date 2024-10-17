package com.jhonatan.biblioteca.modelo;

public class Genero {

    private Long idGenero;
    private String nombreGenero;

    public Genero() {
    }

    public Genero(Long idGenero, String nombreGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setIdGenero(Long idGenero) {
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
