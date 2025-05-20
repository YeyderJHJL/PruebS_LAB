import unittest
from area_rectangulo import calcular_area

class TestAreaRectangulo(unittest.TestCase):

    # Casos positivos
    def test_enteros_como_texto(self):
        self.assertAlmostEqual(calcular_area("6", "4"), 24.0, places=3)

    def test_decimales_como_texto(self):
        self.assertAlmostEqual(calcular_area("2.5", "3.4"), 8.5, places=3)

    def test_entero_y_decimal(self):
        self.assertAlmostEqual(calcular_area("6", "2.5"), 15.0, places=3)

    def test_decimal_y_entero(self):
        self.assertAlmostEqual(calcular_area("2.5", "4"), 10.0, places=3)

    # Casos negativos
    def test_cero_y_entero(self):
        with self.assertRaises(ValueError):
            calcular_area("0", "5")

    def test_ambos_cero(self):
        with self.assertRaises(ValueError):
            calcular_area("0", "0")

    def test_ambos_negativos(self):
        with self.assertRaises(ValueError):
            calcular_area("-5", "-3")

    def test_base_no_numerica(self):
        with self.assertRaises(ValueError):
            calcular_area("hola", "5")

    def test_altura_no_numerica(self):
        with self.assertRaises(ValueError):
            calcular_area("5", "mundo")

    def test_ambos_no_numericos(self):
        with self.assertRaises(ValueError):
            calcular_area("x", "y")

    def test_base_positiva_altura_negativa(self):
        with self.assertRaises(ValueError):
            calcular_area("6", "-4")

    def test_base_negativa_altura_positiva(self):
        with self.assertRaises(ValueError):
            calcular_area("-4", "3")

if __name__ == "__main__":
    unittest.main()
