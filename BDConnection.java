package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {

    public static Connection ConectarBD() {
        Connection connection;

        try {
            String host = DBConfig.getHost();
            String bd = DBConfig.getDatabase();
            String user = DBConfig.getUser();
            String password = DBConfig.getPassword();

            //URL de la base de datos
            String url = host + bd;

            //Conexión con la base de datos
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado exitosamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void DesconectarBD(Connection bd) {
        try {
            if (bd != null && !bd.isClosed()) {
                bd.close();
                System.out.println("Desconectado exitosamente");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}