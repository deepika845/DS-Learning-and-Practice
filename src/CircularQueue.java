public class CircularQueue {
    int arr[];
    int default_Size;
    int front;
    int end;
    int size;

    CircularQueue() {
        default_Size = 10;
        front = 0;
        end = 0;
        size = 0;
        arr=new int[default_Size];
    }

    public void enqueue(int j) {
        if (size == arr.length)
            System.out.println("Queue is full");
        arr[end++] = j;
        end %= arr.length;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int temp = arr[front++];
        front = front % arr.length;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[(front + i) % arr.length]);
        }
    }

    public static void main(String[] args) {
    CircularQueue dd= new CircularQueue();
    for(int i=1;i<11;i++){
        dd.enqueue(i);
    }
    dd.dequeue();
    dd.enqueue(12);
    dd.display();
    }
}