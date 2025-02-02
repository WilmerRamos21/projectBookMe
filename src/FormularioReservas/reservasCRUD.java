package FormularioReservas;

import conexion.Conexion;

import java.sql.*;
import java.time.LocalDate;

public class reservasCRUD {
    public boolean ingresarReserva(int idCliente,int idHorario,
                                LocalDate fechaReserva,String descripcion) {

        String query = "INSERT INTO reservas ( id_cliente, id_horario, fecha_reserva, observaciones)VALUES (?,?,?,?)";
        String queryActualizacionEstado = "UPDATE horarios SET estado = 'inactivo' WHERE id_horario = ?";
        Connection con = null;
        PreparedStatement psReserva = null;
        PreparedStatement psActualizarEstado = null;


        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false);
            psReserva = con.prepareStatement(query);
            psReserva.setInt(1, idCliente);
            psReserva.setInt(2, idHorario);
            psReserva.setDate(3, Date.valueOf(fechaReserva));
            psReserva.setString(4, descripcion);
            psReserva.executeUpdate();
            System.out.println("Reserva registrada correctamente");

            psActualizarEstado = con.prepareStatement(queryActualizacionEstado);
            psActualizarEstado.setInt(1, idHorario);
            psActualizarEstado.executeUpdate();
            con.commit();
            return true;//Confirma reserva

        } catch (SQLException e) {
            e.printStackTrace();
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
                if (psReserva != null) {
                    psReserva.close();
                }
                if (psActualizarEstado != null) {
                    psActualizarEstado.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException e0){
                e0.printStackTrace();
            }
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
    public void actualizarReserva(int idCliente,int idHorario,
                                  LocalDate fechaReserva,String estadoReserva,String descripcion,int idReserva){
        String query = "UPDATE reservas SET id_cliente = ?, id_horario = ?," +
                " fecha_reserva = ?, estado_reserva = ?, observaciones = ? WHERE id_reserva = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,idCliente);
            ps.setInt(2,idHorario);
            ps.setDate(3, Date.valueOf(fechaReserva));
            ps.setString(4,estadoReserva);
            ps.setString(5,descripcion);
            ps.setInt(6,idReserva);
            ps.executeUpdate();
            System.out.println("Pago actualizado correctamente");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
