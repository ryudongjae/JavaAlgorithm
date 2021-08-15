package programmers;

import java.util.Locale;

public class JadenCase {
    public String solution(String s) {
        String answer = "";
        String [] arr = s.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();

        boolean blank = true;

        for (String str : arr) {
            answer += blank ? str.toUpperCase() :str;
            blank = str.equals(" ")?true:false;
        }

        return answer;
    }
}
