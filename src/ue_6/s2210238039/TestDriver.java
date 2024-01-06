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
        System.out.println("Test for exercise 1");
        for(int x = 0; x < chessArray.length; x++){
            for(int y = 0; y < chessArray.length; y++){
                if(ChessUtil.checkPosition(chessArray, x, y)){
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
        for(int x = 0; x < chessArray2.length; x++){
            for(int y = 0; y < chessArray2.length; y++){
                if(ChessUtil.checkPosition(chessArray2, x, y)){
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
        for(int x = 0; x < chessArray3.length; x++){
            for(int y = 0; y < chessArray3.length; y++){
                if(ChessUtil.checkPosition(chessArray3, x, y)){
                    System.out.println("On x: " + x + " || And y: " + y + " can be placed a queen");
                }
            }
        }

        // Aufgabe 6.2:
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
        for(int x = 0; x < chessArray4.length; x++){
            for(int y = 0; y < chessArray4.length; y++){
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
        for(int x = 0; x < chessArray5.length; x++){
            for(int y = 0; y < chessArray5.length; y++){
                System.out.print(" " + chessArray5[x][y]);
            }
            System.out.println();
        }

        // Aufgabe 3:
        int[][] adjacencyMatrix = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };

        int start = 0;
        int end = 3;

        boolean pathExists = GraphUtil.existPath(adjacencyMatrix, start, end);
        System.out.println("Path between " + start + " and " + end + ": " + pathExists);

        int[][] adjacencyMatrix2 = {
                {0, 1, 1, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 0}
        };

        int start2 = 0;
        int end2 = 1;

        boolean pathExists2 = GraphUtil.existPath(adjacencyMatrix2, start2, end2);
        System.out.println("Path between " + start2 + " and " + end2 + ": " + pathExists2);
    }
}
