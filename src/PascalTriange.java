public class PascalTriange {
    public static void printPascal(int n){
        int row=1;
        while(row<=n){
            int space=1;
            while(space<=(n-row)){
                System.out.print(" ");
                space+=1;
            }
            int k=1;
            int col=1;
            while(k<=2*row-1){
                System.out.print(col);
                if(k<row){
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
        printPascal(5);
    }
}
