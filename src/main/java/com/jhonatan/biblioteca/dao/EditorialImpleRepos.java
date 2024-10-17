package com.jhonatan.biblioteca.dao;

import com.jhonatan.biblioteca.conexion.Conexion;
import com.jhonatan.biblioteca.modelo.Editorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EditorialImpleRepos
        implements Repositorio<Editorial> {

    private static final String SQL_SELECT = "SELECT id_editorial,nombre_edi,pais FROM editorial";
    private static final String SQL_SEARCH = "SELECT id_editorial,nombre_edi,pais FROM editorial WHERE id_editorial =  ?";
    private static final String SQL_INSERT = "INSERT INTO editorial(nombre_edi,pais) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE editorial SET nombre_edi = ?, pais = ? WHERE id_editorial = ?";
    private static final String SQL_DELETE = "DELETE FROM editorial WHERE id_editorial = ?";

    //para la conexion 
    private Connection getConection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<Editorial> listar() {
        List<Editorial> editoriales = new ArrayList<>();
        try ( Connection conn = getConection();  Statement st = conn.createStatement();  ResultSet rs = st.executeQuery(SQL_SELECT);) {
            while (rs.next()) {
                Editorial e = crearEditorial(rs);
                editoriales.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("error al listar los editoriales: " + ex.getMessage());
        }
        return editoriales;
    }

    @Override
    public Editorial porId(Long id) {
        Editorial ed = null;
        try ( Connection conn = getConection();  PreparedStatement st = conn.prepareStatement(SQL_SEARCH);) {
            st.setLong(1, id);
            try ( ResultSet rs = st.executeQuery();) {
                if (rs.next()) {
                    ed = crearEditorial(rs);
                }
            }
        } catch (SQLException ex) {
            System.out.println("error en poriD: " + ex.getMessage());
        }
        return ed;
    }

    @Override
    public void guardar(Editorial t) {
        String SQL;
        if (t.getIdEditorial() != null && t.getIdEditorial() > 0) {
            SQL = SQL_UPDATE;
        } else {
            SQL = SQL_INSERT;
        }
        try ( Connection conn = getConection();  PreparedStatement st = conn.prepareStatement(SQL);) {
            st.setString(1, t.getNombreEditorial());
            st.setString(2, t.getPais());
            if (t.getIdEditorial() != null && t.getIdEditorial() > 0) {
                st.setLong(3, t.getIdEditorial());
            }
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error al guardar o modificar: " + ex.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) {
        try ( Connection conn = getConection();  PreparedStatement st = conn.prepareStatement(SQL_DELETE);) {
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar un editorial: " + ex.getMessage());
        }
    }

    private Editorial crearEditorial(final ResultSet rs) throws SQLException {
        Editorial e = new Editorial();
        e.setIdEditorial(rs.getLong("id_editorial"));
        e.setNombre(rs.getString("nombre_edi"));
        e.setPais(rs.getString("pais"));
        return e;
    }

}
