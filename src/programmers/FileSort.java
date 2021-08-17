package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class FileSort {
    public String[] solution(String[] files) {
        String [] answer = {};
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                //compareTo를 사용하려면 소문자로 변경
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());

                if(result == 0){ //같은 문자이면 숫자로 비교
                    result = convertNum(o1,head1) - convertNum(o2,head2);
                }
                
                return result;

            }
        });

        return files;
    }

    private int convertNum(String str, String head) {
        str = str.substring(head.length());//head 길이만큼 잘라서 숫자부터 시작하게 만들어줌
        String result ="";
        for (char c :  str.toCharArray()) {
            if(Character.isDigit(c)&&result.length()<5) result+= c;
            else break;

        }
        return Integer.valueOf(result);
    }
}
