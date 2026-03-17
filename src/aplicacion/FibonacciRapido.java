package aplicacion;

// Complejidad: O(log_2 n) (Cada llamada divide el problema entre 2).
public class FibonacciRapido {
    public static void multiplicar(int[][] A, int[][] B) {
        int x = A[0][0]*B[0][0] + A[0][1]*B[1][0];
        int y = A[0][0]*B[0][1] + A[0][1]*B[1][1];
        int z = A[1][0]*B[0][0] + A[1][1]*B[1][0];
        int w = A[1][0]*B[0][1] + A[1][1]*B[1][1];

        A[0][0] = x;
        A[0][1] = y;
        A[1][0] = z;
        A[1][1] = w;
    }

    public static void potencia(int[][] matriz, int n) {
        if (n <= 1) {
            return;
        }

        int[][] base = {{1,1},{1,0}};
        potencia(matriz, n/2);
        multiplicar(matriz, matriz);

        if (n % 2 != 0) {
            multiplicar(matriz, base);
        }
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        int[][] matriz = {{1,1},{1,0}};
        potencia(matriz, n-1);
        return matriz[0][0];
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("Número " + n + " en Fibonacci: " + Fibonacci(n));
    }
}