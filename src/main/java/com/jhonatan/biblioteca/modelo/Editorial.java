package com.jhonatan.biblioteca.modelo;

public class Editorial {

    private Long idEditorial;
    private String nombreEditorial;
    private String pais;

    public Editorial() {
    }

    public Editorial(Long idEditorial, String nombreEditorial, String pais) {
        this.idEditorial = idEditorial;
        this.nombreEditorial = nombreEditorial;
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getIdEditorial() {
        return idEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setIdEditorial(Long idEditorial) {
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
