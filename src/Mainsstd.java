import java.util.Scanner;

public class Mainsstd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        oddPallinSubstring(str,0,0,0);
        evenPallinSubstring(str, 0, 0, 1);
    }

    private static void evenPallinSubstring(String line, int index, int left, int right) {
        if (index == line.length()-1){
            return;
        }

        if (line.charAt(left) == line.charAt(right)){
            System.out.println(line.substring(left,right+1));
            if (left > 0 && right < line.length()-1){
                evenPallinSubstring(line, index, left-1, right+1);
            }else {
                evenPallinSubstring(line, index+1, index+1, index+2);
            }
        }else {
            evenPallinSubstring(line, index + 1, index + 1, index + 2);
        }
    }

    public static void oddPallinSubstring(String line, int index, int left, int right) {
        if (index == line.length()){
            return;
        }

        if (line.charAt(left) == line.charAt(right)) {
            System.out.println(line.substring(left, right + 1));
            if (left > 0 && right < line.length() - 1) {
                oddPallinSubstring(line, index, left - 1, right + 1);
            }else {
                oddPallinSubstring(line, index + 1, index + 1, index + 1);
            }
        }else {
            oddPallinSubstring(line, index + 1, index + 1, index + 1);
        }
    }
}
