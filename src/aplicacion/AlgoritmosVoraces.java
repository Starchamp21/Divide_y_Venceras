package aplicacion;

import java.util.ArrayList;

public class AlgoritmosVoraces {
    public static void main(String[] args) throws Exception {
        int[] camino = {1, 3, 2, 3, 1, 3, 2, 2, 1, 3, 2, 3, 1}; // Conjunto de todos los candidatos.
        System.out.println("Mínimo número de saltos: " + minSaltos(camino));
    }

    public static int minSaltos(int[] array) {
        int num_saltos = 0;
        int posicion_actual = array.length - 1;

        while(posicion_actual > 0) {
            ArrayList<Integer> opciones = new ArrayList<>();

            // Busco todas las posiciones que pueden llegar a "posicion_actual".
            for (int i = 0; i < posicion_actual; i++) {
                if (i + array[i] >= posicion_actual) {
                    opciones.add(i);
                }
            }

            // Elijo la mejor opción (la más izquierda -> voraz).
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < opciones.size(); j++) {
                if (opciones.get(j) < min) min = opciones.get(j);
            }

            posicion_actual = min;
            num_saltos++;
        }

        return num_saltos;
    }

    /* Versión más eficiente (O(n)).
    public static int minSaltos(int[] arr) {
        int saltos = 0;
        int alcanceActual = 0;
        int maxAlcance = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            maxAlcance = Math.max(maxAlcance, i + arr[i]);

            if (i == alcanceActual) {
                saltos++;
                alcanceActual = maxAlcance;
            }
        }
        return saltos;
    }
    */
}