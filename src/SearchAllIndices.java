public class SearchAllIndices {
    public static int[] allIndicesSearch(int arr[],int si,int data,int count){
        if(si==arr.length)
        {
            int base[]=new int[count];
            return base;
        }
        int[] indices = null;
        if(arr[si]==data){
            indices=allIndicesSearch(arr,si+1,data,count+1);
        }
        else{
            indices=allIndicesSearch(arr,si+1,data,count);
        }
        if(arr[si]==data){
            indices[count]=si;
        }
        return indices;
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,5,7,4,6};
        int arr1[]=allIndicesSearch(arr,0,4,0);
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+",");
        }
    }
}
