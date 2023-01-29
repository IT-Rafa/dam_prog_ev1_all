package IV_Arrays_y_Diseño_2_capas.IV_Array_Multidimensionales.Soluciones_Propias.U4_B4C;

import java.util.Scanner;

/*
 * Ejercicio U4_B4C_E2: SUDOKUS CORRECTOS EN CODERUNNER Acepta el reto Sudokus
 * correctos id 345. Buscamos texto en enlace
 * http://www.aceptaelreto.com/problem/statement.php?id=345
 *
 * Sudokus correctos Tiempo máximo: 1,000-2,000 sMemoria máxima: 4096 KiB Sudoku
 * completo
 *
 * El sudoku es un pasatiempo lógico que consiste en rellenar una cuadrícula de
 * 9×9 casillas dividida en nueve regiones 3×3 (las separadas con líneas más
 * gruesas en la imagen) con los números del 1 al 9 de tal forma que no se
 * repitan números en ninguna fila, columna o región. El sudoku inicialmente se
 * presenta con algunas casillas ya rellenas, a modo de pistas, y el jugador
 * debe deducir los valores de las casillas vacías. Si el sudoku está bien
 * planteado, la solución es única.
 *
 * Dado un sudoku completamente relleno, ¿sabrías construir un programa que
 * comprobara si es correcto (es decir, cada fila, columna o región contiene los
 * números del 1 al 9 exactamente una vez)?
 *
 * Entrada
 *
 * La entrada comienza con un número que representa el número de casos de prueba
 * que vendrán a continuación.
 *
 * Cada caso de prueba está formado por 9 líneas, cada una con 9 números entre
 * el 1 y el 9 separados por espacios, que representan un sudoku completamente
 * relleno.
 *
 * Salida
 *
 * Para cada caso, se escribirá una línea con la palabra SI si el sudoku ha sido
 * resuelto correctamente, y NO en caso contrario.
 *
 * Entrada de ejemplo
 *
 * 1 4 1 3 8 2 5 6 7 9 5 6 7 1 4 9 8 3 2 2 8 9 7 3 6 1 4 5 1 9 5 4 6 2 7 8 3 7 2
 * 6 9 8 3 5 1 4 3 4 8 5 1 7 2 9 6 8 5 1 6 9 4 3 2 7 9 7 2 3 5 8 4 6 1 6 3 4 2 7
 * 1 9 5 8
 *
 * Salida de ejemplo
 *
 * SI
 */

public class Ejercicio_U4_B4C_E2 {

	static final int SUDOKU_TAM = 9;
	static final int GRILLA_TAM = 3;
	static final int NUMBERS_TAM = 8;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int repetir = 1; // Integer.parseInt(sc.nextLine());
		while (repetir-- != 0) {
			int[][] sudoku = {
				{ 4, 1, 3, 8, 2, 5, 6, 7, 9 },
				{ 5, 6, 7, 1, 4, 9, 8, 3, 2 },
				{ 2, 8, 9, 7, 3, 6, 1, 4, 5 },
				{ 1, 9, 5, 4, 6, 2, 7, 8, 3 },
				{ 7, 2, 6, 9, 8, 3, 5, 1, 4 },
				{ 3, 4, 8, 5, 1, 7, 2, 9, 6 },
				{ 8, 5, 1, 6, 9, 4, 3, 2, 7 },
				{ 9, 7, 2, 3, 5, 8, 4, 6, 1 },
				{ 6, 3, 4, 2, 7, 1, 9, 5, 8 }
			};
			/*
			 * int[][] sudoku = new int[SUDOKU_TAM][SUDOKU_TAM];
			 *
			 * for (int i = 0; i < SUDOKU_TAM; i++) { String line = sc.nextLine(); String[]
			 * values = line.split(" "); for (int j = 0; j < SUDOKU_TAM; j++) { sudoku[i][j]
			 * = Integer.parseInt(values[j]); }
			 */
			System.out.println((checkSudoku(sudoku)) ? "SI" : "NO");
		}
		sc.close();
	}

	/**
	 * Comprueba si el sudokut contiene los números distintos en cada fila,
	 * columna y cada una de las grillas
	 *
	 * @param sudoku Matriz que contiene los valores del sudoku
	 * @return true si los números están correctos, false si no
	 */
	public static boolean checkSudoku(int[][] sudoku) {
		// COMPROBAMOS FILAS
		// Recorremos filas
		for (int fila = 0; fila < SUDOKU_TAM; fila++) {
			// Recorremos columnas
			for (int col = 0; col < SUDOKU_TAM - 1; col++) {
				// Recorremos columnas de nuevo, desde siguente a bucle anterior
				for (int col2 = col + 1; col2 < SUDOKU_TAM; col2++) {
					// Valor de columna en bucle anterior es distinto de las otras
					if (sudoku[fila][col] == sudoku[fila][col2]) {
						return false;
					}
				}
			}
		}

		// COMPROBAMOS COLUMNAS
		// Recorremos columnas
		for (int col = 0; col < SUDOKU_TAM; col++) {
			// Recorremos filas
			for (int fila = 0; fila < SUDOKU_TAM - 1; fila++) {
				// Recorremos fila de nuevo, desde siguente a bucle anterior
				for (int fila2 = fila + 1; fila2 < SUDOKU_TAM; fila2++) {
					// Valor de fila en bucle anterior es distinto de las otras
					if (sudoku[fila][col] == sudoku[fila2][col]) {
						return false;
					}
				}
			}
		}

		// COMPROBAMOS GRILLAS
		// Recorremos filas por grillas. para tener el la primera de las grillas
		for (int fila = 0; fila < SUDOKU_TAM; fila += GRILLA_TAM) {
			// Recorremos columnas por grillas. para tener el la primera de las grillas
			for (int col = 0; col < SUDOKU_TAM; col += GRILLA_TAM) {
				// row, col is start of the 3 by 3 grid
				for (int pos = 0; pos < SUDOKU_TAM - 1; pos++) {
					for (int pos2 = pos + 1; pos2 < SUDOKU_TAM; pos2++) {
						if (
							sudoku[fila + pos % GRILLA_TAM][col +
								pos /
								GRILLA_TAM] ==
							sudoku[fila + pos2 % GRILLA_TAM][col +
								pos2 /
								GRILLA_TAM]
						) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
