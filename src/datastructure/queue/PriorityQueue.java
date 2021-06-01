package datastructure.queue;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueue<E> implements QueueInterface<E>{

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10; // 기본 최소 용적 크기

    private int size;  //요소의 개수
    private Object[] array; // 요소를 담을 배열

    //초기 공간 할당 X
    public PriorityQueue() {
        this(null);
    }

    public PriorityQueue(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.size = 0;
        this.array = new Object[DEFAULT_CAPACITY];
    }
    //초기 공간 할당 o
    public PriorityQueue(int capacity){
        this(capacity,null);
    }

    public PriorityQueue(int capacity,Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.size = 0;
        this.array = new Object[capacity];
    }

    private int getParent(int index){
        return index;
    }

    private int getLeftChild(int index){
        return index*2;
    }

    private int getRightChild(int index){
        return index * 2 + 1;
    }

    private void resize(int newCapacity){

        Object[] newArray = new Object[newCapacity]; // 새로운 배열 생성

        // 새 배열에 기존에 있던 배열의 요소들을 모두 복사해준다.
        for(int i = 0; i<= size; i++){
            newArray[i] = array[i];
        }

        /**
         * 현재 배열은 GC 처리를 위해 null로 명확하게 처리한 뒤
         * 새 배열을 array에 연결해준다.
         */

        this.array = null;
        this.array = newArray;



    }

    @Override
    public boolean offer(E value) {

        // 배열 용적이 꽉 차있을 경우 용적을 두 배로 늘려준다.
        if(size+1 == array.length){
            resize(array.length *2);
        }


        siftUp(size +1 ,value);  // 가장 마지막에 추가되는 위치와 넣을 값(타겟)을 넘겨줌
        size++;  // 정상적으로 재배치가 끝나면 사이즈(요소 개수) 증가
        return true;
    }

    /**
     * 상향 선별
     *
     * @param index	추가할 노드의 인덱스
     * @param target	// 재배치 할 노드
     */
    private void siftUp(int index,E target){
        /*
         * comparator가 존재한다면 comparator을 넘겨주고,
         * 아닐경우 Comparable로 비교하도록 분리해준다.
         */
        if(comparator != null){
            siftUpComparator(index,target,comparator);
        }else{
            siftUpComparable(index,target);
        }
    }

    //Comparator을 이용한 sift-up
    @SuppressWarnings("unchecked")
    private void siftUpComparator(int index, E target,Comparator<? super E> comp){

        // root노드보다 클 때 까지만 탐색한다.
        while(index > 1){
            int parent = getParent(index); //삽입 노드의 부모노드 인덱스 구하기
            Object parentVal = array[parent];  //부모노드의 값

            // 타겟 노드 우선순위(값)이 부모노드보다 크면 반복문 종료
            if(comp.compare(target,(E)parentVal) >= 0){
                break;
            }
            /*
             * 부모노드가 타겟노드보다 우선순위가 크므로
             * 현재 삽입 될 위치에 부모노드 값으로 교체해주고
             * 타겟 노드의 위치를 부모노드의 위치로 변경해준다.
             */
            array[index] = parentVal;
            index = parent;
        }
        // 최종적으로 삽입 될 위치에 타겟 노드 요소를 저장해준다.
        array[index] = target;
    }

    // 삽입 할 객체의 Comparable을 이용한 sift-up
    @SuppressWarnings("unchecked")
    private void siftUpComparable(int index,E target){

        /* 타겟노드가 비교 될 수 있도록 한 변수를 만든다. */
        Comparable<? super E> comp = (Comparable<?  super E>) target;



        while(index > 1){
            int parent = getParent(index);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal) >= 0){
                break;
            }
            /*
             * 부모노드가 타겟노드보다 우선순위가 크므로
             * 현재 삽입 될 위치에 부모노드 값으로 교체해주고
             * 타겟 노드의 위치를 부모노드의 위치로 변경해준다.
             */
            array[index] = parentVal;
            index =parent;
        }

        array[index] = comp;


    }

    @Override
    public E poll() {
        if(array[1] == null){
            throw new NoSuchElementException();
        }
        return remove();
    }
    @SuppressWarnings("unchecked")
    public E remove(){
        if(array[1] == null){  // 뽑으려눈 요소(root)가 null일경우 예외를 던지도록 한다.
            throw new NoSuchElementException();
        }

        E result = (E)array[1];   // 삭제된 요소를 반환하기 위한 임시 변수
        E target = (E)array[size];  // 타겟이 될 요소

        array[size] = null;
        size--;
        siftDown(1,target);


        return result;

    }
    /**
    * 하향 선별
    *
    * @param index	삭제할 노드의 인덱스
    * @param target	재배치 할 노드
    */

    private void siftDown(int index,E target){
        if(comparator != null){
            siftUpComparator(index,target,comparator);
        }else{
            siftUpComparable(index,target);
        }
    }

    // Comparator을 이용한 sift-down
    @SuppressWarnings("unchecked")
    private void siftDownComparator(int index, E target, Comparator<? super E> comp) {

        array[index] = null; // 삭제 할 인덱스의 노드를 삭제

        int parent = index; // 삭제 노드부터 시작 할 부모 노드 인덱스를 가리키는 변수
        int child; // 교환 될 자식 인덱스를 가리키는 변수

        // 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
        while ((child = getLeftChild(parent)) <= size){

            int right = getRightChild(parent);
            Object childVal = array[child];
            /*
             * 오른쪽 자식 인덱스가 size를 넘지 않으면서
             * 왼쪽 자식이 오른쪽 자식보다 큰 경우
             * 재배치 할 노드는 작은 자식과 비교해야 하므로 child와 childVal을
             * 오른쪽 자식으로 바꾸어 준다.
             */

            if(right <=  size && comp.compare((E)childVal , (E) array[right]) > 0){
                child = right;
                childVal = array[right];
            }

            // 재배치 할 노드가 자식 노드보다 작을 경우 반복문을 종료
            if(comp.compare(target,(E)childVal) <= 0){
                break;
            }
            /*
             * 현재 부모 인덱스에 자식 노드 값을 대체해주고
             * 부모 인덱스를 자식 인덱스로 교체
             */

            array[parent] = childVal;
            parent = child;
        }
        // 최종적으로 재배치 되는 위치에 타겟이 된 값을 넣어준다.
        array[parent] = target;


        /*
         * 용적 사이즈가 최소 용적보다는 크면서 요소의 개수가 전체 용적의 1/4 미만일 경우
         * 용적을 반으로 줄임 (단, 최소용적보단 커야 함)
         */
        if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }


    }

    @Override
    public E peek() {
        if(array[1] == null ){
            throw new NoSuchElementException();
        }
        return (E)array[1];
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contain(Object value){
        for (int i=1;  i <= size; i++){
            if(array[i].equals(value)){
              return true;
            }
        }
        return false;
    }

    public void clear(){
        for(int i =0; i<= size; i++){
            array[i] = null;
        }

        size= 0;
    }

}
