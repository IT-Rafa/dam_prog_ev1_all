package U4_Ejercicios_Entrega_Matriz_Multi;

public class Ejercicio_1_Banner {
        public static void main(String[] args) {
    
            // Altura letras
            final int MAXHEIGHT = 5;
    
            // Aviso si no hay argumentos
            if (args.length == 0) {
                System.out.println("Error. No argumentos");
                return;
            }
    
            // Si hay varios argumentos, lo convertimos a un solo string
            String input = args[0].toLowerCase();
            for (int i = 1; i < args.length; i++) {
                input += " " + args[i];
            }
            
            // Convertimos string a  char[][][]
            char[][][] graph = StringToConsoleGraph(input);
    
            // Mostramos char[][][]
    
            // Para mostrar cada letra
            // Repetimos altura de todas letras
            for (int line = 0; line < MAXHEIGHT; line++) {
                // Recorremos cada letra
                for (int aChar = 0; aChar < graph.length; aChar++) {
                    // Mostramos cada línea
                    System.out.print(graph[aChar][line]);
                    // Con un espacio tras cada letra
                    System.out.print(" ");
                }
                // Salto línea tras cada línea
                System.out.println();
            }
    
        }
        /**
         * Convertimos String a char[][][], que será una conversión con
         * la letra # convirtiendo caracteres en un gráfico de letras grandes
         * en consola.
         * 
         * @param st String a convertir
         * @return char[][][] convertido
         */
        private static char[][][] StringToConsoleGraph(String st) {
            // Caracteres que se piden: A, C, D, E, I, L, M, O, S, T
    
            // array a devolver, según tamaño string
            char[][][] result = new char[st.length()][][];
    
            // Recorremos string
            for (int i = 0; i < st.length(); i++) {
                
                // array interno con gráfico letras
                char[][] aChar;
                // Convertimos String, según carácter
                if (st.charAt(i) == ' ') {
                    aChar = new char[][] {
                            { ' ', ' ', ' ' },
                            { ' ', ' ', ' ' },
                            { ' ', ' ', ' ' },
                            { ' ', ' ', ' ' },
                            { ' ', ' ', ' ' }
                    };
                } else if (st.charAt(i) == 'a') {
                    aChar = new char[][] {
                            { '#', '#', '#', '#' },
                            { '#', ' ', ' ', '#' },
                            { '#', '#', '#', '#' },
                            { '#', ' ', ' ', '#' },
                            { '#', ' ', ' ', '#' }
                    };
                } else if (st.charAt(i) == 'b') {
                    aChar = new char[][] {
                            { '#', '#', '#', '#' },
                            { '#', ' ', ' ', '#' },
                            { '#', '#', '#', ' ' },
                            { '#', ' ', ' ', '#' },
                            { '#', '#', '#', '#' }
                    };
                } else if (st.charAt(i) == 'c') {
                    aChar = new char[][] {
                            { '#', '#', '#', '#' },
                            { '#', ' ', ' ', ' ' },
                            { '#', ' ', ' ', ' ' },
                            { '#', ' ', ' ', ' ' },
                            { '#', '#', '#', '#' }
                    };
                } else if (st.charAt(i) == 'd') {
                    aChar = new char[][] {
                            { '#', '#', ' ', ' ' },
                            { '#', ' ', '#', ' ' },
                            { '#', ' ', ' ', '#' },
                            { '#', ' ', '#', ' ' },
                            { '#', '#', ' ', ' ' }
                    };
                } else if (st.charAt(i) == 'e') {
                    aChar = new char[][] {
                            { '#', '#', '#', '#' },
                            { '#', ' ', ' ', ' ' },
                            { '#', '#', '#', ' ' },
                            { '#', ' ', ' ', ' ' },
                            { '#', '#', '#', '#' }
                    };
                } else if (st.charAt(i) == 'i') {
                    aChar = new char[][] {
                            { ' ', '#', ' ' },
                            { ' ', '#', ' ' },
                            { ' ', '#', ' ' },
                            { ' ', '#', ' ' },
                            { ' ', '#', ' ' }
                    };
                } else if (st.charAt(i) == 'l') {
                    aChar = new char[][] {
                            { '#', ' ', ' ', ' ' },
                            { '#', ' ', ' ', ' ' },
                            { '#', ' ', ' ', ' ' },
                            { '#', ' ', ' ', ' ' },
                            { '#', '#', '#', '#' }
                    };
                } else if (st.charAt(i) == 'm') {
    
                    aChar = new char[][] {
                            { '#', ' ', ' ', ' ', '#' },
                            { '#', '#', ' ', '#', '#' },
                            { '#', ' ', '#', ' ', '#' },
                            { '#', ' ', ' ', ' ', '#' },
                            { '#', ' ', ' ', ' ', '#' }
                    };
                } else if (st.charAt(i) == 'o') {
    
                    aChar = new char[][] {
                            { '#', '#', '#', '#', '#' },
                            { '#', ' ', ' ', ' ', '#' },
                            { '#', ' ', ' ', ' ', '#' },
                            { '#', ' ', ' ', ' ', '#' },
                            { '#', '#', '#', '#', '#' }
                    };
                } else if (st.charAt(i) == 's') {
                    aChar = new char[][] {
                            { '#', '#', '#', '#' },
                            { '#', ' ', ' ', ' ' },
                            { '#', '#', '#', '#' },
                            { ' ', ' ', ' ', '#' },
                            { '#', '#', '#', '#' }
                    };
                } else if (st.charAt(i) == 't') {
                    aChar = new char[][] {
                            { '#', '#', '#', '#', '#' },
                            { ' ', ' ', '#', ' ', ' ' },
                            { ' ', ' ', '#', ' ', ' ' },
                            { ' ', ' ', '#', ' ', ' ' },
                            { ' ', ' ', '#', ' ', ' ' }
                    };
                } else { // cualquier letra que no tenga equivalente
                    aChar = new char[][] {
                            { '#', '#', '#', '#' },
                            { '#', '#', '#', '#' },
                            { '#', '#', '#', '#' },
                            { '#', '#', '#', '#' },
                            { '#', '#', '#', '#' }
                    };
                }
                // Añadimos caracter al array para devolver
                result[i] = aChar;
            }
            // Devolvemos array
            return result;
        }
    
    }
    