package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_4948 {
    /*
    * n > 123456 이므로 2n은 최대 246912
    * 0부터 시작하므로 +1,246913
    * */
    public static boolean[] prime = new boolean[246913];

    /*
    * 1부터 누적하여  각 인덱스 까지의 소수의 개수를 담을 배열
    * */
    public static int []count_arr = new int[246913];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        get_Prime(); //소수를 얻는 메소드
        get_count(); //소수의 개수가 저장된 배열을 얻는 메소드 실행

        StringBuilder sb = new StringBuilder();

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;  //n이 0일 경우 종료
            }
            //2n 까지의 소수의 개수 - n 까지의 소수의 개수
            sb.append(count_arr[2*n] - count_arr[n]).append('\n');
        }
        System.out.print(sb);
    }
    //소수를 얻는 메소드
    private static void get_Prime() {
        //0과 1 은 소수가 아니므로 true
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i<= Math.sqrt(prime.length); i++){
            if(prime[i]){
                continue;
            }
            for(int j = i*i; j < prime.length; j+= i){
                prime[j] = true;
             }
        }
    }

    private static void get_count() {
        int count  = 0;
        for(int i =2; i< prime.length; i++){
            if(!prime[i]){  //소수일 경우 count 를  증가 시킨다.
                count++;
            }

            /*
            * 0-i 가지 소수의 개수 =count
            * count 값을 count_arr 의 i에 저장한다.
            * */
            count_arr[i] = count;
        }
    }
}
