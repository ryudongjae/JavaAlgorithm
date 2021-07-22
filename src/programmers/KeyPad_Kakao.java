package programmers;

public class KeyPad_Kakao {

}
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;

        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                left = num;
            }
            else if(num == 3 || num == 6 || num == 9){
                sb.append("R");
                right = num;
            }else{
                int L_length = getLength(left,num);
                int R_length = getLength(right,num);

                if(L_length > R_length){
                    sb.append("R");
                    right =num;
                }else if(L_length < R_length){
                    sb.append("L");
                    left = num;
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right = num;
                    }else {
                        sb.append("L");
                        left = num;
                    }
                }
            }
        }
        return sb.toString();
    }

    static int getLength(int idx,int num){
        idx = (idx == 0)? 11: idx;
        num = (num == 0)? 11: num;

        int x = (idx -1) /3;
        int y = (idx -1) %3;
        int numberX = num /3;
        int numberY = 1;


        return Math.abs(x-numberX) + Math.abs(y-numberY);
    }
}