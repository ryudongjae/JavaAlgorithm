package datastructure.queue;

interface queueInterface<E>{
    boolean isFull();
    boolean isEmpty();
    void enqueue(char data);
    char dequeue();
    char peek();
    void clear();


}
public class Queue implements queueInterface {

    private int front;
    private int rear;
    private int queueSize;
    private char queueArr[];


    public Queue(int queueSize) {
        front = -1;  //front,rear 초기화
        rear = -1;
        this.queueSize = queueSize;  //큐 사이즈 생성
        queueArr = new char[this.queueSize]; //큐 배열 생성
    }

    @Override
    public boolean isFull() {
        return (rear == queueSize - 1);
    }

    @Override
    public boolean isEmpty() {
        if (front == rear) {
            front = -1;
            rear = -1;
        }

        return (front == rear);
    }

    @Override
    public void enqueue(char data) {
        if (isFull()) {
            System.out.println("queue is full!");
        } else {
            queueArr[++rear] = data;
            System.out.println("Insert data : " + data);
        }
    }

    @Override
    public char dequeue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return 0;
        } else {
            System.out.println("Deleted data : " + queueArr[front + 1]);
            front = (front + 1) % this.queueSize;
            return queueArr[front];
        }
    }

    @Override
    public char peek() {
        if(isEmpty()) {
            System.out.println("queue is empty!");
            return 0;
        }else{
            System.out.println("Peek data : " + queueArr[front +1]);
            return queueArr[front + 1];
        }
    }

    @Override
    public void clear() {
        if(isEmpty()){
            System.out.println("queue is empty");
        }else{
            front = -1;
            rear = -1;
            queueArr = new char[this.queueSize];
            System.out.println("clear");
        }
    }
    public void printQueue(){
        if (isEmpty()){
            System.out.println("queue is empty!");
        }else{
            System.out.print("print element : ");
            for(int i = front +1; i<=rear; i++){
                System.out.print(queueArr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int queuesize = 3;
        Queue queue = new Queue(queuesize);

        queue.enqueue('1');
        queue.printQueue();

        queue.enqueue('2');
        queue.printQueue();

        queue.enqueue('3');
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();


        queue.peek();

        queue.enqueue('3');
        queue.printQueue();
        queue.clear();





    }
}
