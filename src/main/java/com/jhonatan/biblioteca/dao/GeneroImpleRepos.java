package com.jhonatan.biblioteca.dao;

import com.jhonatan.biblioteca.conexion.Conexion;
import com.jhonatan.biblioteca.modelo.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GeneroImpleRepos
        implements Repositorio<Genero> {

    private static final String SQL_SELECT = "SELECT id_genero,nombre_genero FROM genero";
    private static final String SQL_INSERT = "INSERT INTO genero(nombre_genero) VALUES (?)";
    private static final String SQL_UPDATE = "UPDATE FROM genero SET nombre = ? WHERE id_genero = ?";

    //para la conexion 
    private Connection getConection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<Genero> listar() {
        //lista de generos
        List<Genero> generos = new ArrayList<>();
        try ( Connection conn = getConection();
              Statement st = conn.createStatement();  
              ResultSet rs = st.executeQuery(SQL_SELECT)) {
            while (rs.next()) {
                Genero g = crearGenero(rs);
                //agregamos  a la lista
                generos.add(g);
            }
        } catch (SQLException ex) {
            System.out.println("error al listar los productos: " + ex.getMessage());
        }
        return generos;
    }


    @Override
    public Genero porId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Genero t) {
        String SQL;
        if (t.getIdGenero() != null && t.getIdGenero() > 0) {
            SQL = SQL_UPDATE;
        } else {
            SQL = SQL_INSERT;
        }
        try(Connection conn = getConection();
            PreparedStatement st = conn.prepareStatement(SQL);){
            st.setString(1, t.getNombreGenero());
            if (t.getIdGenero() != null && t.getIdGenero() > 0) {
                st.setLong(2, t.getIdGenero());
            } 
            st.executeUpdate();
            
        } catch(SQLException ex){
            System.out.println("error en el metodo guardar: "+ex.getMessage());
        }
    }

    @Override
    public void eliminar(Genero t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Genero crearGenero(final ResultSet rs) throws SQLException {
        Genero g = new Genero();
        g.setIdGenero(rs.getLong("id_genero"));
        g.setNombreGenero(rs.getString("nombre_genero"));
        return g;
    }
}
