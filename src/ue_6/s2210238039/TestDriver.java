package ue_6.s2210238039;

/**
 * @author: Stefan Miskovic s2210238039
 */
public class TestDriver {
    public static void main(String[] args) {
        boolean[][] chessArray = {
                {false, true, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        // Aufgabe 6.1:
        System.out.println("###Exercise 6.1###");
        System.out.println("Test for exercise 1");
        for (int x = 0; x < chessArray.length; x++) {
            for (int y = 0; y < chessArray.length; y++) {
                if (ChessUtil.checkPosition(chessArray, x, y)) {
                    System.out.println("On x: " + x + " || And y: " + y + " can be placed a queen");
                }
            }
        }

        boolean[][] chessArray2 = {
                {false, false, false, false},
                {false, false, true, false},
                {false, false, false, false},
                {false, false, false, false}
        };
        System.out.println("2.Test for exercise 1");
        for (int x = 0; x < chessArray2.length; x++) {
            for (int y = 0; y < chessArray2.length; y++) {
                if (ChessUtil.checkPosition(chessArray2, x, y)) {
                    System.out.println("On x: " + x + " || And y: " + y + " can be placed a queen");
                }
            }
        }

        boolean[][] chessArray3 = {
                {false, false, false, false},
                {false, false, true, false},
                {false, false, false, false},
                {false, false, false, true}
        };
        System.out.println("3.Test for exercise 1");
        for (int x = 0; x < chessArray3.length; x++) {
            for (int y = 0; y < chessArray3.length; y++) {
                if (ChessUtil.checkPosition(chessArray3, x, y)) {
                    System.out.println("On x: " + x + " || And y: " + y + " can be placed a queen");
                }
            }
        }

        // Aufgabe 6.2:
        System.out.println("###Exercise 6.2###");
        boolean[][] chessArray4 = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        // Setzen der Damen in einem 4x4
        System.out.println();
        System.out.println("Set Queens in a 4x4 Array");
        ChessUtil.placeQueen(chessArray4, 0);
        for (int x = 0; x < chessArray4.length; x++) {
            for (int y = 0; y < chessArray4.length; y++) {
                System.out.print(" " + chessArray4[x][y]);
            }
            System.out.println();
        }

        boolean[][] chessArray5 = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };

        System.out.println();
        System.out.println("Set Queens in a 5x5 Array");
        ChessUtil.placeQueen(chessArray5, 0);
        for (int x = 0; x < chessArray5.length; x++) {
            for (int y = 0; y < chessArray5.length; y++) {
                System.out.print(" " + chessArray5[x][y]);
            }
            System.out.println();
        }

        // Aufgabe 3:
        // Anmerkung: wurde mithilfe ChatGPT gelöst, jedoch von mir getestet
        int[][] adjacencyMatrix = {
                {0, 0, 0, 0, 1},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0}
        };

        int startVertex = 0;
        int endVertex = 3;

        System.out.println("###Exercise 6.3###");
        if (GraphUtil.existPath(adjacencyMatrix, startVertex, endVertex)) {
            System.out.println("Path exists between " + startVertex + " and " + endVertex);
        } else {
            System.out.println("No path exists between " + startVertex + " and " + endVertex);
        }

        int[][] adjacencyMatrix2 = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 0, 0, 1, 0}
        };


        startVertex = 0;
        endVertex = 3;

        if (GraphUtil.existPath(adjacencyMatrix2, startVertex, endVertex)) {
            System.out.println("Path exists between " + startVertex + " and " + endVertex);
        } else {
            System.out.println("No path exists between " + startVertex + " and " + endVertex);
        }

        int[][] adjacencyMatrix3 = {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0}
        };


        startVertex = 1;
        endVertex = 0;

        if (GraphUtil.existPath(adjacencyMatrix3, startVertex, endVertex)) {
            System.out.println("Path exists between " + startVertex + " and " + endVertex);
        } else {
            System.out.println("No path exists between " + startVertex + " and " + endVertex);
        }
    }
}
