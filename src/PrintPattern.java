public class PrintPattern{
    public static void maff(int n){
        int row=1;
        //int i=1;
        while(row<=n){
            int col=1;
            while(col<=row){
                //System.out.print(i+" ");
                if(col==1||col==row){
                    System.out.print(row+" ");
                }
                else{
                    System.out.print(0+" ");
                }
                col+=1;
                //i+=1;
            }
            System.out.println();
            row+=1;
        }
    }
    public static void main(String[] args) {
        maff(5);
    }
}
