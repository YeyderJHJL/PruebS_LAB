def calcular_area(base_texto, altura_texto):
    try:
        base = float(base_texto)
        altura = float(altura_texto)

        if base <= 0 or altura <= 0:
            raise ValueError("Error: La base y la altura deben ser mayores que cero.")

        return base * altura

    except ValueError:
        raise ValueError("Error: Debe ingresar valores numéricos válidos.")

def main():
    base = input("Ingrese la base del rectángulo: ")
    altura = input("Ingrese la altura del rectángulo: ")

    try:
        area = calcular_area(base, altura)
        print(f"Base: {base}, Altura: {altura}, Área: {area}")
    except ValueError as e:
        print(e)

if __name__ == "__main__":
    main()
