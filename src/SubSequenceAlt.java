import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubSequenceAlt {
    public static ArrayList<String> getSS(String str){
        if(str.length()==0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> mr=new ArrayList<>();
        ArrayList<String> rr=getSS(ros);
        for(int i=0;i<rr.size();i++){
            mr.add(rr.get(i));
            mr.add(ch+rr.get(i));
        }
        return mr;

    }
    public static void main(String[] args) {
        System.out.println(getSS("abcd"));

    }

}
