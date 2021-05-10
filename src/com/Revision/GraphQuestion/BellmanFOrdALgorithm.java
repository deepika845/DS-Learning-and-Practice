package com.Revision.GraphQuestion;

public class BellmanFOrdALgorithm {
    int v;
    int e;
    Edge[] edges;
    static class Edge{
        int first;
        int second;
        int weight;
        Edge(int first,int second,int weight){
            this.first=first;
            this.second=second;
            this.weight=weight;
        }
    }

    public boolean negativeCycleExists(){
        int []distMaintained= new int[v];
        for (int i=1;i<v;i++){
            distMaintained[i]=Integer.MAX_VALUE;
        }
        for (int i=0;i<v-1;i++){
            for (int j=0;j<e;j++){
                if (distMaintained[edges[j].first]!=Integer.MAX_VALUE && distMaintained[edges[j].second]>(distMaintained[edges[j].first]+edges[j].weight)){
                    distMaintained[edges[j].second]=(distMaintained[edges[j].first]+edges[j].weight);
                }
            }
        }
        for (int j=0;j<e;j++){
            if (distMaintained[edges[j].first]!=Integer.MAX_VALUE && distMaintained[edges[j].second]>(distMaintained[edges[j].first]+edges[j].weight)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        BellmanFOrdALgorithm btd= new BellmanFOrdALgorithm();
        btd.v=4;
        btd.e=4;
        Edge[] allEdges= new Edge[4];
        allEdges[0]=new Edge(0,1,1);
        allEdges[1]=new Edge(1,2,-1);
        allEdges[2]=new Edge(2,3,-1);
        allEdges[3]=new Edge(3,0,-1);
        btd.edges=allEdges;
        System.out.println( btd.negativeCycleExists());
    }
}
