public class FindGcd {
    public static int gcdCalc(int a,int b){
        if(b==0)
            return a;
        return gcdCalc(b,(a%b));
    }
    public static void main(String[] args) {
        System.out.println(gcdCalc(15,30));

    }
}
