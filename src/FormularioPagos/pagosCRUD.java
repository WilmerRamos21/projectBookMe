package FormularioPagos;
import Empleado.sesionCorreo;
import conexion.Conexion;

import java.sql.*;
import java.time.LocalDate;

public class pagosCRUD {
    public boolean ingresarPago(int idCliente, int idReserva, LocalDate fechaPago,
                             String metodoPago,String descripcion) {



        String queryPago = "INSERT INTO pagosRealizados ( id_cliente, id_reserva, fecha_pago, metodo_pago, descripcion)VALUES (?,?,?,?,?)";
        String queryActualizacionEstado = "UPDATE pagosRealizados SET estado_pago = 'Pagado' WHERE id_reserva = ?";
        Connection con = null;
        PreparedStatement psPago = null;
        PreparedStatement psActualizarEstado = null;
        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false);
            psPago = con.prepareStatement(queryPago);
            psPago.setInt(1, idCliente);
            psPago.setInt(2, idReserva);
            psPago.setDate(3, Date.valueOf(fechaPago));
            psPago.setString(4,metodoPago);
            psPago.setString(5,descripcion);
            psPago.executeUpdate();
            System.out.println("Pago insertado correctamente");

            psActualizarEstado = con.prepareStatement(queryActualizacionEstado);
            psActualizarEstado.setInt(1, idReserva);
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
                if (psPago != null) {
                    psPago.close();
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
    public void actualizarPago(int idCliente, int idReserva, LocalDate fechaPago,
                                String metodoPago,String estadoPago,String descripcion, int idPago){
        String query = "UPDATE pagosRealizados SET id_cliente = ?, id_reserva = ?, fecha_pago = ?, metodo_pago = ?," +
                " descripcion = ?, estado_pago = ? WHERE id_pago = ?";
        try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,idCliente);
            ps.setInt(2,idReserva);
            ps.setDate(3, Date.valueOf(fechaPago));
            ps.setString(4,metodoPago);
            ps.setString(5,estadoPago);
            ps.setString(6,descripcion);
            ps.setInt(7,idPago);
            ps.executeUpdate();
            System.out.println("Pago actualizado correctamente");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
