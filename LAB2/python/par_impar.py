def identificar_pares_impares(numeros):

    if numeros is None:
        raise TypeError("La lista no debe ser None")
    
    resultados = []
    for num in numeros:
        if num % 2 == 0:
            resultados.append(f"{num} es par.")
        else:
            resultados.append(f"{num} es impar.")
    return resultados


def main():
    
    print("Identificador de números pares e impares")
    
    while True:
        try:
            cantidad = input("¿Cuántos números deseas ingresar? (o 'salir' para terminar): ")
            
            if cantidad.lower() == 'salir':
                print("Saliendo del programa...")
                break
            
            # Validar que sea número entero positivo
            if not cantidad.isdigit():
                print("Error: La cantidad debe ser un número entero positivo.")
                continue
                
            cantidad = int(cantidad)
            
            if cantidad < 0:
                print("Error: La cantidad no puede ser negativa.")
                continue
                
            if cantidad == 0:
                print("No se ingresarán números (cantidad 0).")
                continue
                
            numeros = []
            for i in range(cantidad):
                while True:
                    entrada = input(f"Ingrese el número {i+1}: ")
                    
                    try:
                        num = int(entrada)
                        numeros.append(num)
                        break
                    except ValueError:
                        print("Error: Debe ingresar un número entero válido.")
            
            resultados = identificar_pares_impares(numeros)
            print("\nResultados:")
            for resultado in resultados:
                print(resultado)
            print()
            
        except Exception as e:
            print(f"Error inesperado: {e}")


if __name__ == "__main__":
    main()