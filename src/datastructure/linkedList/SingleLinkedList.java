package datastructure.linkedList;


import java.util.NoSuchElementException;

class Node<E> {
    E data;
    Node<E> next;

    Node(E data){
        this.data = data;
        this.next = next;
    }
}


interface SingleLinkinterface<E>{
    /**
     * 리스트에 요소를 추가합니다.
     *
     * @param value 리스트에 추가할 요소
     * @return 리스트에서 중복을 허용하지 않을 경우에 리스트에 이미 중복되는
     *         요소가 있을 경우 {@code false}를 반환하고, 중복되는 원소가
     *         없을경우 {@code true}를 반환
     */
    boolean add(E value);

    /**
     * 리스트에 요소를 특정 위치에 추가합니다.
     * 특정 위치 및 이후의 요소들은 한 칸씩 뒤로 밀립니다.
     *
     * @param index 리스트에 요소를 추가할 특정 위치 변수
     * @param value 리스트에 추가할 요소
     */
    void add(int index, E value);

    /**
     * 리스트의 index 위치에 있는 요소를 삭제합니다.
     *
     * @return 삭제된 요소를 반환
     */


    E remove(int index);

    /**
     * 리스트에서 특정 요소를 삭제합니다. 동일한 요소가
     * 여러 개일 경우 가장 처음 발견한 요소만 삭제됩니다.
     *
     * @param value 리스트에서 삭제할 요소
     * @return 리스트에 삭제할 요소가 없거나 삭제에 실패할
     *         경우 {@code false}를 반환하고 삭제에 성공할 경우 {@code true}를 반환
     */
    boolean remove(Object value);

    /**
     * 리스트에 있는 특정 위치의 요소를 반환합니다.
     *
     * @param index 리스트에 접근할 위치 변수
     * @return 리스트의 index 위치에 있는 요소 반환
     */
    E get(int index);

    /**
     * 리스트에서 특정 위치에 있는 요소를 새 요소로 대체합니다.
     *
     * @param index 리스트에 접근할 위치 변수
     * @param value 새로 대체할 요소 변수
     */
    void set(int index, E value);

    /**
     * 리스트에 특정 요소가 리스트에 있는지 여부를 확인합니다.
     *
     * @param value 리스트에서 찾을 특정 요소 변수
     * @return 리스트에 특정 요소가 존재할 경우 {@code true}, 존재하지 않을 경우 {@code false}를 반환
     */
    boolean contain(Object value);

    /**
     * 리스트에 특정 요소가 몇 번째 위치에 있는지를 반환합니다.
     *
     * @param value 리스트에서 위치를 찾을 요소 변수
     * @return 리스트에서 처음으로 요소와 일치하는 위치를 반환.
     *         만약 일치하는 요소가 없을경우 -1 을 반환
     */
    int indexOf(Object value);

    /**
     * 리스트에 있는 요소의 개수를 반환합니다.
     *
     * @return 리스트에 있는 요소 개수를 반환
     */
    int size();

    /**
     * 리스트에 요소가 비어있는지를 반환합니다.
     * @return 리스트에 요소가 없을경우 {@code true}, 요소가 있을경우 {@code false}를 반환
     */
    boolean isEmpty();

    /**
     * 리스트에 있는 요소를 모두 삭제합니다.
     */
    public void clear();

}

public class SingleLinkedList<E> implements SingleLinkinterface<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedList(Node<E> head, Node<E> tail, int size) {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index){
        //범위 밖 예외 던지기
        if(index < 0|| index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> x =head; //head가 가리키는 노드부터 시작

        for(int i = 0; i<=index; i++){
            x = x.next;   //탐색
        }
        return x;
    }

    public void addFirst(E value){
        Node<E> newNode = new Node<E>(value);
        newNode.next = head;
        head = newNode;
        size++;

        if(head.next == null){
            tail = head;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return false;
    }

    public void addLast(E value){
        Node<E> newNode = new Node<E>(value);  //새노드 생성

        if(size == 0 ){  //새노드일 경우 첫번째 노드로 삽입
            addFirst(value);
            return;
        }

        /**
         * 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 하고
         * tail이 가리키는 노드를 새 노드로 바꿔준다.
         */
        tail.next = newNode;
        tail = newNode;
        size++;


    }

    @Override
    public void add(int index, E value) {
        if(index <0 || size <= index){
            throw new IndexOutOfBoundsException();
        }

        if (size == 0){
            addFirst(value);
        }

        if (index == size){
            addLast(value);
        }
        //추가하려는 위치 이전의 노드
        Node<E> preNode = search(index -1);


        //추가하려는 위치의 노드
        Node<E> nextNode = preNode.next;

        //추가 하려는 노드
        Node<E> newNode = new Node<E>(value);

        preNode.next = null;
        preNode.next = newNode;
        newNode.next = nextNode;
        size++;
    }

    public E remove(){
        Node<E> headNode = head;

        if(headNode == null){
            throw new NoSuchElementException();
        }

        E element =headNode.data;

        Node<E> nextNode = headNode.next;

        head.data = null;
        head.next = null;

        head = nextNode;
        size--;
        if(size == 0){
            tail = null;
        }
        return  element;
    }
    @Override
    public E remove(int index) {

        if(index == 0){
            return remove();
        }

        if(index <0 || size <= index){
            throw new IndexOutOfBoundsException();

        }
        Node<E> preNode = search(index-1);
        Node<E> removeNode  = preNode.next;
        Node<E> nextNode = removeNode.next;


        E element =removeNode.data;


        preNode.next = nextNode;

        removeNode.next = null;
        removeNode.data = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> preNode = head;
        boolean hasValue =false;
        Node<E> x = head;

        // value 와 일치하는 노드를 찾는다.
        for(; x!= null; x =x.next){
            if (value.equals(x.data)){
                hasValue =true;
                break;
            }
            preNode = x;
        }

        // 만약 삭제하려는 노드가 head라면 기존 remove()를 사용
        if (x.equals(head)){
            remove();
            return true;
        }else if(!hasValue){  //// 일치하는 요소가 없을경우 false 반환
            return false;

        } else {
            // 이전 노드의 링크를 삭제하려는 노드의 다음 노드로 연결
            preNode.next = x.next;

            x.data = null;
            x.next = null;
            size--;
            return true;
        }

    }
    //해당 위치의 요소를 반환
    @Override
    public E get(int index) {
        return search(index).data;
    }

    //교체
    @Override
    public void set(int index, E value) {
        Node<E> replaceNode = search(index);
        replaceNode.data = null;
        replaceNode.data = value;
    }

    @Override
    public boolean contain(Object item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;

        for(Node<E> x = head; x!= null; x = x.next){
            if(value.equals(x.data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
