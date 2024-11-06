package src;

//Dinamica
public class CoeficientesBinomiales {

    public static long binomio(int n, int k) {
        // Crear una tabla para almacenar los coeficientes
        long[][] tabla = new long[n + 1][k + 1];

        // Llenar la tabla usando la relación de recurrencia
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                // Caso base: C(n, 0) = 1
                if (j == 0) {
                    tabla[i][j] = 1;
                } else if (j == i) {
                    // Caso base: C(n, n) = 1
                    tabla[i][j] = 1;
                } else {
                    // Recurrencia: C(n, k) = C(n-1, k-1) + C(n-1, k)
                    tabla[i][j] = tabla[i - 1][j - 1] + tabla[i - 1][j];
                }
            }
        }

        return tabla[n][k];
    }

    public static void main(String[] args) {
        int n = 5; // Número total de elementos
        int k = 2; // Número de elementos a elegir
        long resultado = binomio(n, k);
        System.out.println("C(" + n + ", " + k + ") = " + resultado);
    }
}
