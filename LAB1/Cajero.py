def cajero_v3():
    saldo = 1000
    while True:
        print("\n--- Cajero Automático ---")
        print("1. Consultar Saldo")
        print("2. Depositar Dinero")
        print("3. Retirar Dinero")
        print("4. Salir")
        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            print(f"Saldo actual: S/.{saldo}")
        elif opcion == "2":
            try:
                monto = float(input("Ingrese el monto a depositar: "))
                if monto > 0:
                    saldo += monto
                    print("Depósito exitoso.")
                else:
                    print("Monto inválido.")
            except ValueError:
                print("Entrada inválida. Debe ingresar un número.")
        elif opcion == "3":
            try:
                monto = float(input("Ingrese el monto a retirar: "))
                if monto > 0:
                    if monto <= saldo:
                        saldo -= monto
                        print("Retiro exitoso.")
                    else:
                        print("Fondos insuficientes.")
                else:
                    print("Monto inválido.")
            except ValueError:
                print("Entrada inválida. Debe ingresar un número.")
        elif opcion == "4":
            print("Saliendo del sistema...")
            break
        else:
            print("Opción inválida. Intente nuevamente.")

if __name__ == "__main__":
    cajero_v3()