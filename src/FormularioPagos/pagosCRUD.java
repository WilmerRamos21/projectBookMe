package FormularioPagos;
import conexion.Conexion;

import java.sql.*;
import java.time.LocalDate;

public class pagosCRUD {
    public void ingresarPago(int idPago,int cedulaCliente, int idServicio, float montoPago, LocalDate fechaPago,
                             String metodoPago, String estadoPago,String descripcion) {

        String query = "INSERT INTO pagosRealizados (id_pago, cedula_cliente, id_servicio, monto, fecha_pago, metodo_pago, estado_pago, descripcion)VALUES (?,?,?,?,?,?,?,?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,idPago);
            ps.setInt(2,cedulaCliente);
            ps.setInt(3,idServicio);
            ps.setFloat(4,montoPago);
            ps.setDate(5, Date.valueOf(fechaPago));
            ps.setString(6,metodoPago);
            ps.setString(7,estadoPago);
            ps.setString(8,descripcion);
            ps.executeUpdate();
            System.out.println("Pago insertado correctamente");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean eliminarPago(int idPago) {
        String query = "DELETE FROM pagosRealizados WHERE id_pago = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,idPago);
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Pago eliminado correctamente");
                return true;
            } else {
                System.out.println("No se puede eliminar el pago");
                return false;
            }
        }catch (SQLException e0){
            e0.printStackTrace();
            return false;
        }
    }
    public void actualizarPago(int cedulaCliente, int idServicio, float montoPago, LocalDate fechaPago,
                                String metodoPago, String estadoPago,String descripcion, int idPago){
        String query = "UPDATE pagosRealizados SET cedula_cliente = ?, id_servicio = ?, monto = ?, fecha_pago = ?, metodo_pago = ?, estado_pago = ?," +
                " descripcion = ? WHERE id_pago = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,cedulaCliente);
            ps.setInt(2,idServicio);
            ps.setFloat(3,montoPago);
            ps.setDate(4, Date.valueOf(fechaPago));
            ps.setString(5,metodoPago);
            ps.setString(6,estadoPago);
            ps.setString(7,descripcion);
            ps.setInt(8,idPago);
            ps.executeUpdate();
            System.out.println("Pago actualizado correctamente");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
