import java.util.Scanner;

public class RecerseOfNum {
    public static int reverseClick(int m){
        int rev_num=0;
        int place=1;
        while(m>0){
            int rem=m%10;
            m=m/10;
            rev_num=rev_num*10+rem;
            place=place*10;
        }
        return rev_num;
    }
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int d=s.nextInt();
        int ff=reverseClick(d);
        System.out.println(ff);
    }
}
