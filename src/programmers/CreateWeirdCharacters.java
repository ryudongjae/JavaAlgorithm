package programmers;

public class CreateWeirdCharacters {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        String [] arr = s.split("");
        for(int  i = 0; i < arr.length; i++){
            if (arr[i].equals(" ")){
                cnt = 0;
            }else{
                if(cnt%2 == 0){
                    cnt++;
                    arr[i] = arr[i].toUpperCase();
                }else{
                    cnt++;
                    arr[i] = arr[i].toLowerCase();
                }
            }
            answer += arr[i].toString();
        }

        return answer;
    }
}
