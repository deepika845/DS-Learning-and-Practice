package com.LeetCode;

public class Backtracking {
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int res=0;
        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid1[i].length;j++){
                if(grid1[i][j]==1&&grid2[i][j]==1){
                    res+=dfs(grid1,grid2,i,j,grid1.length,grid2[i].length);
                }
            }
        }
        return res;
    }
    public static int dfs(int[][] grid1,int[][] grid2,int sr,int sc,int dr,int dc){
        int res=1;
        if(sr<0||sr==dr||sc<0||sc==dc||grid1[sr][sc]==0||grid2[sr][sc]==0){
            return 1;
        }
        grid2[sr][sc]=0;
        res=res&dfs(grid1,grid2,sr+1,sc,dr,dc);
        res=res&dfs(grid1,grid2,sr-1,sc,dr,dc);
        res=res&dfs(grid1,grid2,sr,sc-1,dr,dc);
        res=res&dfs(grid1,grid2,sr,sc+1,dr,dc);
        return grid1[sr][sc]&res;
    }

    public static void main(String[] args) {
        countSubIslands(new int[][]
                        {{1,1,1,0,0},
                         {0,1,1,1,1},
                         {0,0,0,0,0},
                         {1,0,0,0,0},
                         {1,1,0,1,1}},
                    new int[][]
                            {   {1,1,1,0,0},
                                {0,0,1,1,1},
                                {0,1,0,0,0},
                                {1,0,1,1,0},
                                {0,1,0,1,0}});
    }
}
