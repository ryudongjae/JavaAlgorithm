package programmers;

import java.util.Objects;

public class PYCount {
    boolean solution(String s) {
        boolean answer = false;
        int pCnt = 0;
        int yCnt = 0;

        String [] str = s.split("");

        for (int i = 0; i <str.length; i++){
            if (str[i].equals("P")||str[i].equals("p")){
                pCnt++;
            }
            if (str[i].equals("Y")||str[i].equals("y")){
                yCnt++;
            }
        }
        if (pCnt == yCnt){
            return true;
        }else{
            return false;
        }

    }
}
