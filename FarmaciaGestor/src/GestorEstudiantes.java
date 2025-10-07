import java.util.Scanner;

public class GestorEstudiantes {

    static class Estudiante {
        String nombre;
        int edad;
        double nota;

        Estudiante(String nombre, int edad, double nota) {
            this.nombre = nombre;
            this.edad = edad;
            this.nota = nota;
        }

        public String toString() {
            return "Nombre: " + nombre + ", Edad: " + edad + ", Nota: " + nota;
        }
    }

    static Estudiante[] estudiantes = new Estudiante[100];
    static int total = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== Menú ===");
            System.out.println("1. Añadir estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> anadirEstudiante();
                case 2 -> listarEstudiantes();
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 3);
    }

    static void anadirEstudiante() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        System.out.print("Nota: ");
        double nota = sc.nextDouble();
        sc.nextLine();

        estudiantes[total] = new Estudiante(nombre, edad, nota);
        total++;
        System.out.println("Estudiante añadido correctamente.");
    }

    static void listarEstudiantes() {
        System.out.println("\n--- Lista de estudiantes ---");
        if (total == 0) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (int i = 0; i < total; i++) {
                System.out.println((i + 1) + ". " + estudiantes[i]);
            }
        }
    }
}
