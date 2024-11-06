package src;
import java.util.*;

class Edge {
    int destino;
    int costo;

    Edge(int destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }
}

public class RedFibraOptica {
    private int V; // Número de municipios
    private List<List<Edge>> adj; // Lista de adyacencia

    public RedFibraOptica(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void agregarConexion(int origen, int destino, int costo) {
        adj.get(origen).add(new Edge(destino, costo));
        adj.get(destino).add(new Edge(origen, costo)); // Como es una conexión bidireccional
    }

    public void prim() {
        boolean[] enMST = new boolean[V];
        int[] costoMinimo = new int[V];
        int[] padre = new int[V];

        Arrays.fill(costoMinimo, Integer.MAX_VALUE);
        costoMinimo[0] = 0; // Comenzamos desde el primer municipio
        padre[0] = -1; // El primer nodo no tiene padre

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.costo));
        pq.add(new Edge(0, costoMinimo[0]));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.destino;

            if (enMST[u]) continue;

            enMST[u] = true; // Incluimos el nodo en el árbol

            for (Edge e : adj.get(u)) {
                int v = e.destino;
                int costo = e.costo;

                if (!enMST[v] && costo < costoMinimo[v]) {
                    costoMinimo[v] = costo;
                    padre[v] = u;
                    pq.add(new Edge(v, costoMinimo[v]));
                }
            }
        }

        // Imprimir el resultado
        imprimirResultado(padre);
    }

    private void imprimirResultado(int[] padre) {
        int costoTotal = 0;
        System.out.println("Aristas del árbol de expansión mínima:");
        for (int i = 1; i < padre.length; i++) {
            System.out.println("Municipio " + padre[i] + " - Municipio " + i);
            costoTotal += adj.get(i).get(padre[i]).costo; // Sumar el costo de la arista
        }
        System.out.println("Costo total de la instalación: " + costoTotal + " pesos colombianos");
    }

    public static void main(String[] args) {
        RedFibraOptica red = new RedFibraOptica(5); // Suponiendo 5 municipios

        // Agregar conexiones (origen, destino, costo)
        red.agregarConexion(0, 1, 10);
        red.agregarConexion(0, 2, 6);
        red.agregarConexion(0, 3, 5);
        red.agregarConexion(1, 3, 15);
        red.agregarConexion(2, 3, 8);
        red.agregarConexion(1, 2, 12);

        // Ejecutar Prim
        red.prim();
    }
}
