package Controller;

import JDBC.DBConfig;
import Model.Pago;
import java.sql.*;
import java.util.*;

public class PagoDAO {

    private static final String host = DBConfig.getHost();
    private static final String bd = DBConfig.getDatabase();
    private static final String user = DBConfig.getUser();
    private static final String password = DBConfig.getPassword();

    //Insertar una nuevo pago
    public void insertarPago(Pago pago) {
        String sql = "INSERT INTO pagos (id_pago, id_reserva, monto, fecha_pago) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, pago.getid_pago());
            pstmt.setInt(2, pago.getId_reserva());
            pstmt.setInt(3, pago.getMonto());
            pstmt.setString(4, pago.getFecha_pago());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obtener todos los pagos
    public List<Pago> obtenerPagos() {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT id_pago, id_reserva, monto, fecha_pago FROM pagos";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id_pago = rs.getInt("id_pago");
                int id_reserva = rs.getInt("id_reserva");
                int monto = rs.getInt("monto");
                String fecha_pago = rs.getString("fecha_pago");

                Pago pago = new Pago(id_pago, id_reserva, monto, fecha_pago);
                lista.add(pago);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Actualizar un pago
    public void actualizarPago(Pago pago) {
        String sql = "UPDATE pagos SET Fecha_pago = ?, monto = ?, id_reserva = ? WHERE id_pago = ?";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pago.getFecha_pago());
            pstmt.setInt(2, pago.getMonto());
            pstmt.setInt(3, pago.getId_reserva());
            pstmt.setInt(4, pago.getid_pago());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Eliminar un pago
    public void eliminarPago(int id_pago) {
        String sql = "DELETE FROM pagos WHERE id_pago = ?";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_pago);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.print("no se pudo encontrar el Id \n");  // n con barra invertida---salto de linea
            } else {
                System.out.println("Pago eliminado exitosamente.\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}