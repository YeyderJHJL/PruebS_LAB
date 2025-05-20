import static org.junit.Assert.*;
import org.junit.Test;

public class AreaRectanguloTest {

    // Casos positivos
    @Test
    public void testEnterosComoTexto() {
        assertEquals(24.0, AreaRectangulo.calcularArea("6", "4"), 0.001);
    }

    @Test
    public void testDecimalesComoTexto() {
        assertEquals(8.5, AreaRectangulo.calcularArea("2.5", "3.4"), 0.001);
    }

    @Test
    public void testEnteroYDecimal() {
        assertEquals(15.0, AreaRectangulo.calcularArea("6", "2.5"), 0.001);
    }

    @Test
    public void testDecimalYEntero() {
        assertEquals(10.0, AreaRectangulo.calcularArea("2.5", "4"), 0.001);
    }

    // Casos negativos
    @Test(expected = IllegalArgumentException.class)
    public void testCeroYEntero() {
        AreaRectangulo.calcularArea("0", "5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAmbosCero() {
        AreaRectangulo.calcularArea("0", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAmbosNegativos() {
        AreaRectangulo.calcularArea("-5", "-3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBaseNoNumerica() {
        AreaRectangulo.calcularArea("hola", "5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAlturaNoNumerica() {
        AreaRectangulo.calcularArea("5", "mundo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAmbosNoNumericos() {
        AreaRectangulo.calcularArea("x", "y");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBasePositivaAlturaNegativa() {
        AreaRectangulo.calcularArea("6", "-4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBaseNegativaAlturaPositiva() {
        AreaRectangulo.calcularArea("-4", "3");
    }

}
