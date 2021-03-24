package com.deepika.problem.solving.Graphs;

//import sun.jvm.hotspot.debugger.sparc.SPARCThreadContext;

public class HamiltonianCycle {
    int V = 5 ;
    int path[] = new int[V];

    public static void main(String[] args) {
        HamiltonianCycle jj= new HamiltonianCycle();
        int arr[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}};
        
        System.out.println(jj.hasHamCyle(arr));
    }

    private boolean hasHamCyle(int[][] arr) {
       path[0]=0;
       if (containsHamiltCycle(arr,1)){
              return true;
           }
       return false;
    }

    private boolean containsHamiltCycle(int[][] arr, int pos) {

        for (int i=1;i<V;i++){
            if(isSafe(arr,i,pos)){
                path[pos]=i;
                if (containsHamiltCycle(arr,pos+1)){
                    return true;
                }
                path[pos]=-1;
            }
        }
        return false;
    }

    private boolean isSafe(int[][] arr, int i, int pos) {
        if(arr[path[pos-1]][i]==0){
            return false;
        }
        for (int j=0;j<pos;j++){
            if(path[j]==i){
                return false;
            }
        }
        return false;
    }
}
