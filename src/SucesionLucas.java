package src;

//Tabulacion
public class SucesionLucas {

    public static int lucas(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 1;
        }

        // Crear un array para almacenar los valores de la sucesión de Lucas
        int[] lucasArray = new int[n + 1];

        // Inicializar los dos primeros valores
        lucasArray[0] = 2;
        lucasArray[1] = 1;

        // Calcular los valores restantes usando tabulación
        for (int i = 2; i <= n; i++) {
            lucasArray[i] = lucasArray[i - 1] + lucasArray[i - 2];
        }

        // Retornar el n-ésimo valor de la sucesión de Lucas
        return lucasArray[n];
    }

    public static void main(String[] args) {
        int n = 10; // Puedes cambiar este valor para calcular otro número en la sucesión
        System.out.println("El término " + n + " de la sucesión de Lucas es: " + lucas(n));
    }
}
