public class RemoveDuplicates {
    public static StringBuilder removeDuplicates(String str){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<str.length();i++){

            int index=-1;
            int count=1;
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(j)==str.charAt(i)){
                    index=j;
                    count+=1;
                }
                else{
                    break;
                }
            }
            if(index==-1){
                sb.append(str.charAt(i));
            }
            else{
                sb.append(str.charAt(index));
                i=index;

            }
        }
        return sb;
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates("aabbaccddff"));
    }
}
