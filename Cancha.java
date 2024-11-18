package Model;

import Controller.CanchaDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Cancha {

    private int id_cancha;
    private String nombre;
    private double precioPorHora;

    private static final Scanner scanner = new Scanner(System.in);
    private static final CanchaDAO canchaDAO = new CanchaDAO();

    public Cancha(int id_cancha, String nombre, double precioPorHora) {
        this.id_cancha = id_cancha;
        this.nombre = nombre;
        this.precioPorHora = precioPorHora;
    }

    public int getId() {
        return id_cancha;
    }

    public void setId(int id_cancha) {
        this.id_cancha = id_cancha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double PrecioPorHora) {
        this.precioPorHora = PrecioPorHora;
    }

    // Crud
    public static void crearCancha() {
        try {
            System.out.print("Nombre de la cancha: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio por hora: ");
            double precio = Double.parseDouble(scanner.nextLine());

            Cancha nuevaCancha = new Cancha(0, nombre, precio);
            CanchaDAO.crearCancha(nuevaCancha);

            System.out.println("Cancha creada exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar un precio numérico.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void listarCancha() {
        try {
            List<Cancha> canchas = canchaDAO.listarCancha();
            if (canchas.isEmpty()) {
                System.out.println("No hay canchas para mostrar.");
            } else {
                for (Cancha cancha : canchas) {
                    System.out.println("ID: " + cancha.getId() + " - Nombre: " + cancha.getNombre() + " - Precio por hora: " + cancha.getPrecioPorHora());
                }
            }
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void actualizarCancha() {
        try {
            System.out.print("ID de la Cancha a actualizar: ");
            int idActualizar = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Nuevo Precio por hora: ");
            double precio = Double.parseDouble(scanner.nextLine());

            Cancha canchaActualizada = new Cancha(idActualizar, nombre, precio);
            canchaDAO.actualizarCancha(canchaActualizada);

            System.out.println("Cancha actualizada exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar un ID y un precio válidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void eliminarCancha() {
        try {
            System.out.print("ID de la Cancha a eliminar: ");
            int idEliminar = Integer.parseInt(scanner.nextLine());

            canchaDAO.eliminarCancha(idEliminar);
            System.out.println("Cancha eliminada exitosamente.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada inválida. Asegúrese de ingresar un ID válido.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

}