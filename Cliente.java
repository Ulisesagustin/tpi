package Model;

import java.sql.SQLException;
import java.util.Scanner;
import Controller.ClienteDAO;
import java.util.List;

public class Cliente {

    private int id_cliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private long telefono;

    private static final Scanner scanner = new Scanner(System.in);
    private static final ClienteDAO clienteDAO = new ClienteDAO();

    //Constructor
    public Cliente(int id_cliente, String nombre, String apellido, String direccion, long telefono) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Getters y Setters
    public int getid_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    // Crud
    public static void insertarCliente() {
        try {
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del cliente: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingrese la dirección del cliente: ");
            String direccion = scanner.nextLine();

            System.out.print("Ingrese el teléfono del cliente: ");
            long telefono = Long.parseLong(scanner.nextLine());

            Cliente cliente = new Cliente(0, nombre, apellido, direccion, telefono);
            clienteDAO.insertarCliente(cliente);

            System.out.println("Cliente insertado exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar un número válido para el teléfono.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void mostrarCliente() {
        try {
            List<Cliente> clientes = clienteDAO.obtenerCliente();
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes para mostrar.");
            } else {
                for (Cliente cliente : clientes) {
                    System.out.println("id_cliente: " + cliente.getid_cliente() + " - Nombre: " + cliente.getNombre() + " - Apellido: " + cliente.getApellido() + " - Dirección: " + cliente.getDireccion() + " - Teléfono: " + cliente.getTelefono());
                }
            }
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void actualizarCliente() {
        try {
            System.out.print("Ingrese el número del cliente a actualizar: ");
            int id_cliente = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del cliente: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingrese la dirección del cliente: ");
            String direccion = scanner.nextLine();

            System.out.print("Ingrese el teléfono del cliente: ");
            long telefono = Long.parseLong(scanner.nextLine());

            Cliente cliente = new Cliente(id_cliente, nombre, apellido, direccion, telefono);
            clienteDAO.actualizarCliente(cliente);

            System.out.println("Cliente actualizado exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar datos correctos.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void eliminarCliente() {
        try {
            System.out.print("Ingrese el número del cliente a eliminar: ");
            int id_cliente = Integer.parseInt(scanner.nextLine());

            clienteDAO.eliminarCliente(id_cliente);

            System.out.println("Cliente eliminado exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar un número válido.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

}