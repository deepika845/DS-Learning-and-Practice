import java.util.*;

public class SusbstringPalindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        pallinSubstring(str);
    }

    public static void pallinSubstring(String line) {
        for(int i = 0; i < line.length();i++){

            //Check for odd length
            int left = i;
            int right = i;
            while(left >= 0 && right < line.length()){
                if(line.charAt(left--) == line.charAt(right++)){
                    System.out.println(line.substring(left+1, right));
                }else{
                    break;
                }
            }

            //Check for even length
            left = i;
            right = i+1;
            while(left >= 0 && right < line.length()){
                if(line.charAt(left--) == line.charAt(right++)){
                    System.out.println(line.substring(left+1, right));
                }else{
                    break;
                }
            }
        }

    }
}