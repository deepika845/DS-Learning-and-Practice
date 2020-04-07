public class LasIndexRecursion {
    public static int lastIndexCheck(int arr[],int si,int data){
        if(si==arr.length)
            return -1;
        int index=lastIndexCheck(arr,si+1,data);
        if(index==-1){
            if(arr[si]==data)
                return si;
            else{
                return -1;
            }
        }
        else{
            return index;
        }
    }
    public static void main(String[] args) {
    int arr[]={1,2,3,5,7,2,5};
    int jj=lastIndexCheck(arr,0,2);
        System.out.println(jj);
    }
}
