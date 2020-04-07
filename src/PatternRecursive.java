public class PatternRecursive {
    public static void patternMethod(int n,int row,int col) {
        if(row==0){
            return;
        }
        if(col>0 && col<=row){
            System.out.print("*");
            patternMethod(n,row,col-1);
        }
        else{
            System.out.println();
            patternMethod(n,row-1,row-1);
        }

    }

    public static void main(String[] args) {
        patternMethod(5,5,5);
    }
}
