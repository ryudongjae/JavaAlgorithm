package programmers;

public class Friend4Block2 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] var = new char[m][n];

        for(int i = 0; i < m; ++i){
            var[i] = board[i].toCharArray();
        }

        while(true){
            int cnt = checkBlock(m,n,var);
            if(cnt == 0)break;
            answer += cnt;

            dropBlock(m,n,var);
        }
        return answer;
    }
    //블록 떨어트리기
    private void dropBlock(int m, int n, char[][] map) {
        for(int i = 0 ; i < n ; i++) {
            for(int j = m - 1 ; j >= 0 ; j--) {
                if(map[j][i] == '.') {
                    for(int k = j - 1 ; k >= 0 ; k--) {
                        if(map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    //체크된 블록 지우기
    private int checkBlock(int m, int n, char[][] var) {
        int cnt = 0;
        boolean[][]isChecked = new boolean[m][n];

        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < n-1; j++){
                if(var[i][j] == '.')continue;
                checkFour(var,isChecked,i,j);
            }
        }
        for(int i = 0; i <  m; i++){
            for(int j = 0; j < n; j++){
                if (isChecked[i][j]){
                    cnt++;
                    var[i][j] ='.';
                }
            }
        }
        return cnt;
    }
    //사라져야할 블록
    private void checkFour(char[][] var, boolean[][] isChecked,int i,int j){
        char block = var[i][j];

        for (int k = i; k < i+2; k++){
            for (int l = j; l < j+2; l++){
                if (var[k][l] != block)return;
            }
        }

        for (int k = i; k < i+2; k++){
            for (int l = j; l < j+2; l++){
                isChecked[k][l] = true;
            }
        }
    }
}
