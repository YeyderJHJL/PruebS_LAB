import unittest
from unittest.mock import patch
from cajero import Cajero


class CajeroTest(unittest.TestCase):
    def setUp(self):
        self.cajero = Cajero(1000)
    
    def test_consultar_saldo(self):
        resultado = self.cajero.consultar_saldo()
        self.assertEqual("Saldo actual: S/.1000", resultado)
        self.assertEqual(1000, self.cajero.get_saldo())
    
    def test_depositar_monto_positivo(self):
        resultado = self.cajero.depositar("500")
        self.assertEqual("Depósito exitoso.", resultado)
        self.assertEqual(1500, self.cajero.get_saldo())
    
    def test_retirar_monto_positivo_valido(self):
        resultado = self.cajero.retirar("300")
        self.assertEqual("Retiro exitoso.", resultado)
        self.assertEqual(700, self.cajero.get_saldo())
    
    def test_salida_del_programa(self):
        resultado = self.cajero.procesar_opcion("4", lambda x: None)
        self.assertEqual("Saliendo del sistema...", resultado)
        self.assertTrue(self.cajero.deberia_terminar("4"))
    
    def test_depositar_monto_negativo(self):
        resultado = self.cajero.depositar("-100")
        self.assertEqual("Monto inválido.", resultado)
        self.assertEqual(1000, self.cajero.get_saldo())
    
    def test_retirar_monto_negativo(self):
        resultado = self.cajero.retirar("-200")
        self.assertEqual("Monto inválido.", resultado)
        self.assertEqual(1000, self.cajero.get_saldo())
    
    def test_opcion_fuera_de_rango(self):
        resultado1 = self.cajero.procesar_opcion("5", lambda x: None)
        self.assertEqual("Opción inválida. Intente nuevamente.", resultado1)
        resultado2 = self.cajero.procesar_opcion("99", lambda x: None)
        self.assertEqual("Opción inválida. Intente nuevamente.", resultado2)
    
    def test_opcion_no_numerica(self):
        resultado = self.cajero.procesar_opcion("a", lambda x: None)
        self.assertEqual("Opción inválida. Intente nuevamente.", resultado)
    
    def test_depositar_texto(self):
        with patch('builtins.input', return_value="hola"):
            resultado = self.cajero.depositar("hola")
            self.assertEqual("Entrada inválida. Debe ingresar un número.", resultado)
            self.assertEqual(1000, self.cajero.get_saldo())
    
    def test_retirar_texto(self):
        with patch('builtins.input', return_value="peru"):
            resultado = self.cajero.retirar("peru")
            self.assertEqual("Entrada inválida. Debe ingresar un número.", resultado)
            self.assertEqual(1000, self.cajero.get_saldo())
    
    def test_retiro_mayor_al_saldo(self):
        self.cajero = Cajero(500)
        resultado = self.cajero.retirar("1000")
        self.assertEqual("Fondos insuficientes.", resultado)
        self.assertEqual(500, self.cajero.get_saldo())
    
    def test_depositar_cero(self):
        resultado = self.cajero.depositar("0")
        self.assertEqual("Monto inválido.", resultado)
        self.assertEqual(1000, self.cajero.get_saldo())
    
    def test_retirar_cero(self):
        resultado = self.cajero.retirar("0")
        self.assertEqual("Monto inválido.", resultado)
        self.assertEqual(1000, self.cajero.get_saldo())
    
    def test_retirar_exactamente_el_saldo(self):
        resultado = self.cajero.retirar("1000")
        self.assertEqual("Retiro exitoso.", resultado)
        self.assertEqual(0, self.cajero.get_saldo())
    
    def test_depositar_y_luego_retirar(self):
        self.cajero.depositar("500")  
        self.assertEqual(1500, self.cajero.get_saldo())
        resultado = self.cajero.retirar("200")
        self.assertEqual("Retiro exitoso.", resultado)
        self.assertEqual(1300, self.cajero.get_saldo())
    
    def test_flujo_completo(self):
        self.assertEqual("Saldo actual: S/.1000", self.cajero.consultar_saldo())
        self.assertEqual("Depósito exitoso.", self.cajero.depositar("500"))
        self.assertEqual(1500, self.cajero.get_saldo())
        self.assertEqual("Saldo actual: S/.1500", self.cajero.consultar_saldo())
        self.assertEqual("Retiro exitoso.", self.cajero.retirar("300"))
        self.assertEqual(1200, self.cajero.get_saldo())
        self.assertEqual("Saldo actual: S/.1200", self.cajero.consultar_saldo())
    
    def test_procesar_opcion_con_input_simulado(self):
        def mock_input_deposito(prompt):
            return "250"
        resultado = self.cajero.procesar_opcion("2", mock_input_deposito)
        self.assertEqual("Depósito exitoso.", resultado)
        self.assertEqual(1250, self.cajero.get_saldo())
        
        def mock_input_retiro(prompt):
            return "100"
        resultado = self.cajero.procesar_opcion("3", mock_input_retiro)
        self.assertEqual("Retiro exitoso.", resultado)
        self.assertEqual(1150, self.cajero.get_saldo())
        
        def mock_input_invalido(prompt):
            return "texto_invalido"
        resultado = self.cajero.procesar_opcion("2", mock_input_invalido)
        self.assertEqual("Entrada inválida. Debe ingresar un número.", resultado)


if __name__ == "__main__":
    unittest.main()