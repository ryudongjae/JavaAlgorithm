package algorithm.insertSort;

public class InsertionSort {

    public static void insertion_sort(int[]a){
        insertion_sort(a,a.length);
    }

    private static void insertion_sort(int[]a , int size){

        for(int i = 1;i<size; i++){

            int target =a[i];

            int j = i-1;
            //ㅌ타겟이 이전 원소보다 크기 전까지 반복
            while (j>= 0&& target<a[j]){
                a[j+1] = a[j];
                j--;

            }
            /*
             * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
             * 타겟 원소는 j번째 원소 뒤에 와야한다.
             * 그러므로 타겟은 j + 1 에 위치하게 된다.
             */
            a[j + 1] = target;
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