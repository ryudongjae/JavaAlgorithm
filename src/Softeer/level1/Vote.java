package Softeer.level1;

import java.io.*;
import java.util.*;

public class Vote {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int headCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < headCnt; i++) {
            if (i == headCnt-1){
                //마지막이라면 줄바꿈이 불필요하다.
                sb.append(changePattern(Integer.parseInt(br.readLine())));
            }else{
                sb.append(changePattern(Integer.parseInt(br.readLine()))).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static String changePattern(int votePoint) {
        int quotient = votePoint / 5;
        int remainder = votePoint % 5;
        String result = "";
        if (quotient != 0) {
            for (int i = 0; i < quotient; i++) {
                //나머지가 0이고 마지막 ++++라면 공백이 필요없다.
                if (remainder == 0 && quotient-1 == i){
                    result += "++++";
                }else{
                    result += "++++ ";
                }
            }
        }
        //5단위로 끊고 그 외 작업
        for (int i = 0; i < remainder; i++) {
            result += "|";
        }

        return result;
    }
}
