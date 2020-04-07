import java.util.Arrays;

public class SeearchAllIndicesData {
    public static int[] searchAllInddex(int arr[],int si,int data,int count){
        if(si==arr.length){
            int base[] = new int[count];
            return base;
        }
        int indices[]=null;
        if(arr[si]==data){
            indices=searchAllInddex(arr,si+1,data,count+1);
        }
        else{
            indices=searchAllInddex(arr,si+1,data,count);
        }
        if(arr[si]==data){
            indices[count]=si;
        }
        return indices;
    }

    public static void main(String[] args) {
        int ff[]=searchAllInddex(new int[]{1,2,3,4,5,3,6,3},0,3,0);
        System.out.println(Arrays.toString(ff));
    }
}
