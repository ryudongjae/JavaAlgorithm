package algorithm.insertSort;

public class InsertionSort2 {
    public void sort(int [] a){
        int size = a.length;
        int temp = 0;
        int j= 0;

        for (int i = 1;  i<size; i++){
            temp = a[i];
            for(j = i-1; j>=0&& temp<a[j]; j--){
                a[j+1] = a[j];
            }
            a[j+1] =temp;
        }
    }
}

/**
        [장점]
        1. 추가적인 메모리 소비가 작다.
        2. 거의 정렬 된 경우 매우 효율적이다. 즉, 최선의 경우 O(N)의 시간복잡도를 갖는다.
        3. 안장정렬이 가능하다.

        [단점]
        1. 역순에 가까울 수록 매우 비효율적이다. 즉, 최악의 경우 O(N2)의 시간 복잡도를 갖는다.
        2. 데이터의 상태에 따라서 성능 편차가 매우 크다.

*/