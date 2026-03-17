package aplicacion;

/* Complejidad:
- Tiempo: O(n)
- Memoria: O(1) (solo 3 variables) 
*/ 
public class FibonacciIterativo {
    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int resultado = 0;

        for (int i = 2; i <= n; i++) {
            resultado = a + b;
            a = b;
            b = resultado;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("Número " + n + " en Fibonacci: " + Fibonacci(n));
    }
}