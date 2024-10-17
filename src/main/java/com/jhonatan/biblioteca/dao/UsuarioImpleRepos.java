package com.jhonatan.biblioteca.dao;

import com.jhonatan.biblioteca.conexion.Conexion;
import com.jhonatan.biblioteca.modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioImpleRepos
        implements Repositorio<Usuario> {

    private static final String SQL_SELECT = "SELECT id_usuario,nombre_usu,apellido1,apellido2,telefono,email,direccion FROM usuario";

    //para la conexion 
    private Connection getConection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        try ( Connection conn = getConection();  Statement st = conn.createStatement();  ResultSet rs = st.executeQuery(SQL_SELECT);) {
            while (rs.next()) {
                Usuario usuario = crearUsuario(rs);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("error al listar: " + ex.getMessage());
        }
        return usuarios;
    }

    @Override
    public Usuario porId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Usuario crearUsuario(final ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getLong("id_usuario"));
        usuario.setNombre(rs.getString("nombre_usu"));
        usuario.setApellido1(rs.getString("apellido1"));
        usuario.setApellido2(rs.getString("apellido2"));
        usuario.setTelefono(rs.getString("telefono"));
        usuario.setEmail(rs.getString("email"));
        usuario.setDireccion(rs.getString("direccion"));
        return usuario;
    }

}
