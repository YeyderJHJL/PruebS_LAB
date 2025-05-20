import java.util.Scanner;

public class AreaRectangulo {

    public static double calcularArea(String baseTexto, String alturaTexto) {
        try {
            double base = Double.parseDouble(baseTexto);
            double altura = Double.parseDouble(alturaTexto);

            if (base <= 0 || altura <= 0) {
                throw new IllegalArgumentException("Error: La base y la altura deben ser mayores que cero.");
            }

            return base * altura;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Debe ingresar valores numéricos válidos.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la base del rectángulo: ");
        String base = scanner.nextLine();

        System.out.print("Ingrese la altura del rectángulo: ");
        String altura = scanner.nextLine();

        try {
            double area = calcularArea(base, altura);
            System.out.println("Base: " + base + ", Altura: " + altura + ", Área: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
