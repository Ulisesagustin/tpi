package Main;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;
import static JDBC.BDConnection.ConectarBD;
import static JDBC.BDConnection.DesconectarBD;

public class Main {

    private static Connection bd = null;

    public static void main(String[] args){
        bd = ConectarBD();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una entidad para trabajar:");
            System.out.println("1. Canchas");
            System.out.println("2. Reservas");
            System.out.println("3. Pago");
            System.out.println("4. Cliente");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine();
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    MenuPrincipal.crudCancha();
                    break;
                case 2:
                    MenuPrincipal.crudReserva();
                    break;
                case 3:
                    MenuPrincipal.crudPago();
                    break;
                case 4:
                    MenuPrincipal.crudCliente();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    if (opcion != -1) {
                        System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    }
            }
        } while (opcion != 5);

        scanner.close();
        DesconectarBD(bd);
    }
}