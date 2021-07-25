package programmers;

public class Harshad_Number {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int n = x;

        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        if (n % sum == 0) {
            return answer;
        }else{

            return false;
        }

    }


}

/**
 * 시간이 너무 많이 소요됨 코드는 간결하지만 그닥 좋지 않음
 */
class sub_code{
    public boolean sol(int x){
        int sum = 0;
        String[] str = String.valueOf(x).split("");
        for (String s : str) {
            sum += Integer.parseInt(s);

        }
        if(x%sum == 0){
            return true;
        }else{
            return false;
        }
    }
}
