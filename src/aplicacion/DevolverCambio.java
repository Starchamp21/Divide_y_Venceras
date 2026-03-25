package aplicacion;

import java.util.ArrayList;

public class DevolverCambio {
    public static ArrayList<Double> cambioMonedas(double cantidad) {
        // Conjunto de candidatos (monedas ordenadas de mayor a menor)
        double[] monedas = {2.00, 1.00, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};

        ArrayList<Double> solucion = new ArrayList<>();

        int i = 0;
        double e = 0.001; // margen para errores de precisión.

        // Mientras quede cantidad por devolver
        while (cantidad > e && i < monedas.length) {
            // Si la moneda cabe → la elegimos (decisión voraz).
            if (cantidad >= monedas[i] - e) {
                solucion.add(monedas[i]);
                cantidad -= monedas[i];
            } else {
                // Si no cabe → pasamos a la siguiente moneda.
                i++;
            }
        }
        return solucion;
    }

    public static void main(String[] args) {
        double cantidad = 6.71;
        ArrayList<Double> resultado = cambioMonedas(cantidad);

        System.out.println("Cambio:");
        for (double moneda : resultado) {
            System.out.println(moneda);
        }
    }
}