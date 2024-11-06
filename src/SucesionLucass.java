package src;

//Memorizacion
public class SucesionLucass {

    // Arreglo para memorización
    private static long[] memo;

    // Método principal
    public static void main(String[] args) {
        int n = 10; // Cambia este valor para calcular otros términos
        memo = new long[n + 1]; // Inicializar el arreglo de memorización
        for (int i = 0; i <= n; i++) {
            memo[i] = -1; // Inicializar con un valor que indica que no ha sido calculado
        }
        long resultado = lucas(n);
        System.out.println("L(" + n + ") = " + resultado);
    }

    // Método para calcular la sucesión de Lucas con memorización
    private static long lucas(int n) {
        if (n == 0) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        // Verificar si ya hemos calculado L(n)
        if (memo[n] != -1) {
            return memo[n];
        }
        // Calcular L(n) y almacenar en el arreglo
        memo[n] = lucas(n - 1) + lucas(n - 2);
        return memo[n];
    }
}


