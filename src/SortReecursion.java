public class SortReecursion {
    public static void checkSort(int arr[],int i,int j){
        if(j==arr.length-1){
            System.out.println("Array is Sorted");
            return;
        }
        else{
            if(arr[j]>arr[i]){
            checkSort(arr,j,j+1);}
            else {
                System.out.println("Array is unsorted");
                return;
            }
        }
    }
    public static void main(String[] args) {
        checkSort(new int[]{1,2,3,4,5,6},0,1);

    }
}
