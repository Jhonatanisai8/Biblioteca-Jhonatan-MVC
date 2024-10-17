package com.jhonatan.biblioteca;

import com.jhonatan.biblioteca.dao.GeneroImpleRepos;
import com.jhonatan.biblioteca.dao.Repositorio;
import com.jhonatan.biblioteca.modelo.Genero;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Mi biblioteca");
        ejemploGeneros();
    }

    public static void ejemploGeneros() {
        System.out.println("====CREAR UN OBJETO====");
        Repositorio<Genero> repositorio = new GeneroImpleRepos();

        //creamos unos cuanto genero
        Genero poesia = new Genero();
        poesia.setNombreGenero("Novela");

        Genero cuento = new Genero();
        cuento.setNombreGenero("Cuento");

        Genero teatro = new Genero();
        teatro.setNombreGenero("Ensayo");

        Genero cienciaFiccion = new Genero();
        cienciaFiccion.setNombreGenero("Ciencia Ficción");

        Genero romance = new Genero();
        romance.setNombreGenero("Romance");
//        repositorio.guardar(poesia);
//        repositorio.guardar(cuento);
//        repositorio.guardar(teatro);
//        repositorio.guardar(cienciaFiccion);
//        repositorio.guardar(romance);
        System.out.println("====LISTA DE GENEROS====");
        repositorio.listar().forEach(System.out::println);

        System.out.println("====POR ID====");
        System.out.println(repositorio.porId(1L));

        System.out.println("====ACTUALIZAR PRODUCTO====");
        Genero g = new Genero();
        g.setIdGenero(2L);
        g.setNombreGenero("Comedia");

        repositorio.guardar(g);

        System.out.println("====LISTA DE GENEROS====");
        repositorio.listar().forEach(System.out::println);
        
        System.out.println("====ELIMINACION DE GENERO====");
        repositorio.eliminar(2L);
        
        
        System.out.println("====LISTA DE GENEROS====");
        repositorio.listar().forEach(System.out::println);

        

    }
}
