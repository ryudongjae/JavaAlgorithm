package datastructure.queue;

class Node<E>{
    E data;
    Node<E> next;
    Node<E> prev;

    Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class LinkedListDeque<E>  implements queueInterface<E>{

    private Node<E> head;  // 가장 앞에 있는 노드를 가리키는 변수
    private Node<E> tail;  // 가장 뒤에 있는 노드를 가리키는 변수
    private int size;  // 요소(노드)의 개수

    public LinkedListDeque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public boolean offerFirst(E value){
        Node<E> newNode = new Node<E>(value);  //새노드 생성
        newNode.next =head;   // 새 노드의 다음 노드로 head 노드를 연결

        /**
         * head가 null이 아닐 경우에만 기존 head노드의 prev 변수가
         * 새 노드를 가리키도록 한다.
         * 이유는 기존 head노드가 없는 경우(null)는 데이터가
         * 아무 것도 없던 상태였으므로 head.prev를 하면 잘못된 참조가 된다.
         */

        if(head != null){
            head.prev = newNode;
        }

        head = newNode;  // head가 가리키는 노드가 새 노드를 가리키도록 한다.
        size++;
        /**
         * 다음에 가리킬 노드가 없는 경우(=데이터가 새 노드밖에 없는 경우 = 이전의 head가 null인경우)
         * 데이터가 한 개(새 노드)밖에 없으므로 새 노드는 처음 시작노드이자
         * 마지막 노드다. 즉 tail = head 다.
         */

        if(head.next ==null){
            tail = head;
        }

        return  true;

    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(char data) {

    }

    @Override
    public char dequeue() {
        return 0;
    }

    @Override
    public char peek() {
        return 0;
    }

    @Override
    public void clear() {

    }
}
