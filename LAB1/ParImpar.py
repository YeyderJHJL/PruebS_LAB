def identificar_pares_impares_v3():
    try:
        cantidad = int(input("¿Cuántos números deseas ingresar? "))
        if cantidad < 0:
            print("La cantidad no puede ser negativa.")
            return

        numeros = []
        for i in range(cantidad):
            while True:
                try:
                    num = int(input(f"Ingrese el número {i+1}: "))
                    numeros.append(num)
                    break
                except ValueError:
                    print("Entrada inválida. Por favor, ingrese un número entero.")

        for num in numeros:
            if num % 2 == 0:
                print(f"{num} es par.")
            else:
                print(f"{num} es impar.")

    except ValueError:
        print("Entrada inválida para la cantidad de números.")


if __name__ == "__main__":
    identificar_pares_impares_v3()