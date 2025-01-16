import java.sql.*;
import java.time.LocalDate;

public class usuariosCRUD {

    public void ingresarUsuarios(int cedula, String nombre,
                                 String apellido, String email, String telefono,
                                 String pass, String rol, LocalDate fecha) {

        String query = "INSERT INTO usuarios (cedula,nombre, apellido, correo, telefono, contrasenia, rol, fecha_registro) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con= Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, cedula);
            ps.setString(2,nombre);
            ps.setString(3,apellido);
            ps.setString(4,email);
            ps.setString(5,telefono);
            ps.setString(6,pass);
            ps.setString(7,rol);
            ps.setDate(8, Date.valueOf(fecha));
            ps.executeUpdate();
            System.out.println("Datos ingresados correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDatosusuarios(){
        String query = "SELECT * FROM usuarios";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Cedula: " + rs.getInt("cedula"));
                System.out.println("Nombre: "+rs.getString("nombre"));
                System.out.println("Apellido: "+rs.getString("apellido"));
                System.out.println("Correo electronico: "+rs.getString("correo"));
                System.out.println("Telefono: "+rs.getString("telefono"));
                System.out.println("Contraseña: "+rs.getString("contrasenia"));
                System.out.println("Rol: "+rs.getString("rol"));
                System.out.println("Fecha registro: "+rs.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void modificarUsuarios(String nombre,
                                  String apellido, String email, String telefono,
                                  String pass, String rol, LocalDate fecha,int cedula){
        String query = "UPDATE usuarios set nombre = ?, apellido = ?, correo = ?, telefono = ?, contrasenia = ?, rol = ?, fecha_registro = ? where cedula = ?";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
                ps.setString(1,nombre);
                ps.setString(2,apellido);
                ps.setString(3,email);
                ps.setString(4,telefono);
                ps.setString(5,pass);
                ps.setString(6,rol);
                ps.setDate(7, Date.valueOf(fecha));
                ps.setInt(8, cedula);
                ps.executeUpdate();
                System.out.println("Datos modificados correctamente");


    } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int cedula) {
        String query = "DELETE FROM usuarios where cedula = ?";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, cedula);
            ps.executeUpdate();
            System.out.println("Datos eliminados exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
