package com.Revision.BackTracking;

public class NumIslands {
    public static int numIslands(char[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;i<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    res=res+1;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }
    public static void dfs(int i,int j,char[][] grid){
        if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]=='*'){
            return;
        }
        if(grid[i][j]!='1'){
            return;
        }
        grid[i][j]='*';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);

    }

    public static void main(String[] args) {
      numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
    }
}
