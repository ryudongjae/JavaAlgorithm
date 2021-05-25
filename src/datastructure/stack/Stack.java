package datastructure.stack;

interface StackInterface {
    boolean isFull();
    boolean isEmpty();
    void push(char data);
    char pop();
    char peek();
    void clear();
}
public class Stack implements StackInterface {
    private int top;
    private int stackSize;
    private char stackArr[];

    public Stack(int stackSize) {
        this.top = -1;  //포인터 초기화
        this.stackSize = stackSize;  //스택사이즈 설정
        this.stackArr = new char[stackSize];  //스택 배열 생성
    }

    @Override
    public boolean isFull() {
        return (top == this.stackSize -1);
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public void push(char data) {
        if(isFull()){
            System.out.println("stack is full!");
        }else{
            stackArr[++top] = data;
            System.out.println("insert data : " + data);
        }
    }

    @Override
    public char pop() {
        if(isEmpty()){
            System.out.println("stack is empty!");
            return 0;
        }else{
            System.out.println("pop element :" + stackArr[top]);
            return stackArr[top--];
        }
    }

    @Override
    public char peek() {
        if(isEmpty()){
            System.out.println("stack is empty");
            return 0;
        }else{
            System.out.println("Peek data : " + stackArr[top]);
            return stackArr[top];
        }
    }

    @Override
    public void clear() {
        if(isEmpty()){
            System.out.println("stack is empty !");
        }else{
            top = -1;
            stackArr = new char[this.stackSize];
            System.out.println("stack is clear");

        }
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("stack is empty!");
        }else{
            System.out.print("print data : ");
            for(int i = 0; i<= top; i++){
                System.out.print(stackArr[i]);

            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int stackSize = 5;
        Stack arrStack = new Stack(stackSize);

        arrStack.push('A');
        arrStack.printStack();

        arrStack.push('B');
        arrStack.printStack();

        arrStack.push('C');
        arrStack.printStack();

        arrStack.pop();
        arrStack.printStack();

        arrStack.pop();
        arrStack.printStack();

        arrStack.peek();
        arrStack.printStack();

        arrStack.clear();
        arrStack.printStack();
    }
}
