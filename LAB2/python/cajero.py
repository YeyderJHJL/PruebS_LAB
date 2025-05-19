class Cajero:
    def __init__(self, saldo_inicial=1000):
        self.saldo = float(saldo_inicial)
        
    def get_saldo(self):
        return self.saldo
    
    def consultar_saldo(self):
        return f"Saldo actual: S/.{int(self.saldo) if self.saldo.is_integer() else self.saldo}"
    
    def depositar(self, monto_str):
        try:
            monto = float(monto_str)
            if monto > 0:
                self.saldo += monto
                return "Depósito exitoso."
            return "Monto inválido."
        except ValueError:
            return "Entrada inválida. Debe ingresar un número."
    
    def retirar(self, monto_str):
        try:
            monto = float(monto_str)
            if monto > 0:
                if monto <= self.saldo:
                    self.saldo -= monto
                    return "Retiro exitoso."
                return "Fondos insuficientes."
            return "Monto inválido."
        except ValueError:
            return "Entrada inválida. Debe ingresar un número."
    
    def procesar_opcion(self, opcion, input_func=input):
        if opcion == "1":
            return self.consultar_saldo()
        elif opcion == "2":
            entrada_deposito = input_func("Ingrese el monto a depositar: ")
            return self.depositar(entrada_deposito)
        elif opcion == "3":
            entrada_retiro = input_func("Ingrese el monto a retirar: ")
            return self.retirar(entrada_retiro)
        elif opcion == "4":
            return "Saliendo del sistema..."
        return "Opción inválida. Intente nuevamente."
    
    def deberia_terminar(self, opcion):
        return opcion == "4"


def ejecutar_cajero():
    cajero = Cajero()
    continuar = True
    
    while continuar:
        print("\n--- Cajero Automático ---")
        print("1. Consultar Saldo")
        print("2. Depositar Dinero")
        print("3. Retirar Dinero")
        print("4. Salir")
        opcion = input("Seleccione una opción: ")
        
        resultado = cajero.procesar_opcion(opcion)
        print(resultado)
        
        if cajero.deberia_terminar(opcion):
            continuar = False


if __name__ == "__main__":
    ejecutar_cajero()