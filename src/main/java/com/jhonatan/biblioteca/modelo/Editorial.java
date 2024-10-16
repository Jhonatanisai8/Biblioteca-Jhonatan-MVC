package com.jhonatan.biblioteca.modelo;

public class Editorial {

    private int idEditorial;
    private String nombreEditorial;

    public Editorial() {
    }

    public Editorial(int idEditorial, String nombreEditorial) {
        this.idEditorial = idEditorial;
        this.nombreEditorial = nombreEditorial;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public void setNombre(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    @Override
    public String toString() {
        return idEditorial + " | " + nombreEditorial;
    }

}
