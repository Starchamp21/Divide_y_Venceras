package aplicacion;

public class DivideYVencerasFibonacci {
    // Complejidad del recursivo normal: O(2^n)
    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    // Complejidad de Divide y Vencerás con memorización: O(n)
    public static int Fibonacci_DYV(int n, int[] chuleta) {
        if (n <= 1) {
            return n;
        }
        if (chuleta[n] != -1) {
            return chuleta[n];
        }
        chuleta[n] = Fibonacci_DYV(n - 1, chuleta) + Fibonacci_DYV(n - 2, chuleta);

        return chuleta[n];
    }

    public static void main (String[] args) {
        int n = 8;
        int[] chuleta = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            chuleta[i] = -1;
        }

        System.out.println("Fibonacci normal: " + Fibonacci(n));
        System.out.println("Fibonacci DYV: " + Fibonacci_DYV(n, chuleta));
    }
}