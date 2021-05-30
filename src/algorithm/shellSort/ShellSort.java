package algorithm.shellSort;

public class ShellSort {

    private final static int[] gap =
            { 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937,
                    8858, 19930, 44842, 100894, 227011, 510774,
                    1149241, 2585792, 5818032, 13090572, 29453787,
                    66271020, 149109795, 335497038, 754868335, 1698453753};	// 갭을 담고있는 배열



    public static void shell_sort(int[] a){
        shell_sort(a, a.length);
    }
    // 맨 처음 gap을 참조 할 인덱스를 구하는 메소드
    private static int getGap(int length){
        int index = 0;
        //최소한의 부분 배열의 원소가 2개씩은 비교 되도록 나눠준다.
        int len = (int)(length/2.25);
        while(gap[index] <= len){
            index++;
        }

        return index;
    }

    private static void shell_sort(int [] a, int size){
        int index = getGap(size);//첫 갭을 사용할 인덱스

        while (index >= 0){ //갭이 1이 될 때까지 반복


            int step = gap[index--]; //현재의 gap


            // gap[index] 값부터 gap[0] 까지 반복한다.
            for (int i = index; i >= 0; i--) {
                /*
                 *  j는 target 원소가 되며 현재 원소(target) a[j]가 이전 원소 a[j - step]보다
                 *  작을 때 까지 반복한다.
                 */
                for (int j = 0; j < gap[i]; i++) {
                    /*
                     *  현재(target) 원소의 인덱스(j)와 이전의 원소(j-step)의 인덱스에 있는
                     *  원소의 값을 교환한다.
                     */

                    swap(a,j,j - step);
;                }
            }
        }

    }

    private static void swap(int[] a, int i, int j) {

        int swap = a[i];
        a[i] = a[j];
        a[j] =swap;
    }
}
