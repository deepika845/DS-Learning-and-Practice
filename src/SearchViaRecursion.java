public class SearchViaRecursion {
    public static int linearRecursion(int arr[],int si,int data){
        if(si==arr.length)
            return -1;
        if(arr[si]==data)
            return si;
        return linearRecursion(arr,si+1,data);
    }
    public static void main(String[] args) {
        int arr[]={0,5,2,5,4,3,7,5};
        int k =linearRecursion(arr,0,5);
        System.out.println(k);
    }
}
