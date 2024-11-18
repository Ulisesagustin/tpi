package Controller;

import JDBC.DBConfig;
import Model.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDAO {

    private static final String host = DBConfig.getHost();
    private static final String bd = DBConfig.getDatabase();
    private static final String user = DBConfig.getUser();
    private static final String password = DBConfig.getPassword();

    //Insertar un nuevo socio
    public void insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (id_cliente, Nombre, Apellido, Dirección, Teléfono) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cliente.getid_cliente());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getApellido());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.setLong(5, cliente.getTelefono());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obtener todos los socios
    public List<Cliente> obtenerCliente() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id_cliente, Nombre, Apellido, Dirección, Teléfono FROM clientes";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String direccion = rs.getString("Dirección");
                long telefono = rs.getLong("Teléfono");

                Cliente cliente = new Cliente(id_cliente, nombre, apellido, direccion, telefono);
                lista.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Actualizar un socio
    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET Nombre = ?, Apellido = ?, Dirección = ?, Teléfono = ? WHERE id_cliente = ?";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getDireccion());
            pstmt.setLong(4, cliente.getTelefono());
            pstmt.setInt(5, cliente.getid_cliente());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Eliminar un socio
    public void eliminarCliente(int id_cliente) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_cliente);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}