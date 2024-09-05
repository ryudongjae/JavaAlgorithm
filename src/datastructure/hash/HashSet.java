package datastructure.hash;

class Node<E>{

    //hash 값과 key값은 변하지 않기 때문에 final로 선언한다.
    final int hash;
    final E key;
    Node<E> next;

    public Node(int hash, E key, Node<E> next) {
        this.hash = hash;
        this.key = key;
        this.next = next;
    }
}

public class HashSet<E> implements Set<E>{

    // 최소 기본 용적이며 2^n 꼴 형태가 좋다.
    private final static  int DEFAULT_CAPCITY = 1<< 4;

    // 3/4 이상 채워질 경우 resize하기 위함
    private final static float LOAD_FACTOR= 0.75F;

    Node<E> [] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashSet() {
        table =  (Node<E>[]) new Node[DEFAULT_CAPCITY];
        size = 0;
    }

    // 보조 해시 함수 (상속 방지를 위해 private static final 선언)
    private static final int hash(Object key){
        int hash;
        if(key == null){
            return 0;
        }else{
            // hashCode()의 경우 음수가 나올 수 있으므로 절댓값을 통해 양수로 변환해준다.
            return Math.abs(hash = key.hashCode())^(hash >>> 16);
        }
    }

    @Override
    public boolean add(E key) {
        // key에 대해 만들어두었던 보조해시함수의 값과 key(데이터)를 보낸다
        return add(hash(key),key) == null;
    }

    private E  add(int hash, E key){
        int idx = hash % table.length;
        //인덱스가 비어있을경우 새로운 노드 생성
        if(table[idx] ==null){
            table[idx] = new Node<E>(hash,key, null);
        }
        /*
         *  talbe[idx]에 요소가 이미 존재할 경우(==해시충돌)
         *
         *  두 가지 경우의 수가 존재
         *  1. 객체가 같은 경우
         *  2. 객체는 같지 않으나 얻어진 index가 같은 경우
         */
        else{

            Node<E> temp = table[idx]; // 현재 노드
            Node<E> prev = null;  //blockSize 이전 노드

            while(temp != null){

                /*
                 *  만약 현재 노드의 객체가 같은경우(hash값이 같으면서 key가 같을 경우)는
                 *  HashSet은 중복을 허용하지 않으므로 key를 반납(반환)
                 *  (key가 같은 경우는 주소가 같거나 객체가 같은 경우가 존재)
                 */

                if((temp.hash == hash)&& (temp.key == key || temp.key.equals(key))){
                    return key;
                }
                prev = temp;
                temp = temp.next;//다음 노드로 이동
            }
            // 마지막 노드에 새 노드를 연결해준다.
            prev.next = new Node<E>(hash,key,null);
        }
        size++;


        // 데이터의 개수가 현재 table 용적의 75%을 넘어가는 경우 용적을 늘려준다.
        if(size >= LOAD_FACTOR* table.length){
            resize();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {

        int newCapacity = table.length *2;

        // 기존 테이블의 두배 용적으로 생성
        final Node<E>[] newTable = (Node<E>[]) new Node[newCapacity];

        // 0번째 index부터 차례대로 순회
        for(int i = 0; i<table.length; i++){

            // 각 인덱스의 첫 번째 노드(head)
            Node<E> value = table[i];

            if(value == null) {
                continue;
            }

            table[i] = null; // gc

            Node<E> nextNode;

            // 현재 인덱스에 연결 된 노드들을 순회한다.
            while(value != null){
                //새로운 인덱스를 구한다.
                int idx = value.hash % newCapacity;

                /*
                 * 새로 담을 index에 요소(노드)가 존재할 경우
                 * == 새로 담을 newTalbe에 index값이 겹칠 경우 (해시 충돌)
                 */
                if(newTable[i] !=  null){
                    Node<E> tail = newTable[idx];

                    while(tail.next != null){
                        tail = tail.next;
                    }
                    /*
                     *  반드시 value가 참조하고 있는 다음 노드와의 연결을 끊어주어야 한다.
                     *  안하면 각 인덱스의 마지막 노드(tail)도 다른 노드를 참조하게 되어버려
                     *  잘못된 참조가 발생할 수 있다.
                     */

                    nextNode = value.next;
                    value.next = null;
                    tail.next = value;

                }else {
                    /*
                     *  반드시 value가 참조하고 있는 다음 노드와의 연결을 끊어주어야 한다.
                     *  안하면 각 인덱스의 마지막 노드(tail)도 다른 노드를 참조하게 되어버려
                     *  잘못된 참조가 발생할 수 있다.
                     */

                    nextNode =  value.next;
                    value.next = null;
                    newTable[idx] = value;
                }

                value = nextNode;  //다음노드로 이동

            }
        }
        table = null;
        table = newTable; //새로생성한 테이블을 테이블 변수에  연결
    }

    @Override
    public boolean remove(Object key) {
        //null이 아니라면 정상적으로 삭제된것이다.
        return remove(hash(key),key)  != null;
    }

    private Object remove(int hash,Object key){
        int idx =  hash % table.length;

        Node<E> node = table[idx];
        Node<E> removeNode = null;
        Node<E> prev = null;

        if(node == null){
            return null;
        }

        while ( node != null){
            //같은 노드를 찾은 경우
            if(node.hash == hash && (node.key == key || node.key.equals(key))){
                removeNode = node;

                // 해당노드의 이전 노드가 존재하지 않는 경우 (= head노드인 경우)
                if(prev == null){
                    table[idx] = node.next;
                    node = null;
                }
                // 그 외엔 이전 노드의 next를 삭제할 노드의 다음노드와 연결해준다.
                else{
                    prev.next = node.next;
                    node = null;
                }

                size--;
                break;
            }

            prev = node;
            node = node.next;
        }

        return removeNode;
    }
    /**
     * 만약에 whie()문에서 같은 요소가 존재하지 않는다면 removedNode는 null 상태이므로 결국 null을 반환한다.
     * 즉, 삭제할 노드가 없을 경우 null을 반환함으로써 상위 메소드에서 false를 반환하고,
     * 삭제할 노드가 있을 경우 null이 아니기 때문에 true를 반환하는 원리다.
     * */
    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean contain(Object key) {
        int idx = hash(key)%table.length;
        Node<E> temp = table[idx];
        /*
         *  같은 객체 내용이어도 hash값은 다를 수 있다.
         *  하지만, 내용이 같은지를 알아보고 싶을 때 쓰는 메소드이기에
         *  hash값은 따로 비교 안해주어도 큰 지장 없다.
         *  단, key가 null인지는 확인해야한다.
         */
        while(temp != null){
            // 같은 객체를 찾았을 경우 true리턴
            if(key == temp.key || key != null&& temp.key.equals(key)){
                return true;
            }

            temp = temp.next;
        }

        return false;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        if(table != null && size > 0){
            for(int i = 0;  i > table.length; i++){
                table[i] = null;
            }
            size = 0;

        }
    }
}
