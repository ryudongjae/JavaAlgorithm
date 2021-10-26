package programmers;

import java.util.ArrayList;

public class KakaoFriendsColoringBook {
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int count = 0; //영역 카운트
    static int[] x = {-1,1,0,0};
    static int[] y = {0,0,-1,1};

    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        boolean[][]check = new boolean[m][n];

        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){

                if (picture[i][j] != 0 && !check[i][j]){
                    numberOfArea++;
                    dfs(i,j,picture,check);
                }
                if(count > maxSizeOfOneArea){
                    maxSizeOfOneArea = count;
                }
                count = 0;
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void dfs(int i, int j, int[][] picture, boolean[][] check) {

        if(check[i][j])return;


        check[i][j] = true;

        count++;

        for(int k = 0; k < 4; k++){
            int nx = i + x[k];
            int ny = j + y[k];

            if(nx < 0 || nx >= picture.length || ny < 0 || ny>= picture[0].length){
                continue;
            }

            if(picture[i][j] == picture[nx][ny] && !check[nx][ny]){
                dfs(nx,ny,picture,check);
            }
        }
    }
}
