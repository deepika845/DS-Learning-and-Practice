public class Patternff {
    public static void printpattern(int n){
        int row=1;
        while(row<=n){
            int k=1;
            int col=1;
            while(k<=2*n-1){
                if(col<=row){
                System.out.print(col);}
                else{
                    System.out.print(" ");
                }
                if(k<n){
                    col+=1;
                }
                else{
                    col-=1;
                }
                k+=1;
            }
            row+=1;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printpattern(5);
    }

}
