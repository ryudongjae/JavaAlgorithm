package datastructure.hash;

/**
 * 기본적으로 Set혹은 Set계열을 구현하는 클래스들은 다음과 같은 공통점이 있다.
 * 1. 중복되는 요소(원소)를 허용하지 않는다.
 * 2. 저장 순서를 유지하지 않는다. (LinkedHashSet 만 예외)
 *  Set은 크게 HashSet, LinkedHashSet, TreeSet으로 나뉜다
 *
 */
public interface Set<E> {
    //지정된 요소가 없을 경우 요소를 추가한다. 지정된 요소가 있을 경우 false 를 반환한다.
    boolean add(E e);

    //지정된 객체가 집합에 존재하는 경우 해당 요소를 제거 합니다.
    boolean remove(Object o);

    //지정된요소가 집합에 있는지를 확인 합니다.
    boolean contain(Object o);

    //지정된 객체와 현재 집합이 같은지 확인합니다.
    boolean equals(Object o);

    //현재 집합이 비어 있을경우 true 비어있지 않으면 false를 반환합니다.
    boolean isEmpty();

    //현재 집합에 있는 요소의 개수를 조회합니다.
    int size();


    //현재 집합에 있는 모든 요소들을 삭제합니다.
    void clear();

}
