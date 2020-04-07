import java.util.ArrayList;

public class SubSequenceCrux {
    public static ArrayList<String> getSubSequence(String s){
        if(s.length()==0){
            ArrayList<String> br = new ArrayList<String>();
            br.add("");
            return br;
        }
        char ch=s.charAt(0);
        String ros=s.substring(1);
        ArrayList<String> myResult =new ArrayList<>();
        ArrayList<String> recResult=getSubSequence(ros);
        for(int i=0;i<recResult.size();i++){
            myResult.add(recResult.get(i));
            myResult.add(ch+recResult.get(i));
        }
        return myResult;
    }

    public static void main(String[] args) {
        System.out.println(getSubSequence("abc"));
    }
}
