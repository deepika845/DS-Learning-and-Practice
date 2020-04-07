public class OneDPermutation {
    static int count=0;
    public static void main(String[] args) {
        boolean[] nQueens=new boolean[4];
        permutePrint(nQueens,0,2,"",-1);
    }
    public static void permutePrint(boolean[] nQueens,int tqps,int tq,String ans,int lastbox){
        if(tqps==tq){
            count++;
            System.out.println(count+"."+ans);
            return;
        }
        for (int i=lastbox+1;i<nQueens.length;i++){
            if(nQueens[i]==false){
                nQueens[i]=true;
                permutePrint(nQueens,tqps+1,tq,ans+"q"+tqps+"q"+i+" ",i);
                nQueens[i]=false;
            }
        }
    }
}
