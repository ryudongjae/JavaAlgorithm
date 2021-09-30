package programmers;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i<n; i++){
            String val = Integer.toBinaryString(arr1[i]|arr2[i]);
            //문자열 n만큼 좌측에 공백을 채워 문자열 길이를 만든다.
            val = String.format("%"+n+"s",val);
            val = val.replace("1","#");
            val = val.replace("0"," ");
            answer[i] = val;
        }
        return answer;
    }
}
