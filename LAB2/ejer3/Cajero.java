package ejer3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Cajero {
    private double saldo;
    
    public Cajero() {
        this.saldo = 1000; // Saldo por defecto
    }
    
    public Cajero(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public String consultarSaldo() {
        return "Saldo actual: S/." + this.saldo;
    }
    
    public String depositar(String montoStr) {
        try {
            double monto = Double.parseDouble(montoStr);
            if (monto > 0) {
                this.saldo += monto;
                return "Depósito exitoso.";
            } else {
                return "Monto inválido.";
            }
        } catch (NumberFormatException e) {
            return "Entrada inválida. Debe ingresar un número.";
        }
    }
    
    public String retirar(String montoStr) {
        try {
            double monto = Double.parseDouble(montoStr);
            if (monto > 0) {
                if (monto <= this.saldo) {
                    this.saldo -= monto;
                    return "Retiro exitoso.";
                } else {
                    return "Fondos insuficientes.";
                }
            } else {
                return "Monto inválido.";
            }
        } catch (NumberFormatException e) {
            return "Entrada inválida. Debe ingresar un número.";
        }
    }
    
    public String procesarOpcion(String opcion, Scanner sc) {
        switch (opcion) {
            case "1":
                return consultarSaldo();
            case "2":
                System.out.print("Ingrese el monto a depositar: ");
                String entradaDeposito = sc.nextLine();
                return depositar(entradaDeposito);
            case "3":
                System.out.print("Ingrese el monto a retirar: ");
                String entradaRetiro = sc.nextLine();
                return retirar(entradaRetiro);
            case "4":
                return "Saliendo del sistema...";
            default:
                return "Opción inválida. Intente nuevamente.";
        }
    }
    
    public boolean deberiaTerminar(String opcion) {
        return "4".equals(opcion);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cajero cajero = new Cajero();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Cajero Automático ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = sc.nextLine();
            
            String resultado = cajero.procesarOpcion(opcion, sc);
            System.out.println(resultado);
            
            if (cajero.deberiaTerminar(opcion)) {
                continuar = false;
            }
        }

        sc.close();
    }
    
    // Método para testing que simula la ejecución completa con entrada simulada
    public String ejecutarConEntrada(String input) {
        // Guardar los stream originales
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        
        try {
            // Configurar entrada simulada
            ByteArrayInputStream inStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inStream);
            
            // Configurar captura de salida
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outStream);
            System.setOut(printStream);
            
            // Ejecutar con un Scanner que use la entrada simulada
            Scanner sc = new Scanner(System.in);
            boolean continuar = true;
            
            while (continuar) {
                System.out.println("\n--- Cajero Automático ---");
                System.out.println("1. Consultar Saldo");
                System.out.println("2. Depositar Dinero");
                System.out.println("3. Retirar Dinero");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                
                if (!sc.hasNextLine()) {
                    break;
                }
                
                String opcion = sc.nextLine();
                String resultado = procesarOpcion(opcion, sc);
                System.out.println(resultado);
                
                if (deberiaTerminar(opcion)) {
                    continuar = false;
                }
            }
            
            sc.close();
            return outStream.toString();
            
        } finally {
            // Restaurar streams originales
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}