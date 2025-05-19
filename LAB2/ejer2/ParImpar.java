
import java.util.ArrayList;
import java.util.Scanner;

public class ParImpar {

    public static ArrayList<String> identificarParesImpares(int[] numeros) {
        if (numeros == null)
            throw new NullPointerException("El arreglo no debe ser nulo.");

        ArrayList<String> resultados = new ArrayList<>();
        for (int num : numeros) {
            if (num % 2 == 0) {
                resultados.add(num + " es par.");
            } else {
                resultados.add(num + " es impar.");
            }
        }
        return resultados;
    }

    public static xvoid main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("¿Cuántos números deseas ingresar? ");
            String entradaCantidad = scanner.nextLine();

            // Validación de número entero positivo
            if (!entradaCantidad.matches("\\d+")) {
                System.out.println("La cantidad debe ser un número entero positivo.");
                return;
            }

            int cantidad = Integer.parseInt(entradaCantidad);

            if (cantidad < 0) {
                System.out.println("La cantidad no puede ser negativa.");
                return;
            }
            if (cantidad == 0) {
                System.out.println("No se ingresa ningún número (cantidad 0).");
                return;
            }

            int[] numeros = new int[cantidad];
            for (int i = 0; i < cantidad; i++) {
                while (true) {
                    try {
                        System.out.print("Ingrese el número " + (i + 1) + ": ");
                        String entrada = scanner.nextLine();

                        // Validar que sea número entero (positivo o negativo)
                        if (!entrada.matches("-?\\d+")) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                            continue;
                        }

                        numeros[i] = Integer.parseInt(entrada);
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    }
                }
            }

            ArrayList<String> resultados = identificarParesImpares(numeros);
            for (String resultado : resultados) {
                System.out.println(resultado);
            }

        } finally {
            scanner.close();
        }
    }
}
