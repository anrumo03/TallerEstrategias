package src;

public class dinamica {

    public static int mochila(int capacidad, int[] pesos, int[] valores) {
        int n = pesos.length;
        // Tabla para almacenar los valores máximos en función de la capacidad
        int[][] tabla = new int[n + 1][capacidad + 1];

        // Rellenar la tabla
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (i == 0 || w == 0) {
                    tabla[i][w] = 0; // Caso base
                } else if (pesos[i - 1] <= w) {
                    // Valor máximo al incluir el objeto i-1
                    tabla[i][w] = Math.max(valores[i - 1] + tabla[i - 1][w - pesos[i - 1]], tabla[i - 1][w]);
                } else {
                    // No incluir el objeto i-1
                    tabla[i][w] = tabla[i - 1][w];
                }
            }
        }

        // El valor máximo se encuentra en la última celda
        return tabla[n][capacidad];
    }

    public static void main(String[] args) {
        int[] pesos = { 10, 20, 30, 40, 50 };
        int[] valores = { 5, 25, 50, 40, 60 };
        int capacidad = 100;

        System.out.println(mochila(capacidad, pesos, valores));
    }

}

