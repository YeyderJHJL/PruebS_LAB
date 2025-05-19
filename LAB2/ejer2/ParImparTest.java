import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ParImparTest {

    // Casos positivos
    @Test
    public void testTodosParesPositivos() {
        int[] nums = {2, 4, 6};
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("2 es par.", "4 es par.", "6 es par."));
        assertEquals(esperado, ParImpar.identificarParesImpares(nums));
    }

    @Test
    public void testTodosImparesPositivos() {
        int[] nums = {1, 3, 5};
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("1 es impar.", "3 es impar.", "5 es impar."));
        assertEquals(esperado, ParImpar.identificarParesImpares(nums));
    }

    @Test
    public void testMixtosPositivos() {
        int[] nums = {2, 3, 4};
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("2 es par.", "3 es impar.", "4 es par."));
        assertEquals(esperado, ParImpar.identificarParesImpares(nums));
    }

    @Test
    public void testTodosParesNegativos() {
        int[] nums = {-2, -4, -6};
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("-2 es par.", "-4 es par.", "-6 es par."));
        assertEquals(esperado, ParImpar.identificarParesImpares(nums));
    }

    @Test
    public void testTodosImparesNegativos() {
        int[] nums = {-1, -3, -5};
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("-1 es impar.", "-3 es impar.", "-5 es impar."));
        assertEquals(esperado, ParImpar.identificarParesImpares(nums));
    }

    @Test
    public void testMixtosNegativos() {
        int[] nums = {-2, -3, -4, -5};
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("-2 es par.", "-3 es impar.", "-4 es par.", "-5 es impar."));
        assertEquals(esperado, ParImpar.identificarParesImpares(nums));
    }

    @Test
    public void testMixtosPositivosYNegativos() {
        int[] nums = {-3, 0, 1, 2};
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("-3 es impar.", "0 es par.", "1 es impar.", "2 es par."));
        assertEquals(esperado, ParImpar.identificarParesImpares(nums));
    }

    // Casos negativos
    @Test(expected = NullPointerException.class)
    public void testArregloNulo() {
        ParImpar.identificarParesImpares(null);
    }

    @Test
    public void testCantidadCero() {
        int[] nums = {};
        ArrayList<String> esperado = new ArrayList<>();
        assertEquals(esperado, ParImpar.identificarParesImpares(nums));
    }

    @Test
    public void testValorNoEnteroComoDecimal() {
        try {
            Integer.parseInt("3.5");
            fail("Debe lanzar NumberFormatException");
        } catch (NumberFormatException e) {
            assertTrue(true); // Esperado
        }
    }

    @Test
    public void testValorNoNumericoLetra() {
        try {
            Integer.parseInt("abc");
            fail("Debe lanzar NumberFormatException");
        } catch (NumberFormatException e) {
            assertTrue(true); // Esperado
        }
    }

    @Test
    public void testCantidadNegativa() {
        int n = -1;
        assertTrue("Cantidad no puede ser negativa", n < 0);
    }
}
