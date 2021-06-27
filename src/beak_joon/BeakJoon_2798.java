package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BeakJoon_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr  = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = search(arr,N,M);
        System.out.println(result);
    }

    static int search(int[] arr, int N , int M){
        int result = 0;

        //첫번째 카드
        for(int i = 0; i < N-2; i++){
            //첫 카드가 M 보다 크면 skip
            if(arr[i] > M ) continue;
            //두번째 카드
            for(int j = i+1; j < N-1; j++){
                //첫번째 두번째 카드합이 M 보다 크면 skip
                if(arr[i] + arr[j] > M) continue;
                //세번째 카드(두번째 다음부터 순회)
                for(int k = j+1; k<N; k++){
                    //세 카드 합
                    int temp = arr[i]+arr[j]+arr[k];
                    //세 카드 합과 M이 같으면 리턴
                    if(M == temp){
                        return temp;
                    }
                    // 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신
                    if( result < temp && temp < M){

                        result =temp;
                    }
                }

            }
        }
        return result;
    }
}
