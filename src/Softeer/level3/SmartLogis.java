package Softeer.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmartLogis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] countArray = br.readLine().split(" ");
        //전체
        int allCount = Integer.parseInt(countArray[0]);
        //거리
        int k = Integer.parseInt(countArray[1]);

        //레일
        String [] rail = br.readLine().split("");

        int count = 0;

        for(int i = 0; i < allCount; i++){
            //로봇인 경우
            if (rail[i].equals("P")){
                //로봇을 기준으로 탐색
                //0번이 로봇인 경우 0+k까지 탐색
                for(int j = i-k; j <= i + k; j++){
                    if (j < 0 || j >= allCount) continue;
                    if (rail[j].equals("H")){
                        rail[j] = "X";
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
