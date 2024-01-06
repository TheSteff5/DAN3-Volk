package ue_6.s2210238039;

/**
 * @author: Stefan Miskovic s2210238039
 */
public class ChessUtil {

    public static boolean checkPosition(boolean[][] array, int column, int line) {
        // vertical
        for (int y = 0; y < array.length; y++) {
            if (array[line][y]) {
                return false;
            }
        }

        //horizontal
        for (int x = 0; x < array.length; x++) {
            if (array[x][column]) {
                return false;
            }
        }

        //right up
        for(int x = column, y = line; x < array.length && y < array.length; x++, y++){
            if (array[y][x]) {
                return false;
            }
        }

        //right down
        for(int x = column, y = line; x < array.length && y >= 0; x++, y--){
            if (array[y][x]) {
                return false;
            }
        }

        //left up
        for(int x = column, y = line; x >= 0 && y < array.length; x--, y++){
            if (array[y][x]) {
                return false;
            }
        }

        //left down
        for(int x = column, y = line; x >=0 && y >= 0; x--, y--){
            if (array[y][x]) {
                return false;
            }
        }

        return true;
    }

    public static boolean placeQueen(boolean[][] array, int line){
        for(int x = 0; x < array.length; x++) {
            if(checkPosition(array, x, line)){
                array[line][x] = true;
                if(line+1 < array.length){
                    if(!placeQueen(array, line+1)){
                        array[line][x] = false;
                    }else {
                        return true;
                    }
                }else {
                    return true;
                }
            }
        }
        return false;
    }



}
