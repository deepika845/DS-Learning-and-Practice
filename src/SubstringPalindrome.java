import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubstringPalindrome {
    /*public static HashSet<String> palindromeItertor(String str){
        if(str.isEmpty()){
            HashSet<String> br=new HashSet<>();
            return br;}
        HashSet<String> mr = new HashSet<>();
        String kk=str.substring(1);
        HashSet<String> rr = listPalindrome(kk);
        mr.addAll(rr);
        return mr;
    }*/
    public static HashSet<String> listPalindrome(String str)
    {
        if(str.isEmpty()){
            HashSet<String> br = new HashSet<>();
            br.add("");
            return br;
        }
        HashSet<String> mr=new HashSet<>();
        String ros=str.substring(1);
        HashSet<String> rr = listPalindrome(ros);
        if(isPalin(ros)&&(ros.length()>1))
        {
            mr.add(ros);
        }
        mr.addAll(rr);
        return mr;
    }
    public static boolean isPalin(String str){
        if(str.equals( new StringBuffer(str).reverse().toString()))
            return true;
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        //System.out.println(palindromeItertor("ababa"));
    }
}
