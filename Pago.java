package Model;

import java.sql.SQLException;
import java.util.Scanner;
import Controller.PagoDAO;
import java.util.List;

public class Pago {

    private int id_pago;
    private int id_reserva;
    private int monto;
    private String fecha_pago;

    private static final Scanner scanner = new Scanner(System.in);
    private static final PagoDAO PAGO_DAO = new PagoDAO();

    //Constructor
    public Pago(int id_pago, int id_reserva, int monto, String fecha_pago) {
        this.id_pago = id_pago;
        this.id_reserva = id_reserva;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
    }

    //Getters y Setters
    public int getid_pago() {
        return id_pago;
    }

    public void setid_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }



    // Crud
    public static void insertarPago() {
        try {
            System.out.print("Ingrese la id del Pago: ");
            int id_pago = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese la ID de la reserva asociada: ");
            int id_reserva = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el monto total: ");
            int monto = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese la fecha del pago: ");
            String fecha_pago = scanner.nextLine();

            Pago pago = new Pago(0, id_reserva, monto, fecha_pago);
            PAGO_DAO.insertarPago(pago);
            System.out.println("Pago insertado exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar números donde corresponda.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void mostrarPagos() {
        try {
            List<Pago> pagos = PAGO_DAO.obtenerPagos();
            if (pagos.isEmpty()) {
                System.out.println("No hay pagos para mostrar.");
            } else {
                for (Pago pago : pagos) {
                    System.out.println("id_pago: " + pago.getid_pago() + " - id_reserva: " + pago.getId_reserva() +
                            " - Monto: " + pago.getMonto() + " - Fecha de Pago: " + pago.getFecha_pago());
                }
            }
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void actualizarPago() {
        try {
            System.out.print("Ingrese la id del pago a actualizar: ");
            int id_pago = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese la id de la reserva asociada: ");
            int id_reserva = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el nuevo monto total: ");
            int monto = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese la nueva fecha del pago: ");
            String fecha_pago = scanner.nextLine();

            Pago pago = new Pago(id_pago, id_reserva, monto, fecha_pago);
            PAGO_DAO.actualizarPago(pago);
            System.out.println("Pago actualizado exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar números donde corresponda.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void eliminarPago() {
        try {
            System.out.print("Ingrese el Id del pago a eliminar: ");
            int id_pago = Integer.parseInt(scanner.nextLine());

            PAGO_DAO.eliminarPago(id_pago);
            System.out.println("Pago eliminado exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar un número válido.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}