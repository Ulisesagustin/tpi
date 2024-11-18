package Controller;

import JDBC.DBConfig;
import Model.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservasDAO {

    private static final String host = DBConfig.getHost();
    private static final String bd = DBConfig.getDatabase();
    private static final String user = DBConfig.getUser();
    private static final String password = DBConfig.getPassword();

    //Crear una nueva reserva
    public static void crearReservas(Reserva reservas) {
        String sql = "INSERT INTO reservas (id_reserva, id_cliente, id_cancha, horas_alquiladas, fecha_reserva) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, reservas.getId_reserva());
            pstmt.setInt(2, reservas.getId_cancha());
            pstmt.setInt(3, reservas.getId_cliente());
            pstmt.setInt(4, reservas.getHoras_alquiladas());
            pstmt.setString(5, reservas.getFecha_reserva());


            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // listar reserva
    public List<Reserva> listarReservas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT id_reserva, id_cliente, id_cancha, horas_alquiladas, fecha_reserva FROM Reservas";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id_reserva = rs.getInt("id_reserva");
                int id_cliente = rs.getInt("id_cliente");
                int id_cancha = rs.getInt("id_cancha");
                int horas_alquiladas = rs.getInt("horas_alquiladas");
                String fecha_reserva = rs.getString("fecha_reserva");

                Reserva reserva = new Reserva(id_reserva, id_cliente, id_cancha, horas_alquiladas, fecha_reserva);
                lista.add(reserva);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    //Actualizar una reserva
        public static void actualizarReserva(Reserva reserva) {
            String sql = "UPDATE reservas SET id_cliente = ?, id_cancha = ? , horas_alquiladas = ?, fecha_reserva = ? WHERE id_reserva = ?";

            try (Connection conn = DriverManager.getConnection(host + bd, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {


                pstmt.setInt(1, reserva.getId_cliente());
                pstmt.setInt(2, reserva.getId_cancha());
                pstmt.setInt(3, reserva.getHoras_alquiladas());
                pstmt.setString(4, reserva.getFecha_reserva());
                pstmt.setInt(5, reserva.getId_reserva());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //Eliminar una cancha
        public static void eliminarReservas(int idEliminar) {
            String sql = "DELETE FROM reservas WHERE id_reserva = ?";

            try (Connection conn = DriverManager.getConnection(host + bd, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, idEliminar);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected == 0) {
                    System.out.print("no se pudo encontrar el Id \n");  // n con barra invertida---salto de linea
                } else {
                    System.out.println("Reservas eliminada exitosamente.\n");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }







}