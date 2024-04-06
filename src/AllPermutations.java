import java.util.ArrayList;
public class AllPermutations {
    public static ArrayList<String> getPermute(String str){
        if(str.length()==0)
            
        {
            ArrayList<String> kk = new ArrayList<>();
            kk.add("");
            return kk;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> rr = getPermute(ros);
        ArrayList<String> mr = new ArrayList<>();
        for(String rrs : rr){
            for(int i=0;i<=rrs.length();i++){
                String val=rrs.substring(0,i)+ch+rrs.substring(i);
                mr.add(val);
            }
        }
        return mr;
    }
    public static void main(String[] args)
    {

        System.out.println(getPermute("abcd"));
    }
}
