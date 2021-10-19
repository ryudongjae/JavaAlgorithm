package programmers;

public class QuadCompressionCount {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        quad(arr.length, 0,0 ,arr);
        return answer;
    }

    private void quad(int length, int x, int y, int[][] arr) {

        boolean Zero = true;
        boolean One = true;

        for(int i = x; i <  x+length; i++){
            for(int j = y; j < y+length; j++){
                if (arr[i][j] == 1)Zero = false;
                if (arr[i][j] == 0)One = false;
            }
        }

        if (Zero){
            answer[0] ++;
            return;
        }else if (One){
            answer[1]++;
            return;
        }

        quad(length/2,x,y,arr);
        quad(length/2,x+length/2,y,arr);
        quad(length/2,x,y+length/2,arr);
        quad(length/2,x + length/2,y + length/2,arr);
    }


}
