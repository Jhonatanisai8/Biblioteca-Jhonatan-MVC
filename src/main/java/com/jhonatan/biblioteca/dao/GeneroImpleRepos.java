package com.jhonatan.biblioteca.dao;

import com.jhonatan.biblioteca.conexion.Conexion;
import com.jhonatan.biblioteca.modelo.Genero;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GeneroImpleRepos
        implements Repositorio<Genero> {

    private static final String SQL_SELECT = "SELECT id_genero,nombre_genero FROM genero";
    

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

    private Genero crearGenero(final ResultSet rs) throws SQLException {
        Genero g = new Genero();
        g.setIdGenero(rs.getInt("id_genero"));
        g.setNombreGenero(rs.getString("nombre_genero"));
        return g;
    }

    @Override
    public Genero porId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Genero t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Genero t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
