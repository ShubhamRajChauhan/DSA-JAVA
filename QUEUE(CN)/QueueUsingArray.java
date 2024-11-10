
public class QueueUsingArray {
    private int data[];
    private int front; //index of element at the front of the queue
    private int rear; //index of element at the rear of the queue
    private int size;

    public QueueUsingArray() {
        data = new int[5];
        front = -1;
        rear = -1;
    }
    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    //size
    public int size() {
        return size;
    }

    //isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    //enqueue
    public void enqueue(int elem) {
        if(size == data.length){
            System.out.println("Queue is full");
            return;
        }
        if(size == 0){
            front = 0;
        }
        rear++;
        data[rear] = elem;
        size++;
    }

    //front
    public int front() {
        if(size == 0){
            System.out.println("Queue is empty");
            return -1; 
        }
        return data[front];
    }

    //dequeue
    public int dequeue() {
        if(size == 0){
            System.out.println("Queue is empty");
            return -1; 
        }
        int temp = data[front];
        front++;
        size--;
        if(size == 0){
            front = -1;
            rear = -1;
        }
        return temp;
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);
        // q.enqueue(10);
        // q.enqueue(20);
        // q.enqueue(30);
        // q.enqueue(40);

        //or
        int arr[] = {10,20,30,40};
        for(int elem : arr){
            q.enqueue(elem);
        }

        while (!q.isEmpty()) {
            System.out.println(q.front());
            q.dequeue();
        }
    }
}
