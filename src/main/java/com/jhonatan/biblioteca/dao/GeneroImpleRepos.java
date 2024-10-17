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
    private static final String SQL_UPDATE = "UPDATE  genero SET nombre_genero = ? WHERE id_genero = ?";
    private static final String SQL_DELETE = "DELETE FROM genero WHERE id_genero = ?";
    private static final String SQL_SEARCH = "SELECT id_genero,nombre_genero FROM genero WHERE id_genero = ?";
    
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
        Genero g = null;
        try(Connection conn = getConection();
            PreparedStatement st = conn.prepareStatement(SQL_SEARCH);
            ){
            st.setLong(1, id);
            try(ResultSet rs = st.executeQuery(); ){
                if (rs.next()) {
                    g = crearGenero(rs);
                }
            }
        } catch(SQLException ex){
            System.out.println("error en porId: "+ex.getMessage());
        }
        return g;
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
    public void eliminar(Long id) {
        try(Connection conn = getConection();
            PreparedStatement st = conn.prepareStatement(SQL_DELETE);){
            st.setLong(1, id);
            st.executeUpdate();
        } catch(SQLException ex){
            System.out.println("Error al eliminar un genero: "+ex.getMessage());
        }
    }

    private Genero crearGenero(final ResultSet rs) throws SQLException {
        Genero g = new Genero();
        g.setIdGenero(rs.getLong("id_genero"));
        g.setNombreGenero(rs.getString("nombre_genero"));
        return g;
    }
}
