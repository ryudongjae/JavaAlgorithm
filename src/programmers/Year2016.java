package programmers;

public class Year2016 {
    public String solution(int a, int b) {
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] year = new String[366];
        int wday = 0;
        String answer = "";

        for(int i = 0; i < year.length; i++){
            year[i] = day[(i+5) %7];
        }

        for(int i = 0; i < a-1; i++){
            wday += month[i];
        }

        wday += b -1;

        answer = year[wday];
        return answer;
    }
}
