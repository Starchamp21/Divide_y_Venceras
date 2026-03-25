package aplicacion;

public class Backtracking {

    // Método principal que inicia la resolución.
    public static void resolverSudoku(int[][] sudoku) {
        if (resolverSudokuAux(sudoku, 0, 0)) {
            System.out.println("Sudoku resuelto:");
            imprimirSudoku(sudoku);
        } else {
            System.out.println("No tiene solución");
        }
    }

    // MÉTODO RECURSIVO (BACKTRACKING)
    public static boolean resolverSudokuAux(int[][] sudoku, int fila, int columna) {

        // CASO BASE: he llegado al final del tablero
        if (fila == 9) {
            return true;
        }

        // Si me salgo por la derecha → paso a la siguiente fila.
        if (columna == 9) {
            return resolverSudokuAux(sudoku, fila + 1, 0);
        }

        // Si la casilla ya tiene número → paso a la siguiente
        if (sudoku[fila][columna] != 0) {
            return resolverSudokuAux(sudoku, fila, columna + 1);
        }

        // BACKTRACKING:
        // Pruebo los números del 1 al 9.
        for (int opcion = 1; opcion <= 9; opcion++) {

            // Compruebo si la opción es válida.
            if (casillaCorrecta(sudoku, fila, columna, opcion)) {

                // Elijo (hago el "movimiento").
                sudoku[fila][columna] = opcion;

                // Llamada recursiva.
                if (resolverSudokuAux(sudoku, fila, columna + 1)) {
                    return true;
                }

                // BACKTRACK → deshago.
                sudoku[fila][columna] = 0;
            }
        }
        // No hay solución por este camino.
        return false;
    }

    // COMPRUEBO SI UN NÚMERO ES VÁLIDO.
    public static boolean casillaCorrecta(int[][] sudoku, int fila, int columna, int num) {

        // Compruebo fila.
        for (int i = 0; i < 9; i++) {
            if (sudoku[fila][i] == num) {
                return false;
            }
        }

        // Compruebo columna.
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][columna] == num) {
                return false;
            }
        }

        // Compruebo subcuadrícula 3x3.
        int filaInicio = fila - fila % 3;
        int colInicio = columna - columna % 3; // AQUÍ TENÍA UN ERROR.

        for (int i = filaInicio; i < filaInicio + 3; i++) {
            for (int j = colInicio; j < colInicio + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // MÉTODO PARA IMPRIMIR EL SUDOKU.
    public static void imprimirSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sudoku = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        resolverSudoku(sudoku);
    }
}