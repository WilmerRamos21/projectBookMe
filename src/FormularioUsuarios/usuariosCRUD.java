package FormularioUsuarios;

import conexion.Conexion;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class usuariosCRUD {

    public void ingresarUsuarios( String nombreApellido,
                                 String email, String pass,
                                 String rol) {

        String query = "INSERT INTO usuarios (nombre_apellido, correo, contrasenia, rol) VALUES(?,?,?,?)";
        try (Connection con= Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,nombreApellido);
            ps.setString(2,email);
            ps.setString(3,pass);
            ps.setString(4,rol);
            ps.executeUpdate();
            System.out.println("Datos ingresados correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modificarUsuarios(String nombreApellido, String email, String pass,
                                  String rol,int id){
        String query = "UPDATE usuarios set nombre_apellido = ?, correo = ?, contrasenia = ?, rol = ? where id = ?";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
                ps.setString(1,nombreApellido);
                ps.setString(2,email);
                ps.setString(3,pass);
                ps.setString(4,rol);
                ps.setInt(5, id);
                ps.executeUpdate();
                System.out.println("Datos modificados correctamente");
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modificarUsuarioEmpleado(String nombreApellido, String email, String pass, int id){
        String query = "UPDATE usuarios set nombre_apellido = ?, correo = ?, contrasenia = ? where id = ?";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,nombreApellido);
            ps.setString(2,email);
            ps.setString(3,pass);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Datos modificados correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean eliminarUsuario(int id) {
        String query = "DELETE FROM usuarios where id = ?";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Datos eliminados correctamente");
                return true;
            } else{
                System.out.println("No se pudo eliminar el usuario");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existeCedula(int cedula) {
        String query = "SELECT COUNT(*) FROM usuarios WHERE cedula = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si la cédula ya existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }
    public boolean existeCorreo(String correo) {
        String query = "SELECT COUNT(*) FROM usuarios WHERE correo = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si el correo ya existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


