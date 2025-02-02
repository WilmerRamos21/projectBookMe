package FormularioHorarios;

import conexion.Conexion;

import java.sql.*;

public class horariosCRUD {

    public void crearHorario(int cedulaEmpleado, String dia, String horaInicio, String horaFin, int idServicio) {
        String query = "INSERT INTO horarios (cedula_empleado, dia_semana, hora_inicio, hora_fin, servicio, estado) VALUES (?, ?, ?, ?, ?, 'activo')";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, cedulaEmpleado);
            ps.setString(2, dia);
            ps.setString(3, horaInicio);
            ps.setString(4, horaFin);
            ps.setInt(5,idServicio);
            ps.executeUpdate();
            System.out.println("Horario creado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void actualizarHorario(int cedulaEmpleado,String dia ,String HoraInicio, String HoraFin,int idServicio, String estado,int idHorario) {
        String query = "UPDATE horarios SET cedula_empleado=?, dia_semana=?, hora_inicio=?, hora_fin=? ,servicio = ?, estado = ? WHERE id_horario=?";
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, cedulaEmpleado);
            ps.setString(2, dia);
            ps.setString(3, HoraInicio);
            ps.setString(4, HoraFin);
            ps.setInt(5, idServicio);
            ps.setString(6, estado);
            ps.setInt(7, idHorario);

            ps.executeUpdate();
            System.out.println("Horario actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean eliminarHorario(int idHorario) {
        String query = "DELETE FROM horarios WHERE id_horario = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idHorario);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Horario eliminado correctamente");
                return true;
            } else {
                System.out.println("No se puede eliminar el Horario");
                return false;
            }
        } catch (SQLException e0) {
            e0.printStackTrace();
            return false;
        }
    }
}
