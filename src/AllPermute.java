import java.util.ArrayList;

public class AllPermute {
    public static ArrayList<String> getPermute(String s){
        if(s.length()==0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        char ch=s.charAt(0);
        String ros=s.substring(1);
        ArrayList<String> mr = new ArrayList<>();
        ArrayList<String> rr = getPermute(ros);
        for(int i=0;i<rr.size();i++){
            String sf=rr.get(i);
            for(int j=0;j<=sf.length();j++){
                String sls=sf.substring(0,j)+ch+sf.substring(j);
                mr.add(sls);
            }
        }
        return mr;
    }
    public static ArrayList<String> getSumDice(int curr,int end){
        if(curr==end){
            ArrayList<String> br= new ArrayList<>();
            br.add("");
            return br;
        }
        if(curr>end){
            ArrayList<String> br =new ArrayList<>();
            return br;
        }
        ArrayList<String> mr = new ArrayList<>();
        for(int dice=1;dice<=6;dice++){
            ArrayList<String> rr=getSumDice(curr+dice,end);
            for(String rrs:rr){
                mr.add(dice+rrs);
            }
        }
        return mr;
    }

    public static void main(String[] args) {
        System.out.println(getSumDice(0,10).size());
    }
}
