package com.jhonatan.biblioteca.modelo;

public class Libro {

    private int idLibro;
    private String titulo;
    private String autor;
    private String idioma;
    private int anioPublicacion;
    private int copiasDisponibles;
    private int copiasTotales;
    private int edicion;
    private Editorial editorial;
    private Genero genero;

    public Libro() {
    }

    public Libro(int idLibro, String titulo, String autor, String idioma, int anioPublicacion, int copiasDisponibles, int copiasTotales, int edicion, Editorial editorial, Genero genero) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.anioPublicacion = anioPublicacion;
        this.copiasDisponibles = copiasDisponibles;
        this.copiasTotales = copiasTotales;
        this.edicion = edicion;
        this.editorial = editorial;
        this.genero = genero;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    public int getCopiasTotales() {
        return copiasTotales;
    }

    public void setCopiasTotales(int copiasTotales) {
        this.copiasTotales = copiasTotales;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return idLibro + " | " + titulo + " | " + autor + " | " + idioma + " | " + anioPublicacion + " | " + copiasDisponibles + " | " + copiasTotales + " | " + editorial.getNombreEditorial() + " | " + genero.getNombreGenero();
    }

}
