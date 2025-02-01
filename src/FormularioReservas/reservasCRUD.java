package FormularioReservas;

import conexion.Conexion;

import java.sql.*;
import java.time.LocalDate;

public class reservasCRUD {
    public void ingresarReserva(int idReserva,int cedulaCliente,int idServicio,int cedulaEmpleado,
                                LocalDate fechaReserva,String estadoReserva,float precio,String descripcion) {

        String query = "INSERT INTO reservas (id_reserva, cedula_cliente, id_servicio, cedula_encargado, fecha_reserva, estado_reserva, precio, observaciones)VALUES (?,?,?,?,?,?,?,?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,idReserva);
            ps.setInt(2,cedulaCliente);
            ps.setInt(3,idServicio);
            ps.setInt(4,cedulaEmpleado);
            ps.setDate(5, Date.valueOf(fechaReserva));
            ps.setString(6,estadoReserva);
            ps.setFloat(7,precio);
            ps.setString(8,descripcion);
            ps.executeUpdate();
            System.out.println("Reserva registrada correctamente");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean eliminarReserva(int idReserva){
        String query = "DELETE FROM reservas WHERE id_reserva = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,idReserva);
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
    public void actualizarReserva(int cedulaCliente,int idServicio,int cedulaEmpleado,
                                  LocalDate fechaReserva,String estadoReserva,float precio,String descripcion,int idReserva){
        String query = "UPDATE reservas SET cedula_cliente = ?, id_servicio = ?, cedula_encargado = ?," +
                " fecha_reserva = ?, estado_reserva = ?, precio = ?, observaciones = ? WHERE id_reserva = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,cedulaCliente);
            ps.setInt(2,idServicio);
            ps.setInt(3,cedulaEmpleado);
            ps.setDate(4, Date.valueOf(fechaReserva));
            ps.setString(5,estadoReserva);
            ps.setFloat(6,precio);
            ps.setString(7,descripcion);
            ps.setInt(8,idReserva);
            ps.executeUpdate();
            System.out.println("Pago actualizado correctamente");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
