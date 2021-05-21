package datastructure.heap;

import java.util.Comparator;

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

     private void siftUpComparable(int idx,E target){

     }
}
