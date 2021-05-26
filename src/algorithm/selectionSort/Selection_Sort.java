package algorithm.selectionSort;


/*
* 1. 주어진 리스트에서 최솟값을 찾는다.
* 2. 최솟값을 맨 앞 자리의 값과 교환한다.
* 3. 맨 앞 자리를 제외한 나머지 값들 중 최솟값을 찾아 위와 같은 방법으로 반복한다.
*/
public class Selection_Sort{

    public void selection_sort(int[]a){
        selection_sort(a,a.length);

    }

    private static void selection_sort(int [] a, int size){

        for(int i =0; i<size; i++){
            int min_index = i;

            //최소값을 가지고 있는 인덱스 찾기
            for(int j = i+1; j<size; j++){
                if(a[j]<a[min_index]){
                    min_index = j;
                }
            }
            //i번째 값과 찾은 최소값을 서로 교환
            swap(a,min_index,i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = a[temp];
    }

}
