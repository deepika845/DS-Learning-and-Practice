public class NQueensPart {
    public static void main(String[] args) {
        System.out.println(nQueens(new boolean[4][4],0));

    }

    public static int nQueens(boolean[][] nQueen, int row) {
        if (row == nQueen.length) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < nQueen[row].length; col++) {
            if (isItSafe(nQueen, row, col)) {
                nQueen[row][col] = true;
                count += nQueens(nQueen, row + 1);
                nQueen[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isItSafe(boolean[][] nQueen, int row, int col) {
        for (int i = 0; i < row; i++) {
            if ( nQueen[i][col]){
                return false;
            }
        }
        for (int i = row,j = col;
        i >= 0 && j >= 0;
        i--, j--){
            if (nQueen[i][j]) {
                return false;
            }
        }
        for (int i = row,j = col;
        i >= 0 && j < nQueen.length;
        i--, j++){
            if(nQueen[i][j]){
                return false;
            }
    }
    return true;
    }

}
