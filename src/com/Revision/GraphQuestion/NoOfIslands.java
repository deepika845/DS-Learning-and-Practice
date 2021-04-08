package com.Revision.GraphQuestion;

public class NoOfIslands {
    public int findNumIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==1 && !visited[i][j]){
                    dfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return  count;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visited) {
        int[] rowchng=new int[]{-1,-1,-1,0,0,+1,+1,+1};
        int[] colChng= new int[]{-1,0,+1,-1,+1,-1,0,+1};
        visited[i][j]=true;
        for (int k=0;k<8;k++){
            if (isSafe(i+rowchng[k],j+colChng[k],visited,grid)){
            dfs(i+rowchng[k],j+colChng[k],grid,visited);}
        }

    }

    private boolean isSafe(int i, int j, boolean[][] visited, int[][] grid) {
        return (i >= 0 && j >= 0 && i<grid.length&& j < grid[i].length  && (grid[i][j] == 1 && !visited[i][j]));
    }

    public static void main(String[] args) {
        NoOfIslands nf= new NoOfIslands();
        System.out.println(nf.findNumIsland(new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } }));

    }
}
