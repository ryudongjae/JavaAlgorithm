package datastructure.heap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10; // 배열의 기본 및 최소 용적이다. 한마디로 요소를 담을 배열의 크기를 의미한다

    private int size;  //배열에 담긴 요소의 개수
    private Object[] array; // 요소를 담을 배열이다.

    //초기 공간 할당 X
    public Heap(){
        this(null);
    }

    //초기 공간할당 O
    public Heap(int capacity){
        this(capacity,null);

    }

    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public Heap(int capacity,Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;

    }
    //받은 부모노드 인덱스 반환
    private int getParent(int index){
        return index / 2;
    }

    //받은 왼쪽 자식노드 반환
    private int getLeftChild(int index){
        return index * 2;
    }

    //받은 오른쪽 자식 노드 인덱스 값 반환
    private int getRightChild(int index){
        return index * 2 +1;
    }

    private void resize(int newCapacity){

        //새로 만든 배열
        Object [] newArray = new Object[newCapacity];


        //새 배열에 기존에 있던 배열의 요소들을 모두 복사해준다.
        for(int i =1;  i<=size; i++){
            newArray[i] = array[i];
        }
        //GC 처리를 위해 null 로 처리한뒤에 새배열을 연결 해준다.
        this.array = null;
        this.array = newArray;
     }

     public void add(E value){

        //배열이 가득찬 경우 용적을 두배로 늘려준다.
        if(size + 1 == array.length){
            resize(array.length* 2);
        }
        siftUp(size + 1,value);
        size++;
     }

     private void siftUp(int idx,E target){  //idx 는 추가할 노드의 인덱스 ,target 은 재배치 할 노드
        if(comparator != null){
            siftUpComparator(idx,target,comparator);
        }else{
            siftUpComparable(idx,target);
        }
     }
     //comparator 을 이용한 sift - up
    @SuppressWarnings("unchecked")
     private void siftUpComparator(int idx, E target, Comparator<? super E> comparator){
        //root 노드보다 클때 까지만 탐색한다.
        while (idx > 1){
            int parent = getParent(idx);  //삽입노드의 부모노드 인덱스 구하기
            Object parentVal = array[parent];  //부모노드

            //target노드 값이 부모노드 값보다 크면 반복문 종료
            if(comparator.compare(target,(E) parentVal) >= 0){
                break;
            }
        /**부모노드가 타겟노드보다 크므로
        현재 삽입 될 위치에 부모노드 값으로 교체해주고
        타겟 노드의 위치를 부모노드의 위치로 변경해준다.
		 */
        array[idx] = parentVal;
        parent  = idx;
        }

        // 최종적으로 삽입될 위치에 타겟 노드 값을 저장해준다.
        array[idx] = target;

     }

     //삽입 할 객체의 Comparable 을 이용한 sift-up
    @SuppressWarnings("unchecked")
     private void siftUpComparable(int idx,E target){

        //타겟노드가 비교 될 수 있도록 한 변수를 만든다.
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while (idx > 1) {
            int parent = getParent(idx);
            Object parentVal = array[parent];

            //  타겟노드와 부모노드와 비교
            if(comp.compareTo((E)parentVal) >= 0){
                break;
            }

            array[idx] = parentVal;
            idx =parent;
        }

        array[idx]= comp;
     }



     /**
      * add의 경우 맨 마지막 노드에 추가하고 부모노드와 비교하면서 자리를 찾아갔다.
      * 이를 거꾸로 하면 삭제연산의 경우 root에 있는 노드를 삭제하고,
      * 마지막에 위치해있던 노드를 root Node로 가져와 add와는 반대로 자식노드가 재배치하려는 노드보다 크거나 자식노드가 없을 때 까지
      * 자신의 위치를 찾아가면 된다.
      *  */

    @SuppressWarnings("unchecked")
     public E remove(){
         if(array[1] == null){
             throw new NoSuchElementException();
         }

         E result = (E) array[1];  // 삭제된 요소를 반환하기 위한 임시 변수
         E target = (E) array[size];// 타겟이 될 요소

        array[size] = null;  //타겟ㄴ노드를 비운다.

        // 삭제할 노드의 인덱스와 이후 재배치 할 타겟 노드를 넘겨준다.
        siftDown(1,target);

        return result;
     }

    private void siftDown(int idx, E target) {
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(int idx,E target,Comparator<? super E> comp){
        array[idx] = null; //삭제 할 노드의 인덱스 삭제
        size--;

        int child;
        int parent = idx;

        // 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
        while ((child = getLeftChild(parent)) <= size){

            int right = getRightChild(parent); //오른쪽 자식 인덱스

            Object childVal = array[child];  //왼쪽 자식의 값

            /*
             *  오른쪽 자식 인덱스가 size를 넘지 않으면서
             *  왼쪽 자식이 오른쪽 자식보다 큰 경우
             *  재배치 할 노드는 작은 자식과 비교해야하므로 child와 childVal을
             *  오른쪽 자식으로 바꿔준다.
             */

            if(right<= size && comp.compare((E)childVal,(E)array[right])>0){
                child = right;
                childVal =array[child];
            }
            // 재배치 할 노드가 자식 노드보다 작을경우 반복문을 종료한다.
            if(comp.compare(target,(E)childVal) <= 0){
                break;
            }
            /*
             *  현재 부모 인덱스에 자식 노드 값을 대체해주고
             *  부모 인덱스를 자식 인덱스로 교체
             */

            array[parent] = childVal;
            parent = child;

        }
        // 최종적으로 재배치 되는 위치에 타겟이 된 값을 넣어준다.
        array[parent] = target;

        /*
         *  용적의 사이즈가 최소 용적보다는 크면서 요소의 개수가 전체 용적의 1/4일경우
         *  용적을 반으로 줄임(단, 최소용적보단 커야함)
         */
        if(array.length > DEFAULT_CAPACITY &&size < array.length/4){
            resize(Math.max(DEFAULT_CAPACITY,array.length/2));
        }


    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int idx, E target){

        Comparable<? super E> comp =(Comparable<? super E>) target;

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);

            Object childVal = array[child];

            if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if(comp.compareTo((E) childVal) <= 0){
                break;
            }
            array[parent] = childVal;
            parent = child;

        }
        array[parent] = comp;

        if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

    }

    public int size() {
        return this.size;
    }

}
