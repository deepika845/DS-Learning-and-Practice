package com.deepika.problem.solving.Strings;

public class CountNumNeedleHay {
    public static int findCount(char[][] grid,String needle,int row,int col,int row_Max,int col_Max,int curr){
        int numTimes=0;
        if (row>=0 && row<=row_Max && col>=0 && col<=col_Max && grid[row][col]==needle.charAt(curr)){

            curr+=1;
            char ckh= grid[row][col];
            grid[row][col]='*';
            if (curr==needle.length()){
                return 1;
            }
            numTimes+=findCount(grid,needle,row+1,col,row_Max,col_Max,curr);
            numTimes+=findCount(grid,needle,row,col+1,row_Max,col_Max,curr);
            numTimes+=findCount(grid,needle,row-1,col,row_Max,col_Max,curr);
            numTimes+=findCount(grid,needle,row,col-1,row_Max,col_Max,curr);
            grid[row][col]=ckh;

        }
        return numTimes;

    }
    public static int findCount(char[][] chh,String word){
        int found=0;
        for (int i=0;i<chh.length;i++){
            for (int j=0;j<chh[i].length;j++){
                found+=findCount(chh,word,i,j,chh.length-1,chh[i].length-1,0);
            }
        }
        return found;
    }

    public static void main(String[] args) {

        System.out.println(findCount(new  char[][]{
                {'D','D','D','G','D','D'},
                {'B','B','D','E','B','S'},
                {'B','S','K','E','B','K'},
                {'D','D','D','D','D','E'},
                {'D','D','D','D','D','E'},
                {'D','D','D','D','D','G'}
        },"GEEKS"));

    }

}
