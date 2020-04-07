public class Revision3 {
    public static void printPatern(int n){
        int k=1;
        int row=1;
        while(k<=(2*n-1)){
            //int col=1;
            int space=1;
            while(space<=(n-row)){
                System.out.print("*");
                space+=1;
            }
            int ff=1;
            while(ff<=(2*row-1)){
                System.out.print(" ");
                ff+=1;
            }
            while(space<=(n-row)){
                System.out.print("*");
                space+=1;
            }
            if(k<n){
                row+=1;
            }
            else{
                row-=1;
            }
            k+=1;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printPatern(3);

    }
}
