package U4_B4B;

/* Ejercicio U4_B4B_E2: 
	Acepta el reto Campo de minas id 176.
	Buscamos texto en enlace
	https://www.aceptaelreto.com/pub/problems/v002/07/st/statements/Spanish/index.html

	Sombras en el camping
	Tiempo máximo: 2,000-4,000 sMemoria máxima: 4096 KiB

	Se acerca el verano y los aficionados a la naturaleza pasarán buena parte de él en campings, 
	disfrutando del aire libre.

	Un requisito imprescindible en los meses de calor es colocar la tienda de campaña bajo la 
	sombra de un buen árbol para poder pasar frescos las horas de siesta. Pero, dependiendo de 
	la zona, eso no siempre es fácil. En los campings nuevos, el número de árboles es escaso, 
	y también lo es por tanto el número de parcelas aptas para tiendas.

	Árboles en un camping
	Figura 1: primer ejemplo de entrada destacando las zonas de sombra

	Sabiendo que cada árbol proporciona sombra a las ocho parcelas adyacentes, ¿cuántas tiendas 
	de campaña disfrutarán de sombra en un camping?
	Entrada

	El programa deberá procesar múltiples casos de prueba recibidos por la entrada estándar. 
	Cada uno representa un camping formado por una cuadrícula de parcelas de igual tamaño en 
	los que puede haber hueco para una tienda, o un árbol.

	Cada caso de prueba comienza con dos números 1 ≤ c, f ≤ 50, indicando el número de columnas 
	y de filas de la cuadrícula de parcelas. A continuación se indica el número a de árboles del 
	camping.

	Si hay árboles, en la siguiente línea aparece la posición de todos ellos, indicando para cada 
	uno la columna (1…c) y la fila (1…f) que ocupan. En total, aparecerán 2×a números.

	La entrada termina con una línea con tres ceros (camping con dimensiones nulas y sin árboles), 
	que no debe procesarse.
	Salida

	Por cada caso de prueba el programa indicará, en una línea, el número de parcelas que 
	disfrutarán de sombra.
	
	Entrada de ejemplo

	7 7 8
	7 2 3 3 4 3 4 4 3 5 4 5 1 7 2 7
	5 3 1
	3 2
	0 0 0
	Salida de ejemplo

	22
	8



 */

/*     Análisis Las sombras que cuadran con varios arboles no se repiten
	7 7 8
	7 2 3 3 4 3 4 4 3 5 4 5 1 7 2 7
	00000oo
	0ooooo*
	0o**ooo
	0oo*o00
	0o**o00
	ooooo00
	**o0000

 * - Pedimos columnas, filas y arboles
 * - Si está linea tiene 0, 0, 0 finalizamos
 *      - Pedimos posición (columna y fila) de cada arbol
 *      - Contamos parcelas con sombra
 *      - Mostramos sombra
 *      - Volvemos a pedir columnas, filas y arboles
 */

import java.util.Scanner;

public class Ejercicio_4_B4B_E2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Pedimos columnas, filas y arboles
		String inputTamArb = sc.nextLine();

		// Comprobamos que no es todo 0
		while (!inputTamArb.equals("0 0 0")) {
			// Convertimos columna y fila en enteros
			String[] inputList = inputTamArb.split(" ");
			int colMatriz = Integer.parseInt(inputList[0]);
			int filaMatriz = Integer.parseInt(inputList[1]);

			// Pedimos a usuario la posición de cada árbol (columna y fila)
			// todas en una línea.
			String inputArboles = sc.nextLine();
			// Separamos datos
			String[] arbolesPos = inputArboles.split(" ");

			// Creamos matriz (Con char vacio en cada línea)
			char[][] matriz = new char[filaMatriz][colMatriz];

			// Añadimos char '*' para cada arbol
			for (int i = 0; i < arbolesPos.length; i += 2) {
				matriz[Integer.parseInt(arbolesPos[i + 1]) -
					1][Integer.parseInt(arbolesPos[i]) - 1] =
					'*';
			}

			// Contamos sombras
			int cantSombras = 0;

			// Recorremos matriz y, para cada arbol, contamos las sombras
			for (int fila = 0; fila < filaMatriz; fila++) {
				for (int col = 0; col < colMatriz; col++) {
					if (matriz[fila][col] == '*') {
						cantSombras += añadirSombras(matriz, fila, col);
					}
				}
			}
			// Muestra la cantidad de sombras
			System.out.println(cantSombras);

			// Pedimos columnas, filas y arboles, para repetir
			inputTamArb = sc.nextLine();
		}

		sc.close();
	}

	/**
	 * Cuenta las sombras de cada arbol, ignorando las sombras de los arboles
	 * contados anteriormente
	 *
	 * @param matriz Matriz donde están los arboles y sus sombras
	 * @param fila   Fila en la matriz, donde está el arbol
	 * @param col    Col en la matriz, donde está el arbol
	 *
	 * @return Cantidad de sombras que tiene el árbol, sin contar las anteriores
	 */
	static int añadirSombras(char[][] matriz, int fila, int col) {
		// total sombras
		int total = 0;
		for (
			int f = Math.max(0, fila - 1);
			f < Math.min(matriz.length, fila + 2);
			f++
		) {
			for (
				int c = Math.max(0, col - 1);
				c < Math.min(matriz[f].length, col + 2);
				c++
			) {
				if (f == fila && c == col) {
					continue;
				}
				// Para cada grupo que no son arboles, ni sombras de arboles
				// ya contadas, las sumamos y convertimos en arbol. char 'o'
				if (matriz[f][c] != '*' && matriz[f][c] != 'o') {
					matriz[f][c] = 'o';
					total++;
				}
			}
		}
		return total;
	}
}
