
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueUsingLL<T> {
    
    private Node<T> front;
    private Node<T> rear;
    int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    //size 0(1)
    public int size(){
        return size;
    }

    //isEmpty 0(1)
    public boolean isEmpty(){
        return size == 0;
    }

    //enqueue 0(1)
    public void enqueue(T elem){
        Node<T> newNode = new Node<>(elem);
        size++;
        if(rear == null){
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode; //(or) rear = rear.next
        }
    }

    //front 0(1)
    public T front(){
        if (front == null) {
            System.out.println("Queue is empty");
            return null; 
        }
        return front.data;
    }

    //dequeue 0(1)
    public T dequeue(){
        if (front == null) {
            System.out.println("Queue is empty");
            return null; 
        }
        T temp = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        size--;
        return temp;
    }


    public static void main(String[] args) {
        QueueUsingLL<Integer> q = new QueueUsingLL<>();
        
        int arr[] = {10,20,30,40,50};
        for(int elem : arr){
            q.enqueue(elem);
        }

        //q.dequeue();

        while (!q.isEmpty()) {
            System.out.println(q.front());
            q.dequeue();
        }
    }
}
