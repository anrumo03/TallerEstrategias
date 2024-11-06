package src;

public class divideVenceras {

        public static int sumaRecursiva(int[] arr, int inicio, int fin) {
            // Caso base: si el inicio es igual al fin, hay un solo elemento
            if (inicio == fin) {
                return arr[inicio];
            } else {
                // Dividir el arreglo en dos mitades
                int medio = (inicio + fin) / 2;

                // Calcular la suma de cada mitad recursivamente
                int sumaIzquierda = sumaRecursiva(arr, inicio, medio);
                int sumaDerecha = sumaRecursiva(arr, medio + 1, fin);

                // Combinar las sumas de las mitades
                return sumaIzquierda + sumaDerecha;
            }
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            System.out.println(sumaRecursiva(arr, 0, arr.length - 1));
        }
}
