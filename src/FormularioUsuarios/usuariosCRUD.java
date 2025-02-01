package FormularioUsuarios;

import conexion.Conexion;

import java.sql.*;
import java.time.LocalDate;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class usuariosCRUD {

    public void ingresarUsuarios(int cedula, String nombre,
                                 String apellido, String email, String pass,
                                 String telefono, String rol, LocalDate fecha) {

        String query = "INSERT INTO usuarios (cedula,nombre, apellido, correo, contrasenia, telefono, rol, fecha_registro) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con= Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, cedula);
            ps.setString(2,nombre);
            ps.setString(3,apellido);
            ps.setString(4,email);
            ps.setString(5,pass);
            ps.setString(6,telefono);
            ps.setString(7,rol);
            ps.setDate(8, Date.valueOf(fecha));
            ps.executeUpdate();
            System.out.println("Datos ingresados correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void modificarUsuarios(String nombre,
                                  String apellido, String email, String pass,
                                  String telefono, String rol, LocalDate fecha,int cedula){
        String query = "UPDATE usuarios set nombre = ?, apellido = ?, correo = ?, contrasenia = ?, telefono = ?, rol = ?, fecha_registro = ? where cedula = ?";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
                ps.setString(1,nombre);
                ps.setString(2,apellido);
                ps.setString(3,email);
                ps.setString(4,pass);
                ps.setString(5,telefono);
                ps.setString(6,rol);
                ps.setDate(7, Date.valueOf(fecha));
                ps.setInt(8, cedula);
                ps.executeUpdate();
                System.out.println("Datos modificados correctamente");


    } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean eliminarUsuario(int cedula) {
        String query = "DELETE FROM usuarios where cedula = ?";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, cedula);
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


