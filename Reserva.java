package Model;


import Controller.ReservasDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Reserva {


    private int id_reserva;
    private int id_cliente;
    private int id_cancha;
    private int horas_alquiladas;
    private String fecha_reserva;


    private static final Scanner scanner = new Scanner(System.in);
    private static final ReservasDAO reservaDAO = new ReservasDAO();

    public Reserva(int id_reserva, int id_cliente , int id_cancha, int horas_alquiladas, String fecha_reserva) {
        this.id_reserva = id_reserva;
        this.id_cliente= id_cliente;
        this.id_cancha = id_cancha;
        this.horas_alquiladas = horas_alquiladas;
        this.fecha_reserva=fecha_reserva;
    }

    public int getId_reserva() {
        return id_reserva;

    }
    public int getId_cancha() {
        return id_cancha;
    }

    public int getId_cliente() {
        return id_cliente;
    }


    public int getHoras_alquiladas() {
        return horas_alquiladas;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }


    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_cancha(int id_cancha) {
        this.id_cancha = id_cancha;
    }

    public void setHoras_alquiladas(int horas_alquiladas) {
        this.horas_alquiladas = horas_alquiladas;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }



    // Crud
    public static void crearReservas() {
        try {
            System.out.print("Ingrese el Id Reserva: ");
            int id_reserva = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el Id Cliente: ");
            int id_cliente = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el Id Cancha: ");
            int id_cancha = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese minutos alquilados: ");
            int horas_alquiladas = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese fecha alquilada en formato aaaa-mm-dd: ");
            String fecha_reserva = scanner.nextLine();

            Reserva nuevaReservas = new Reserva(id_reserva, id_cliente, id_cancha, horas_alquiladas, fecha_reserva);
            ReservasDAO.crearReservas(nuevaReservas);

            System.out.println("Reservas creada exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar datos numéricos donde corresponda.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void listarReservas() {
        try {
            List<Reserva> reservas = reservaDAO.listarReservas();
            if (reservas.isEmpty()) {
                System.out.println("No hay reservas para mostrar.");
            } else {
                for (Reserva reserva : reservas) {
                    System.out.println("id_cancha: " + reserva.getId_cancha() + " - id_cliente: " + reserva.getId_cliente() +
                            " - fecha_reserva: " + reserva.getFecha_reserva() + " - horas_alquiladas: " + reserva.getHoras_alquiladas());
                }
            }
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void actualizarReserva() {
        try {
            System.out.print("ID de la Reservas a actualizar: ");
            int id_reserva = Integer.parseInt(scanner.nextLine());

            System.out.print("ID del cliente a actualizar: ");
            int id_cliente = Integer.parseInt(scanner.nextLine());

            System.out.print("ID de la cancha a actualizar: ");
            int id_cancha = Integer.parseInt(scanner.nextLine());

            System.out.print("Horas en minutos alquiladas: ");
            int horas_alquiladas = Integer.parseInt(scanner.nextLine());

            System.out.print("Fecha alquilada: ");
            String fecha_reserva = scanner.nextLine();

            Reserva ReservasActualizada = new Reserva(id_reserva, id_cliente, id_cancha, horas_alquiladas, fecha_reserva);
            ReservasDAO.actualizarReserva(ReservasActualizada);

            System.out.println("Reservas actualizada exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar datos numéricos donde corresponda.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void eliminarReservas() {
        try {
            System.out.print("ID de la Reservas a eliminar: ");
            int idEliminar = Integer.parseInt(scanner.nextLine());

            ReservasDAO.eliminarReservas(idEliminar);
            System.out.println("Reservas eliminada exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar un número válido.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

}