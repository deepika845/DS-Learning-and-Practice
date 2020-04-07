public class IncreasingDecreasing {
    public static void printDesire(int n){
        if(n==0)
            return ;
        System.out.println(n-1);
        printDesire(n-2);
        System.out.println(n);
    }

    public static void main(String[] args) {
        printDesire(6);
    }
}
