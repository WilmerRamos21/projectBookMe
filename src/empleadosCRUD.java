import java.sql.*;


public class empleadosCRUD {

    public void ingresarEmpleados(int idUsuario,String especialidad, String horarioTrabajo) {

        String query = "INSERT INTO empleados (id_usuario, especialidad, horario_trabajo) VALUES (?, ?, ?)";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
                ps.setInt(1, idUsuario);
                ps.setString(2, especialidad);
                ps.setString(3, String.valueOf(horarioTrabajo));
                ps.executeUpdate();
                System.out.println("Datos del empleado ingresados con exito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarEmpleados(int idUsuario) {
        String query = "DELETE FROM empleados WHERE id_usuario = ?";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
                ps.setInt(1, idUsuario);
                ps.executeUpdate();
                System.out.println("Datos eliminados exitosamente");
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrardatosEmpelados() {
        String query = "SELECT * FROM empleados";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID Empleado: " + rs.getInt("id_empleado"));
                System.out.println("ID Usuario: " + rs.getInt("id_usuario"));
                System.out.println("Especialidad: " + rs.getString("especialidad"));
                System.out.println("Horario Trabajo: " + rs.getString("horario_trabajo"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarDatosEmpelados(String especialidad, String horarioTrabajo,int idEmpleado) {
        String query = "UPDATE empleados set especialidad = ?, horario_trabajo = ? where id_empleado = ?";
        try (Connection con= Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, especialidad);
            ps.setString(2, String.valueOf(horarioTrabajo));
            ps.setInt(3,idEmpleado);
            ps.executeUpdate();
            System.out.println("Datos del empleado modificados con exito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

