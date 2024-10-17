package com.jhonatan.biblioteca.dao;

import com.jhonatan.biblioteca.conexion.Conexion;
import com.jhonatan.biblioteca.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioImpleRepos
        implements Repositorio<Usuario> {

    private static final String SQL_SELECT = "SELECT id_usuario,nombre_usu,apellido1,apellido2,telefono,email,direccion FROM usuario";
    private static final String SQL_SEARCH = "SELECT id_usuario,nombre_usu,apellido1,apellido2,telefono,email,direccion FROM usuario WHERE id_usuario = ?";
    private static final String SQL_INSERT = "INSERT INTO usuario (nombre_usu,apellido1,apellido2,telefono,email,direccion) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre_usu = ?,apellido1 = ? ,apellido2 = ? ,telefono = ? ,email = ?,direccion = ? WHERE id_usuario = ?";

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
        Usuario usuario = null;
        try ( Connection con = getConection();  PreparedStatement st = con.prepareStatement(SQL_SEARCH);) {
            st.setLong(1, id);
            try ( ResultSet rs = st.executeQuery();) {
                if (rs.next()) {
                    usuario = crearUsuario(rs);
                }
            }
        } catch (SQLException ex) {
            System.out.println("error al listar usuario porID: " + ex.getMessage());
        }
        return usuario;
    }

    @Override
    public void guardar(Usuario t) {
        String SQL;
        if (t.getIdUsuario() != null && t.getIdUsuario() > 0) {
            SQL = SQL_UPDATE;
        } else {
            SQL = SQL_INSERT;
        }
        try ( Connection con = getConection();  PreparedStatement st = con.prepareStatement(SQL);) {
            st.setString(1, t.getNombre());
            st.setString(2, t.getApellido1());
            st.setString(3, t.getApellido2());
            st.setString(4, t.getTelefono());
            st.setString(5, t.getEmail());
            st.setString(6, t.getDireccion());

            if (t.getIdUsuario() != null && t.getIdUsuario() > 0) {
                st.setLong(7, t.getIdUsuario());
            }
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error al guardar o modificar usuario: " + ex.getMessage());
        }

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
