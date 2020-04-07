public class NthFibonacci {
    public static int nthFibonacci(int f){
        if(f<=1){
            return f;
        }
        return(nthFibonacci(f-1)+nthFibonacci(f-2));
    }
    public static void main(String[] args) {
        System.out.print(nthFibonacci(4));
    }
}
