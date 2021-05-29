package algorithm.countingSort;

public class CountingSort {
    public static void main(String[] args) {
        int [] array  = new int[100];  //수열의 원소
        int [] counting =new int[31];  //수의 범위 0 -30
        int [] result  = new int[100]; //정렬된 배열

        for(int i = 0 ; i < array.length; i++){
            array[i] = (int) (Math.random()*31);
        }

        //과정1
        for(int i = 0; i < array.length; i++){
            counting[array[i]]++;   //array의  value값을  index로 하는 카운팅 배열값 증가
        }


        //과정2
        for(int i = 1; i < counting.length; i++){
            //누적 합 해주기
            counting[i] += counting[i - 1];
        }

        //과정3
        /**
         *  i 번쨰 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤
         *  counting 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
         */
        for (int i = array.length -1; i >= 0; i -- ) {

            int value = array[i];
            counting[value]--;
            result[counting[value]] = value;

        }
            // 초기 배열
            System.out.println("array[]");
            for(int i = 0; i < array.length; i++) {
                if(i % 10 == 0) System.out.println();
                System.out.print(array[i] + "\t");
            }
            System.out.println("\n\n");


            //카운팅 배열
            System.out.println("counting[]");
            for ( int i = 0; i< counting.length; i++){
                if(i%10 == 0) System.out.println();
                System.out.print(counting[i] +"\t");
            }
            System.out.println("\n\n");

            //정렬된 배열
            System.out.println("result[]");
            for (int i =0 ; i < result.length; i++){
                if(i%10 == 0) System.out.println();
                System.out.print(result[i] + "\t");
            }
            System.out.println("\n\n");
        }







}
