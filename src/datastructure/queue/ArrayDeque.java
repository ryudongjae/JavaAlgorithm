package datastructure.queue;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements QueueInterface<E>{

    private static final int DEFAULT_CAPACITY = 64;

    private Object[] array;  //요소를 담을 배열
    private int size;  //요소 개수

    private  int front;  //시작 인덱스를 가리키는 변수
    private int rear;//마지막 요소 인덱스를 가리키는 변수

    //생성자 1(초기 용적 할당 X)
    public ArrayDeque() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }
    //생성자 2(초기 용적을 할당 O)
    public ArrayDeque(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapacity){

        int arrayCapacity  = array.length; //현재 용적 크기

        Object[] newArray = new Object[newCapacity]; //용적을 변경한 배열
        /*
         * i = new array index
         * j = original array
         * index 요소 개수(size)만큼 새 배열에 값 복사
         */

        for (int i = 1,j = front+1; i<= size; i++,j++){
            newArray[i] = array[j%arrayCapacity];
        }
        this.array = null;
        this.array = newArray;

        front = 0;
        rear = size;

    }

    @Override
    public boolean offer(E data) {
        return offerLast(data);
    }

    public boolean offerLast(E data){
        if((rear+1)%array.length == front){
            resize(array.length * 2);
            //용적이 가득 찼을때는 용적을 두배로 늘려준다.
        }

        rear = (rear + 1)% array.length;
        //rear을  rear의 다음위치로 늘려준다.

        array[rear] =data;
        size++;  //size 1증가

        return true;
    }

    public  boolean offerFirst(E data){
        if((front-1 + array.length)%array.length == rear){
            resize(array.length *2);
        }

        array[front] = data;
        //front위치는 빈 공간이기 때문에 추가 해준 뒤 front 값을 갱신한다.
        front = (front -1+array.length)%array.length;
        size++;
        return true;
    }
    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst(){
        if(size == 0){ //삭제할 요소가 없을 경우 null을 반환
            return  null;
        }

        front = (front + 1)% array.length;
        /**
         * 우리가 push하여 받아들이는 데이터 타입은 유일하게 E 타입만 존재한다.
         * 그렇기 때문에 형 안정성이 보장된다.
         * 한마디로 ClassCastException이 뜨지 않으니 이 경고들을 무시하겠다는 것이
         * @SuppressWarnings("unchecked") 이다.*/
        @SuppressWarnings("unchecked")
        E data = (E) array[front];

        array[front] =null; //해당 front 데이터 삭제
        size --; //사이즈 감소

        //용적이 최소 크기보다 크고 요소 개수가 1/4 미만일 경우
        if(array.length > DEFAULT_CAPACITY && size<(array.length/4)){
            //아무리 작아도 최소 용적 미만으로 줄이지는 않도록 한다.
            resize(Math.max(DEFAULT_CAPACITY,array.length / 2));
        }

        return data;
    }

    public E remove(){
        return removeFirst();
    }

    public E removeFirst(){
        E data = pollFirst();

        if(data == null){
            throw new NoSuchElementException();
        }

        return data;
    }

    public E pollLast(){
        if(size == 0){ //삭제할 요소가 없을 경우 null을 반환한다.
            return null;
        }

        @SuppressWarnings("unchecked")
        E data = (E)array[rear];  //반환할 데이터 임시 저장

        array[rear] = null;

        rear = (rear -1 +array.length)% array.length;
        //front를 한 칸 옮긴다.
        size--; //사이즈 감소

        if(array.length > DEFAULT_CAPACITY && size <(array.length/4)){
            resize(Math.max(DEFAULT_CAPACITY,array.length/2));

        }

        return data;
    }

    public E removeLast(){
        E data = pollLast();

        if(data == null){
            throw new NoSuchElementException();
        }
        return  data;
    }
    @Override
    public E peek() {
        return peekFirst();
    }

    public E peekFirst(){
        if(size ==0){
            return  null;
        }
        @SuppressWarnings("unchecked")
        E data = (E)array[(front + 1)% array.length];
        return data;
    }

    public E peekLast(){
        if(size == 0){
            return null;
        }
        @SuppressWarnings("unchecked")
        E data = (E)array[(rear)];
        return data;
    }

    public E element(){
        return getFirst();
    }

    public E getFirst() {
        E data = peek();
        if(data == null){
            throw new NoSuchElementException();
        }

        return data;


    }

    public E getLast() {
        E data = peekLast();
        if (data == null) {
            throw new NoSuchElementException();
        }

        return data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;

    }

    public boolean contain(Object value){

        int start = (front +1) % array.length;


        for (int i = 0, idx =start;  i<size; i++,idx =(idx +1)% array.length){
            if(array[idx].equals(value)){
                return true;
            }
        }

        return false;
    }
    public void clear(){
        for(int i = 0; i< array.length; i++){
            array[i] = null;
        }

        front = rear =size =0;
    }
}
