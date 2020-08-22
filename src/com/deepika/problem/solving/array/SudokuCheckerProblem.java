package com.deepika.problem.solving.array;

import java.util.HashSet;
import java.util.Set;

public class SudokuCheckerProblem {
    public boolean checkIfValid(char[][] sudoku){
        for (int i=0;i<sudoku.length;i++){
            for (int j=0;j<sudoku[i].length;j++){
                if(!valid(sudoku,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] sudoku, int i, int j) {
        return notInRow(sudoku,i) && notInCol(sudoku,j) && notInBox(sudoku,i - (i%3),j-(j%3));
    }

    private boolean notInBox(char[][] sudoku, int i, int j) {
        Set<Character> set = new HashSet<Character>();
        for (int x = 0;x<3;x++){
            for (int y=0;y<3;y++){
                if(set.contains(sudoku[i+x][j+y])){
                    return false;
                }
                if(sudoku[i+x][j+y]!='.'){
                    set.add(sudoku[i+x][j+y]);
                }
            }
        }
        return true;
    }

    private boolean notInCol(char[][] sudoku, int j) {
        Set<Character> set = new HashSet<Character>();
        for (int i=0;i<sudoku.length;i++){
            if(set.contains(sudoku[i][j])){
                return false;
            }
            if(sudoku[i][j] != '.'){
                set.add(sudoku[i][j]);
            }
        }
        return true;
    }

    private boolean notInRow(char[][] sudoku, int i) {
        Set<Character> set = new HashSet<Character>();
        for (int j=0;j<sudoku.length;j++){
            if(set.contains(sudoku[i][j])){
               return false;
            }
            if(sudoku[i][j] != '.'){
                set.add(sudoku[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuCheckerProblem kk = new SudokuCheckerProblem();
        boolean result=kk.checkIfValid(new char[][]{{'5','3','.','.','7','.','.','.','.'},
                                                    {'6','.','.','1','9','5','.','.','.'},
                                                    {'.','9','8','.','.','.','.','6','.'},
                                                    {'8','.','.','.','6','.','.','.','3'},
                                                    {'4','.','.','8','.','3','.','.','1'},
                                                    {'7','.','.','.','2','.','.','.','6'},
                                                    {'.','6','.','.','.','.','2','8','.'},
                                                    {'.','.','.','4','1','9','.','.','5'},
                                                    {'.','.','.','.','8','.','.','7','9'}
        }
               );
        System.out.println(result);
    }
}
