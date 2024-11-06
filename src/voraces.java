package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class voraces {

    public static void calcularCambioOptimo(int monto, Map<Integer, Integer> disponibilidad) {
        Map<Integer, Integer> cambio = new HashMap<>();
        int[] denominaciones = {50000, 20000, 10000}; // Ajustar según las denominaciones disponibles

        if (monto % 10000 != 0) {
            System.out.println("El monto no es divisible por 10000");
        }

        for (int denominacion : denominaciones) {
            int cantidadBilletes = Math.min(monto / denominacion, disponibilidad.getOrDefault(denominacion, 0));
            cambio.put(denominacion, cantidadBilletes);
            monto -= cantidadBilletes * denominacion;
        }

        if(monto == 0){
            for (Map.Entry<Integer, Integer> entry : cambio.entrySet()) {     System.out.println("Billetes de $" + entry.getKey() + ": " + entry.getValue());      }
        }
        else{
            System.out.println("No hay suficientes billetes para dar el cambio.");
        }
    }

    public static List<Integer> calcularBinomialCoeficientes(int n) {
        List<Integer> coeficientes = new ArrayList<>();
        coeficientes.add(1); // C(0, 0) = 1

        for (int i = 1; i <= n; i++) {
            coeficientes.add(1); // C(i, 0) = 1
            for (int j = i - 1; j > 0; j--) {
                coeficientes.set(j, coeficientes.get(j - 1) + coeficientes.get(j));
            }
        }

        return coeficientes;
    }



    public static void main(String[] args) {


        int n = 5;
        List<Integer> result = calcularBinomialCoeficientes(n);
        System.out.println("Coeficientes binomiales para n = " + n);
        for (int i = 0; i <= n; i++) {
            System.out.println("C(" + n + ", " + i + ") = " + result.get(i));
        }
    }


}
