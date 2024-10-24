package com.jhonatan.biblioteca;

import com.jhonatan.biblioteca.dao.EditorialImpleRepos;
import com.jhonatan.biblioteca.dao.GeneroImpleRepos;
import com.jhonatan.biblioteca.dao.LibroImpleRepos;
import com.jhonatan.biblioteca.dao.Repositorio;
import com.jhonatan.biblioteca.dao.UsuarioImpleRepos;
import com.jhonatan.biblioteca.modelo.Editorial;
import com.jhonatan.biblioteca.modelo.Genero;
import com.jhonatan.biblioteca.modelo.Libro;
import com.jhonatan.biblioteca.modelo.Usuario;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Mi biblioteca");
        //ejemploGeneros();
        //ejemploEditoriales();
        //ejemploUsuarios();
        insertarLibroEjemplo();
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

    public static void ejemploUsuarios() {
        Repositorio<Usuario> repositorio = new UsuarioImpleRepos();
        System.out.println("====CREACION DE USUARIOS====");

        //creamos los objetos de tipo usuario
        Usuario juan = new Usuario();
        juan.setNombre("Juan Aldair");
        juan.setApellido1("Perez");
        juan.setApellido2("Lopez");
        juan.setTelefono("987654321");
        juan.setEmail("juan@gmail.com");
        juan.setDireccion("Los Olivos");

        Usuario pedro = new Usuario();
        pedro.setNombre("Pedro Alex");
        pedro.setApellido1("Rios");
        pedro.setApellido2("Jaurez");
        pedro.setTelefono("987123321");
        pedro.setEmail("Alex@gmail.com");
        pedro.setDireccion("Comas");

        //repositorio.guardar(juan);
        //repositorio.guardar(pedro);
        //System.out.println("objetos insertados correctamente...........");
        System.out.println("====LISTA DE USUARIOS====");
        repositorio.listar().forEach(System.out::println);

        System.out.println("====MODIFICACION DE USUARIO====");
        Usuario alex = new Usuario();
        alex.setIdUsuario(1L);
        alex.setNombre("Alex Samir");
        alex.setApellido1("Valdivieso");
        alex.setApellido2("Lopez");
        alex.setTelefono("911123321");
        alex.setEmail("valida@gmail.com");
        alex.setDireccion("Miraflores");
        //repositorio.guardar(alex);
        //System.out.println("modificacion de usuario exitosoo con id: " + alex.getIdUsuario());

        System.out.println("====LISTA DE USUARIOS====");
        repositorio.listar().forEach(System.out::println);

        System.out.println("====BUSCANDO USUARIO====");
        System.out.println(repositorio.porId(2L));

        System.out.println("====ELIMINACION DE USUARIO====");
        repositorio.eliminar(2L);
        System.out.println("Usuario eliminado------");

        System.out.println("====LISTA DE USUARIOS====");
        repositorio.listar().forEach(System.out::println);

    }

    public static void insertarLibroEjemplo() {
        Repositorio<Libro> repositorio = new LibroImpleRepos();
        //System.out.println("==INSERTANDO LIBROS==");
        Editorial simon = new Editorial();
        simon.setIdEditorial(3L);
        Genero novela = new Genero();
        novela.setIdGenero(1L);

//        Libro ejemplo1 = new Libro();
//        ejemplo1.setTitulo("Ejemplo 01");
//        ejemplo1.setAutor("Jhonatan Isai Ojeda Sanchez");
//        ejemplo1.setIdioma("Español");
//        ejemplo1.setAnioPublicacion(2035);
//        ejemplo1.setCopiasDisponibles(150);
//        ejemplo1.setCopiasTotales(150);
//        ejemplo1.setEdicion(5);
//        ejemplo1.setGenero(novela);
//        ejemplo1.setEditorial(simon);
//        repositorio.guardar(ejemplo1);
//        System.out.println("libroooo guardado........");
//        Libro ejemplo1 = new Libro();
//        ejemplo1.setTitulo("Ejemplo 02");
//        ejemplo1.setAutor("Daniel Ojeda Sanchez");
//        ejemplo1.setIdioma("Ingles");
//        ejemplo1.setAnioPublicacion(2038);
//        ejemplo1.setCopiasDisponibles(120);
//        ejemplo1.setCopiasTotales(120);
//        ejemplo1.setEdicion(6);
//        ejemplo1.setGenero(novela);
//        ejemplo1.setEditorial(simon);
//
//        repositorio.guardar(ejemplo1);
//        System.out.println("libroooo guardado........");
        System.out.println("==LISTANDO LIBROS==");
        repositorio.listar().forEach(System.out::println);

        if (repositorio.listar().isEmpty()) {
            System.out.println("LISTA DE LIBROS VACIA");
        }

        Libro ejemplo1 = new Libro();
        ejemplo1.setTitulo("Ejemplo 03");
        ejemplo1.setAutor("Lucas Alonso");
        ejemplo1.setIdioma("Español");
        ejemplo1.setAnioPublicacion(2033);
        ejemplo1.setCopiasDisponibles(10);
        ejemplo1.setCopiasTotales(10);
        ejemplo1.setEdicion(5);
        ejemplo1.setGenero(novela);
        ejemplo1.setEditorial(simon);

        repositorio.guardar(ejemplo1);
        System.out.println("libro insertadooooo.......");

        System.out.println("==BUSCANDO LIBRO==");
        Long idBuscar = 1l;
        Libro libroBuscado = repositorio.porId(idBuscar);
        System.out.println(libroBuscado);
        System.out.println("libro encontrado con id: " + idBuscar);

        System.out.println("\t========MODIFICACION DE PRODUCTO========");
        libroBuscado.setAnioPublicacion(2035);
        libroBuscado.setIdioma("Ingles");
        repositorio.guardar(libroBuscado);
        System.out.println("libro modificado.........................");

        System.out.println("==LISTANDO LIBROS==");
        repositorio.listar().forEach(System.out::println);
        if (repositorio.listar().isEmpty()) {
            System.out.println("LISTA DE LIBROS VACIA");
        }
        
        System.out.println("=ELIMINANDO UN LIBRO=");
        repositorio.eliminar(3L);
        repositorio.eliminar(4L);
        repositorio.eliminar(5L);
        System.out.println("libro eliminado......");
        
        System.out.println("==LISTANDO LIBROS==");
        repositorio.listar().forEach(System.out::println);
        
        if (repositorio.listar().isEmpty()) {
            System.out.println("LISTA DE LIBROS VACIA");
        }
    }
}
