package Softeer.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yeah_butHow {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();
        StringBuilder resultStr = new StringBuilder();

        for(int i = 0; i < charArray.length-1; i++){
            //일단 넣어주고 다음값은 조건에 따라 추가
            resultStr.append(charArray[i]);
            //()일 경우 가운데 1을 넣어줌
            if (charArray[i] == '(' && charArray[i+1] == ')'){
                resultStr.append("1");
            }

            //)(일 경우 가운데 +
            if (charArray[i] == ')' && charArray[i+1] == '('){
                resultStr.append("+");
            }
            //마지막은 검증하지 않고 리턴
            if (i == charArray.length-2){
                resultStr.append(charArray[charArray.length-1]);
            }
        }

        System.out.println(resultStr);
    }
}
