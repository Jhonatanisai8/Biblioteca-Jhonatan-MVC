package com.jhonatan.biblioteca;

import com.jhonatan.biblioteca.dao.EditorialImpleRepos;
import com.jhonatan.biblioteca.dao.GeneroImpleRepos;
import com.jhonatan.biblioteca.dao.Repositorio;
import com.jhonatan.biblioteca.modelo.Editorial;
import com.jhonatan.biblioteca.modelo.Genero;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Mi biblioteca");
        //ejemploGeneros();
        ejemploEditoriales();
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

    public static void ejemploEditoriales() {
        Repositorio<Editorial> repositorio = new EditorialImpleRepos();
        System.out.println("=====CREANDO EDITORIALES=====");

        Editorial penguin = new Editorial();
        penguin.setNombre("Penguin Random House");
        penguin.setPais("Reino Unido");

        Editorial publishers = new Editorial();
        publishers.setNombre("HarperCollins Publishers");
        publishers.setPais("Estados Unidos");

        Editorial simon = new Editorial();
        simon.setNombre("Simon & Schuster");
        simon.setPais("Estados Unidos");

        Editorial hachette = new Editorial();
        hachette.setNombre("Hachette Book Group");
        hachette.setPais("Francia");

        Editorial macmillan = new Editorial();
        macmillan.setNombre("Macmillan Publishers");
        macmillan.setPais("Reino Unido");

        //guaurdamos
        /*repositorio.guardar(penguin);
        repositorio.guardar(publishers);
        repositorio.guardar(simon);
        repositorio.guardar(hachette);
        repositorio.guardar(macmillan);*/
        System.out.println("Editoriales guardados.....");

        System.out.println("=====LISTADO DE EDITORIALES=====");
        repositorio.listar().forEach(System.out::println);

        System.out.println("=====MODIFICACION DE ALGUNA EDITORIAL=====");
        Editorial cambridge = new Editorial();
        cambridge.setIdEditorial(5L);
        cambridge.setNombre("Cambridge University");
        cambridge.setPais("Reino Unido");

        /*repositorio.guardar(cambridge);
        System.out.println("Modificacion de editorial con id: "+cambridge.getIdEditorial());*/
        System.out.println("=====ELIMINACION DE ALGUA EDITORIAL=====");
        Long idEliminar = 1L;
        repositorio.eliminar(idEliminar);
        System.out.println("eliminacion de la editorial con id: " + idEliminar);

        System.out.println("=====LISTADO DE EDITORIALES=====");
        repositorio.listar().forEach(System.out::println);
    }
}
