package programmers;

public class Watermelon {
    public String solution(int n) {
        String answer = "";
        int k = n / 2;
        if(n >= 2){
            for(int i =0; i < k; i++){
                answer+="수박";
            }
        }
        if(n%2 == 1){
            answer+="수";
        }


        return answer;
    }

    public String solution2(int n){
        String answer = "";
        for(int i = 0; i< n; i++) {
            answer+= i%2==0?"수":"박";
        }
        return answer;
    }
}
