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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Editorial crearEditorial(final ResultSet rs) throws SQLException {
        Editorial e = new Editorial();
        e.setIdEditorial(rs.getLong("id_editorial"));
        e.setNombre(rs.getString("nombre_edi"));
        e.setPais(rs.getString("pais"));
        return e;
    }

}
