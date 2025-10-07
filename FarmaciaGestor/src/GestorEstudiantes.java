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

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Edad: " + edad + ", Nota: " + nota;
        }
    }

    static final int MAX_ESTUDIANTES = 100;
    static Estudiante[] estudiantes = new Estudiante[MAX_ESTUDIANTES];
    static int total = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> anadirEstudiante();
                case 2 -> listarEstudiantes();
                case 3 -> buscarPorNombre();
                case 4 -> calcularMedia();
                case 5 -> mostrarMejorEstudiante();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 6);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("\n=== MENÚ DEL GESTOR DE ESTUDIANTES ===");
        System.out.println("1. Añadir un nuevo estudiante");
        System.out.println("2. Listar todos los estudiantes");
        System.out.println("3. Buscar un estudiante por su nombre");
        System.out.println("4. Calcular la media de todas las notas");
        System.out.println("5. Mostrar al estudiante con la mejor calificación");
        System.out.println("6. Salir");
    }

    static void anadirEstudiante() {
        if (total >= MAX_ESTUDIANTES) {
            System.out.println("No se pueden añadir más estudiantes.");
            return;
        }

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
        System.out.println("\n--- LISTA DE ESTUDIANTES ---");
        if (total == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + ". " + estudiantes[i]);
        }
    }

    static void buscarPorNombre() {
        System.out.print("Introduce el nombre a buscar: ");
        String nombre = sc.nextLine().toLowerCase();
        boolean encontrado = false;

        for (int i = 0; i < total; i++) {
            if (estudiantes[i].nombre.toLowerCase().contains(nombre)) {
                System.out.println("Encontrado: " + estudiantes[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún estudiante con ese nombre.");
        }
    }

    static void calcularMedia() {
        if (total == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        double suma = 0;
        for (int i = 0; i < total; i++) {
            suma += estudiantes[i].nota;
        }

        double media = suma / total;
        System.out.println("La media de todas las notas es: " + media);
    }

    static void mostrarMejorEstudiante() {
        if (total == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        Estudiante mejor = estudiantes[0];
        for (int i = 1; i < total; i++) {
            if (estudiantes[i].nota > mejor.nota) {
                mejor = estudiantes[i];
            }
        }

        System.out.println("El estudiante con la mejor calificación es:");
        System.out.println(mejor);
    }
}
