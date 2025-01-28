import java.sql.*;
import java.time.LocalDate;

public class serviciosCRUD {
    public void ingresarServicio(int idServicio, String nombreServicio, String descripcionServicio, float precioServicio) {

        String query = "INSERT INTO servicios (id_servicio, nombre_servicio, descripcion, precio) VALUES(?,?,?,?)";
        try (Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,idServicio);
            ps.setString(2,nombreServicio);
            ps.setString(3,descripcionServicio);
            ps.setFloat(4,precioServicio);
            ps.executeUpdate();
            System.out.println("Servicio insertado correctamente");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean eliminarServicio(int idServicio) {
        String query = "DELETE FROM servicios WHERE id_servicio = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,idServicio);
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Servicio eliminado correctamente");
                return true;
            } else {
                System.out.println("No se puede eliminar el servicio");
                return false;
            }
        }catch (SQLException e0){
            e0.printStackTrace();
            return false;
        }
    }
    public void modifcarServicio(String nombreServicio, String descripcionServicio, float precioServicio, int idServicio){
        String query = "UPDATE servicios SET nombre_servicio = ?, descripcion = ?, precio = ? WHERE id_servicio = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,nombreServicio);
            ps.setString(2,descripcionServicio);
            ps.setFloat(3,precioServicio);
            ps.setInt(4,idServicio);
            ps.executeUpdate();
            System.out.println("Servicio modificado correctamente");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
