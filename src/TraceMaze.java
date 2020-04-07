import java.util.ArrayList;

public class TraceMaze {
    public static ArrayList<String> traceTheMaze(int cr,int cc,int er,int ec){
        if(cr==er && cc==ec){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if(cc>ec || cr>er){
            ArrayList<String> br = new ArrayList<>();
            return br;
        }
        ArrayList<String> mr = new ArrayList<>();

        ArrayList<String> rrh = traceTheMaze(cr+1,cc,er,ec);
        for(String rrhs: rrh){
          mr.add("H"+rrhs);
        }
        ArrayList<String> rrv=traceTheMaze(cr,cc+1,er,ec);
        for(String rrvs:rrv){
            mr.add("V"+rrvs);
        }
        return mr;

    }

    public static void main(String[] args) {
        System.out.println(traceTheMaze(0,0,2,2));
    }
}
