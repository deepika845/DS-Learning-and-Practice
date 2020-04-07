import java.util.Arrays;

public class StackDemo {
    protected int[] data;
    protected int top;
    protected int Default_Size=10;
    public StackDemo(){
        this.data=new int[Default_Size];
        this.top=0;
    }
    public void push(int element){
        if (isFull()) {
            return;
        }
        data[top++]=element;
    }
    public boolean isFull(){
        return top==data.length;
    }
    public int pop(int element){

        int temp=data[top-1];
        top--;
        return temp;
    }
    public void printArray(){
        System.out.println(Arrays.toString(data));
    }

}
