public class PrintPrime {
    public static void printPrime(int n){
        System.out.println(2);
        for(int i=3;i<=n;i++){
            int j=0;
            for(j=2;j<i;j++){
                if(i%j==0){
                    break;
                }
            }
            if(i==j){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        printPrime(7);

    }
}
