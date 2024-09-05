package Softeer.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class blockDeliv {
    public static void main(String[] args) throws Exception {
        BufferedReader  bfr = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bfr.readLine());
        String[] vills = String.valueOf(bfr.readLine()).split(" ");

        //가장 까까운 거리 찾기
        int shtDis = shortDistance(vills);
        int delivCnt = 0;
        for(int i = 1; i < vills.length; i++){
            int compareDis = Integer.parseInt(vills[i]) - Integer.parseInt(vills[i-1]);
            //거리값이 작은값이랑 같으면 Cnt++
            if(compareDis == shtDis){
                delivCnt++;
            }
        }
        System.out.println(delivCnt);

    }

    public static int shortDistance(String[] vills){
        //첫번째 거리 차이
        int distance = Integer.parseInt(vills[1]) - Integer.parseInt(vills[0]);
        for(int i = 1; i < vills.length; i++){
            //거리차이 계산
            int compareDis = Integer.parseInt(vills[i]) - Integer.parseInt(vills[i-1]);
            //거리차이 비교 (작은값으로 변경 )
            if(compareDis < distance){
                distance = compareDis;
            }
        }
        return  distance;
    }
}
