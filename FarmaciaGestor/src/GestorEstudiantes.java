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
            return "Nombre: " + nombre + ", Edad: " + edad + ", Nota Media: " + nota;
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
            System.out.println("3. Buscar estudiante por nombre");
            System.out.println("4. Salir");
            System.out.println("5. Calcular media de todas las notas");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> anadirEstudiante();
                case 2 -> listarEstudiantes();
                case 3 -> buscarPorNombre();
                case 4 -> System.out.println("Saliendo...");
                case 5 -> calcularMediaGeneral();
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }

    //añadir estudiante
    static void anadirEstudiante() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();

        System.out.print("Nota Media: ");
        double nota = sc.nextDouble();
        sc.nextLine();

        estudiantes[total] = new Estudiante(nombre, edad, nota);
        total++;
        System.out.println("Estudiante añadido correctamente.");
    }

    //Método para listar estudiantes
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

    static void buscarPorNombre() {
        System.out.print("Introduce el nombre: ");
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
    static void calcularMediaGeneral() {
        if (total == 0) {
            System.out.println("No hay estudiantes registrados todavía.");
            return;
        }

        double suma = 0;
        for (int i = 0; i < total; i++) {
            suma += estudiantes[i].nota;
        }
        double media = suma / total;
        System.out.println("La media general es: " + media);
    }

}
