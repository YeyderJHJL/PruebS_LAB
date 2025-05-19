package ejer3;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CajeroTest {
    
    private Cajero cajero;
    
    @Before
    public void setUp() {
        cajero = new Cajero(1000); // Iniciar con 1000 de saldo para cada prueba
    }
    
    // CP01: Consultar saldo
    @Test
    public void testConsultarSaldo() {
        assertEquals("Saldo actual: S/.1000.0", cajero.consultarSaldo());
    }
    
    // CP02: Depositar monto positivo
    @Test
    public void testDepositarMontoPositivo() {
        String resultado = cajero.depositar("500");
        assertEquals("Depósito exitoso.", resultado);
        assertEquals(1500.0, cajero.getSaldo(), 0.001); // Verificar que el saldo se actualizó
    }
    
    // CP03: Retirar monto positivo válido
    @Test
    public void testRetirarMontoPositivoValido() {
        String resultado = cajero.retirar("300");
        assertEquals("Retiro exitoso.", resultado);
        assertEquals(700.0, cajero.getSaldo(), 0.001); // Verificar que el saldo se actualizó
    }
    
    // CP04: Salida del programa
    @Test
    public void testSalidaDelPrograma() {
        // Comprobar que la opción 4 devuelve el mensaje correcto
        String resultado = cajero.procesarOpcion("4", new Scanner(""));
        assertEquals("Saliendo del sistema...", resultado);
        
        // Comprobar que deberiaTerminar devuelve true para opción 4
        assertTrue(cajero.deberiaTerminar("4"));
    }
    
    // CP05: Depositar monto negativo
    @Test
    public void testDepositarMontoNegativo() {
        String resultado = cajero.depositar("-100");
        assertEquals("Monto inválido.", resultado);
        assertEquals(1000.0, cajero.getSaldo(), 0.001); // Verificar que el saldo no cambió
    }
    
    // CP06: Retirar monto negativo
    @Test
    public void testRetirarMontoNegativo() {
        String resultado = cajero.retirar("-200");
        assertEquals("Monto inválido.", resultado);
        assertEquals(1000.0, cajero.getSaldo(), 0.001); // Verificar que el saldo no cambió
    }
    
    // CP07: Opción fuera de rango
    @Test
    public void testOpcionFueraDeRango() {
        // Opción 5
        String resultado1 = cajero.procesarOpcion("5", new Scanner(""));
        assertEquals("Opción inválida. Intente nuevamente.", resultado1);
        
        // Opción 99
        String resultado2 = cajero.procesarOpcion("99", new Scanner(""));
        assertEquals("Opción inválida. Intente nuevamente.", resultado2);
    }
    
    // CP08: Opción no numérica
    @Test
    public void testOpcionNoNumerica() {
        String resultado = cajero.procesarOpcion("a", new Scanner(""));
        assertEquals("Opción inválida. Intente nuevamente.", resultado);
    }
    
    // CP09: Depositar texto
    @Test
    public void testDepositarTexto() {
        // Simular entrada con texto
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Scanner mockScanner = new Scanner("hola");
        String resultado = cajero.procesarOpcion("2", mockScanner);
        
        assertEquals("Entrada inválida. Debe ingresar un número.", resultado);
        assertEquals(1000.0, cajero.getSaldo(), 0.001); // Saldo sin cambios
    }
    
    // CP10: Retirar texto
    @Test
    public void testRetirarTexto() {
        // Simular entrada con texto
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Scanner mockScanner = new Scanner("peru");
        String resultado = cajero.procesarOpcion("3", mockScanner);
        
        assertEquals("Entrada inválida. Debe ingresar un número.", resultado);
        assertEquals(1000.0, cajero.getSaldo(), 0.001); // Saldo sin cambios
    }
    
    // CP11: Retiro mayor al saldo
    @Test
    public void testRetiroMayorAlSaldo() {
        cajero = new Cajero(500); // Iniciar con saldo de 500
        String resultado = cajero.retirar("1000");
        assertEquals("Fondos insuficientes.", resultado);
        assertEquals(500.0, cajero.getSaldo(), 0.001); // Saldo sin cambios
    }
    
    // Prueba adicional: Depositar cero
    @Test
    public void testDepositarCero() {
        String resultado = cajero.depositar("0");
        assertEquals("Monto inválido.", resultado);
        assertEquals(1000.0, cajero.getSaldo(), 0.001); // Saldo sin cambios
    }
    
    // Prueba adicional: Retirar cero
    @Test
    public void testRetirarCero() {
        String resultado = cajero.retirar("0");
        assertEquals("Monto inválido.", resultado);
        assertEquals(1000.0, cajero.getSaldo(), 0.001); // Saldo sin cambios
    }
    
    // Prueba adicional: Retirar exactamente el saldo
    @Test
    public void testRetirarExactamenteElSaldo() {
        String resultado = cajero.retirar("1000");
        assertEquals("Retiro exitoso.", resultado);
        assertEquals(0.0, cajero.getSaldo(), 0.001); // Saldo debe ser cero
    }
    
    // Prueba adicional: Depositar y luego retirar
    @Test
    public void testDepositarYLuegoRetirar() {
        cajero.depositar("500"); // Depositar primero
        assertEquals(1500.0, cajero.getSaldo(), 0.001);
        
        String resultado = cajero.retirar("200"); // Luego retirar
        assertEquals("Retiro exitoso.", resultado);
        assertEquals(1300.0, cajero.getSaldo(), 0.001);
    }
    
    // Prueba adicional: Flujo completo con operaciones múltiples
    @Test
    public void testFlujoCompleto() {
        // Consultar saldo inicial
        assertEquals("Saldo actual: S/.1000.0", cajero.consultarSaldo());
        
        // Depositar
        assertEquals("Depósito exitoso.", cajero.depositar("500"));
        assertEquals(1500.0, cajero.getSaldo(), 0.001);
        
        // Consultar saldo después del depósito
        assertEquals("Saldo actual: S/.1500.0", cajero.consultarSaldo());
        
        // Retirar
        assertEquals("Retiro exitoso.", cajero.retirar("300"));
        assertEquals(1200.0, cajero.getSaldo(), 0.001);
        
        // Consultar saldo final
        assertEquals("Saldo actual: S/.1200.0", cajero.consultarSaldo());
    }
}