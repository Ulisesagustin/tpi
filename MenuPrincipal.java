package Main;

import java.util.Scanner;
import static Model.Cancha.*;
//import static Model.Entrenador.*;
//import static Model.Maquina.*;
import static Model.Pago.*;
import static Model.Cliente.*;
import static Model.Reserva.*;

public class MenuPrincipal {

    private static final Scanner scanner = new Scanner(System.in);

    public static void crudCancha() {
        int opcion;
        do {
            System.out.println("Indique la operación que desea realizar:");
            System.out.println("1. Insertar una nueva cancha: ");
            System.out.println("2. Mostrar todas las canchas: ");
            System.out.println("3. Actualizar una cancha: ");
            System.out.println("4. Eliminar una cancha: ");
            System.out.println("5. Volver al menú principal");
            System.out.print("Opción N°: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearCancha();
                    break;
                case 2:
                    listarCancha();
                    break;
                case 3:
                    actualizarCancha();
                    break;
                case 4:
                    eliminarCancha();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 5);
    }

    public static void crudReserva() {
        int opcion;
        do {
            System.out.println("Indique la operación que desea realizar:");
            System.out.println("1. Insertar una nueva reserva");
            System.out.println("2. Mostrar todas las reservas");
            System.out.println("3. Actualizar una reserva");
            System.out.println("4. Eliminar una reserva");
            System.out.println("5. Volver al menú principal");
            System.out.print("Opción N°: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearReservas();
                    break;
                case 2:
                    listarReservas();
                    break;
                case 3:
                    actualizarReserva();
                    break;
                case 4:
                    eliminarReservas();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 5);
    }

    public static void crudPago() {
        int opcion;
        do {
            System.out.println("Indique la operación que desea realizar:");
            System.out.println("1. Insertar una nuevo pago: ");
            System.out.println("2. Mostrar todos los pagos: ");
            System.out.println("3. Actualizar un pago: ");
            System.out.println("4. Eliminar un pago: ");
            System.out.println("5. Volver al menú principal");
            System.out.print("Opción N°: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarPago();
                    break;
                case 2:
                    mostrarPagos();
                    break;
                case 3:
                    actualizarPago();
                    break;
                case 4:
                    eliminarPago();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 5);
    }

    public static void crudCliente() {
        int opcion;
        do {
            System.out.println("Indique la operación que desea realizar:");
            System.out.println("1. Insertar un nuevo cliente: ");
            System.out.println("2. Mostrar todos los clientes: ");
            System.out.println("3. Actualizar un cliente: ");
            System.out.println("4. Eliminar un cliente: ");
            System.out.println("5. Volver al menú principal: ");
            System.out.print("Opción N°: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarCliente();
                    break;
                case 2:
                    mostrarCliente();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }
}