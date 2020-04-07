import java.util.*;

public class Skiping {
    public static void main(String args[]) {
        skiphit("","hihihit");
    }
    public static void skiphit(String processed, String unprocessed) {
        if(unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch=unprocessed.charAt(0);
        if(unprocessed.length() >= 3 && "hit".equals(unprocessed.substring(0,3))) {
            skiphit(processed,unprocessed.substring(3));

        } else
        {
            skiphit(processed+ch,unprocessed.substring(1));
        }

    }
}