package com.jhonatan.biblioteca.dao;

import com.jhonatan.biblioteca.conexion.Conexion;
import com.jhonatan.biblioteca.modelo.Editorial;
import com.jhonatan.biblioteca.modelo.Genero;
import com.jhonatan.biblioteca.modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroImpleRepos
        implements Repositorio<Libro> {

    private static final String SQL_SELECT = "SELECT i.*, "
            + "g.nombre_genero, "
            + "e.nombre_edi "
            + "FROM libro AS i "
            + "INNER JOIN genero AS g "
            + "ON  i.id_genero = g.id_genero "
            + "INNER JOIN editorial AS e "
            + "ON e.id_editorial = i.id_editorial";
    private static final String SQL_UPDATE = "UPDATE libro SET titulo  = ?, autor = ?, idioma = ?,anio_publicacion = ? ,copias_disponibles = ? "
            + ",total_copias = ?, edicion = ?, id_editorial = ?,id_genero = ? WHERE id_libro = ?";
    private static final String SQL_INSERT = "INSERT INTO libro (titulo,autor,idioma,anio_publicacion,copias_disponibles,total_copias,edicion,id_editorial,id_genero) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String SQL_SEARCH = "SELECT i.*, "
            + "g.nombre_genero, "
            + "e.nombre_edi "
            + "FROM libro AS i "
            + "INNER JOIN genero AS g "
            + "ON  i.id_genero = g.id_genero "
            + "INNER JOIN editorial AS e "
            + "ON e.id_editorial = i.id_editorial "
            + "WHERE i.id_libro = ?";

    private Connection getConection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<Libro> listar() {
        List<Libro> libros = new ArrayList<>();
        try ( Connection con = getConection();  Statement st = con.createStatement();  ResultSet rs = st.executeQuery(SQL_SELECT);) {
            while (rs.next()) {
                Libro libro = crearLibro(rs);
                libros.add(libro);
            }

        } catch (SQLException ex) {
            System.out.println("error al listar libros: " + ex.getMessage());
        }
        return libros;
    }

    @Override
    public Libro porId(Long id) {
        Libro libro = null;
        try ( Connection con = getConection();  PreparedStatement pr = con.prepareStatement(SQL_SEARCH);) {
            pr.setLong(1, id);
            try ( ResultSet rs = pr.executeQuery();) {
                if (rs.next()) {
                    libro = crearLibro(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("error al bsucar libro  por id: " + e.getMessage());
        }
        return libro;
    }

    @Override
    public void guardar(Libro t) {
        String sql;
        if (t.getIdLibro() != null && t.getIdLibro() > 0) {
            sql = SQL_UPDATE;
        } else {
            sql = SQL_INSERT;
        }
        try ( Connection con = getConection();  PreparedStatement st = con.prepareStatement(sql);) {
            //le pasamos los parametros
            st.setString(1, t.getTitulo());
            st.setString(2, t.getAutor());
            st.setString(3, t.getIdioma());
            st.setInt(4, t.getAnioPublicacion());
            st.setInt(5, t.getCopiasDisponibles());
            st.setInt(6, t.getCopiasTotales());
            st.setInt(7, t.getEdicion());
            st.setLong(8, t.getEditorial().getIdEditorial());
            st.setLong(9, t.getGenero().getIdGenero());

            if (t.getIdLibro() != null && t.getIdLibro() > 0) {
                st.setLong(10, t.getIdLibro());
            }
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error al guardar o insertar libro: " + ex.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Libro crearLibro(final ResultSet rs) throws SQLException {
        Libro libro = new Libro();
        libro.setIdLibro(rs.getLong("id_libro"));
        libro.setTitulo(rs.getString("titulo"));
        libro.setAutor(rs.getString("autor"));
        libro.setIdioma(rs.getString("idioma"));
        libro.setAnioPublicacion(rs.getInt("anio_publicacion"));
        libro.setCopiasDisponibles(rs.getInt("copias_disponibles"));
        libro.setCopiasTotales(rs.getInt("total_copias"));
        libro.setEdicion(rs.getInt("edicion"));
        //para el genero
        Genero genero = new Genero();
        genero.setIdGenero(rs.getLong("id_genero"));
        genero.setNombreGenero(rs.getString("nombre_genero"));
        //para el editorial
        Editorial editorial = new Editorial();
        editorial.setIdEditorial(rs.getLong("id_editorial"));
        editorial.setNombre(rs.getString("nombre_edi"));
        editorial.setPais("pais");
        //stablecemos el genero y la editorial al libro
        libro.setGenero(genero);
        libro.setEditorial(editorial);
        return libro;
    }
}
