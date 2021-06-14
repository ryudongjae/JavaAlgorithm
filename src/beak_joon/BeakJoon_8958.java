package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* OX 퀴즈
* */
public class BeakJoon_8958 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        String [] arr = new String[test_case];

        for(int i = 0; i < test_case; i++){
            arr[i] = br.readLine();
        }

        for(int i =0 ; i< test_case; i++){
            int count  =0; //연속횟수
            int sum =0;  //누적합산

            for(int j = 0; i < arr[i].length(); j++){
                if(arr[i].charAt(j) == '0'){
                    count++;
                }else {
                    count = 0;
                }

                sum+= count;
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb);

    }
}
class BeakJoon_8958_2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_case; i++){
            int count = 0;
            int sum = 0;

            for(byte value:br.readLine().getBytes()){
/*
*'한글'을 쓰고자 한다면 toCharArray()를 쓰거나 charAt()
* 먼저 .br.readLine() 은 한 줄을 문자열로 입력을 받는다.
* 그리고 getBytes() 는 입력받은 문자열을 byte 형 배열로 반환한다.
* 즉, 위의 for-each 문은 입력을 한 줄 받으면 해당 문자열의 길이만큼 반복하면서 해당 문자열의 문자를 하나씩 value 에 저장하여 꺼내오는 것이다.
*/
                if(value == '0'){
                    count++;
                    sum+=count;
                }else{
                    count = 0;
                }
            }

            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
