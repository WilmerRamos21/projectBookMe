package FormularioServicios;

import conexion.Conexion;

import java.sql.*;

public class serviciosCRUD {
    public void ingresarServicio( String nombreServicio, String descripcionServicio, float precioServicio) {

        String query = "INSERT INTO servicios ( nombre_servicio, descripcion, precio) VALUES(?,?,?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,nombreServicio);
            ps.setString(2,descripcionServicio);
            ps.setFloat(3,precioServicio);
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
