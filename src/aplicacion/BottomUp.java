package aplicacion;

public class BottomUp {
    public static void main(String[] args) throws Exception {
        int [] V = {1, 4, 7, 8, 10}; // Valores que hay en el array V.
        int [] W = {1, 2, 6, 10, 7}; // Pesos en cada objeto.
        int C = 12; // Capacidad que me cabe en la mochila.

        int resultado = mochila(V, W, C);
        System.out.println("Resultado: " + resultado);
    }
    
    // Mochila es Bottom-Up.
    public static int mochila(int[] V, int[] W, int C) {
        // Comprobación de seguridad.
        if(V.length != W.length) { return -1; }

        // Memoria - variables a ir resolviendo.
        int[][] beneficio = new int[V.length + 1][C + 1];

        // Problema más pequeño y evidente.
        for(int i = 0; i <= V.length; i++) { beneficio[i][0] = 0; }
        for(int j = 0; j <= C; j++) { beneficio[0][j] = 0; }

        // Resolviendo problemas de menor a mayor con optimalidad de Bellmann.
        for (int n_objetos = 1; n_objetos <= V.length; n_objetos++) {
            for (int capacidad = 1; capacidad <= C; capacidad++) {
                // Si no cabe.
                if (W[n_objetos - 1] > capacidad) {
                    // No se coge - que es como si no existiese (un objeto menos).
                    beneficio[n_objetos][capacidad] = beneficio[n_objetos - 1][capacidad];
                }
                else {
                    // Sí que cabe - cogerlo o no cogerlo.
                    int no_coger = beneficio[n_objetos - 1][capacidad];
                    int coger = V[n_objetos - 1] + beneficio[n_objetos - 1][capacidad - W[n_objetos - 1]];

                    beneficio[n_objetos][capacidad] = Math.max(no_coger, coger);
                }
            }
        }

        for (int n_objetos = 0; n_objetos <= V.length; n_objetos++) {
            for (int capacidad = 0; capacidad <= C; capacidad++) {
                System.out.print(beneficio[n_objetos][capacidad] + " ");
            }
            System.out.println();
        }
        return beneficio[V.length][C];
    }
}