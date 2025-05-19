import unittest
from par_impar import identificar_pares_impares


class TestParImpar(unittest.TestCase):
    # Casos positivos
    def test_todos_pares_positivos(self):
        nums = [2, 4, 6]
        esperado = ["2 es par.", "4 es par.", "6 es par."]
        self.assertEqual(esperado, identificar_pares_impares(nums))
    
    def test_todos_impares_positivos(self):
        nums = [1, 3, 5]
        esperado = ["1 es impar.", "3 es impar.", "5 es impar."]
        self.assertEqual(esperado, identificar_pares_impares(nums))
    
    def test_mixtos_positivos(self):
        nums = [2, 3, 4]
        esperado = ["2 es par.", "3 es impar.", "4 es par."]
        self.assertEqual(esperado, identificar_pares_impares(nums))
    
    def test_todos_pares_negativos(self):
        nums = [-2, -4, -6]
        esperado = ["-2 es par.", "-4 es par.", "-6 es par."]
        self.assertEqual(esperado, identificar_pares_impares(nums))
    
    def test_todos_impares_negativos(self):
        nums = [-1, -3, -5]
        esperado = ["-1 es impar.", "-3 es impar.", "-5 es impar."]
        self.assertEqual(esperado, identificar_pares_impares(nums))
    
    def test_mixtos_negativos(self):
        nums = [-2, -3, -4, -5]
        esperado = ["-2 es par.", "-3 es impar.", "-4 es par.", "-5 es impar."]
        self.assertEqual(esperado, identificar_pares_impares(nums))
    
    def test_mixtos_positivos_y_negativos(self):
        nums = [-3, 0, 1, 2]
        esperado = ["-3 es impar.", "0 es par.", "1 es impar.", "2 es par."]
        self.assertEqual(esperado, identificar_pares_impares(nums))
    
    # Casos negativos/excepciones
    def test_lista_nula(self):
        with self.assertRaises(TypeError):
            identificar_pares_impares(None)
    
    def test_lista_vacia(self):
        self.assertEqual([], identificar_pares_impares([]))


if __name__ == "__main__":
    unittest.main()