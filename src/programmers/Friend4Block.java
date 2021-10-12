package programmers;

import java.util.ArrayList;
import java.util.List;

public class Friend4Block {
    int answer = 0;
    char[][] var;
    public int solution(int m, int n, String[] board) {
        var = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                var[i][j] = board[i].charAt(j);
            }
        }
        while(blocksCheck(m, n));
        return answer;
    }

    public boolean blocksCheck(int m, int n) {
        boolean[][]ch = new boolean[m][n];
        int cnt = 0;

        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < n-1; j++){
                if (var[i][j] == '0') continue;
                if (checkCnt(i,j)== true){
                    ch[i][j]= true;ch[i+1][j+1]= true;
                    ch[i+1][j]= true;ch[i][j+1] = true;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            List<Character> temp = new ArrayList<>();
            for(int j = m-1; j >= 0; j--) {
                if(ch[j][i] == true){
                    cnt++;
                    continue;
                }
                temp.add(var[j][i]);
            }

            for(int j = m-1, k = 0; j >= 0; j--, k++) {
                if(k < temp.size())	var[j][i] = temp.get(k);
                else var[j][i] = '0';
            }
        }

        answer += cnt;
        return cnt > 0 ? true:false;
    }

    public boolean checkCnt(int i, int j) {
        char std = var[i][j];

        if(var[i][j+1] == std && var[i+1][j] == std && var[i+1][j+1] == std) return true;
        return false;
    }
}
