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
    }

    static Estudiante[] estudiantes = new Estudiante[100];
    static int total = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Gestor de Estudiantes ===");

        System.out.print("Introduce el nombre del estudiante: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce la edad: ");
        int edad = sc.nextInt();

        System.out.print("Introduce la nota: ");
        double nota = sc.nextDouble();

        estudiantes[total] = new Estudiante(nombre, edad, nota);
        total++;

        System.out.println("Estudiante añadido correctamente.");
    }
}
