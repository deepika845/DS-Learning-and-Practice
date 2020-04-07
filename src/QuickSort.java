import java.util.Arrays;
public class QuickSort {
public static int partition(int arr[],int start,int end){
    int pivot=arr[start];
    int i=start;
    int j=end;
    while(i<j){
        do{
            i++;
        }while(arr[i]<=pivot);
        do{
            j--;
        }while(arr[j]>pivot);
        if(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    int temp=arr[start];
    arr[start]=arr[j];
    arr[j]=temp;
    return j;
}
public static void quickSort(int arr[],int l,int m){
    if(l<m){
        int j= partition(arr,l,m);
        quickSort(arr,l,j-1);
        quickSort(arr,j+1,m);
    }
}

    public static void main(String[] args) {
        int arr[]={2,1,5,3,6};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }



}