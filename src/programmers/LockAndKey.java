package programmers;

public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        int n = key.length;
        int m = lock.length;
        int[][] copyLock = new int[m*3][m*3];

        //새로만든 기존 lock의 크기 *3의 배열의 중앙에 lock배열 삽입
        for(int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                copyLock[i+m][j+m] = lock[i][j];
            }
        }


        // 0,90,180,270도 방향 확인
        for(int c = 0; c < 4; c++){
            key = rotate(key);

            //시작점 탐색용 0,0 부터 n*2,n*2까지
            for (int x =0; x < m*2; x++){
                for(int y = 0; y < m*2; y++){

                    //자물쇠에 열쇠끼우기
                    for(int i=0; i < n; i++){
                        for (int j =0; j<n; j++){
                            copyLock[x+i][y+j] += key[i][j];
                        }
                    }

                    //모두 일치해서 잘끼워졌다면 모두 1이 되어야한다.
                    if (check(copyLock))return true;


                    //만약 리턴되지 않으면 맞지 않은것이기 때문에 다시 열쇠를 뺴준다.
                    for (int i = 0; i < n; i++){
                        for (int j = 0; j < n; j++){
                            copyLock[x+i][y+j] -=key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }


    //열쇠가 자물쇠에 맞는지 확인하는 로직
    private boolean check(int[][] copyLock) {
        int cnt = 0;
        int len = copyLock.length/3;
        for(int i = len; i < len *2; i++){
            for (int j =len; j<len*2; j++){
                if(copyLock[i][j] == 1)cnt++;
            }
        }
        return cnt == len * len;
    }

    //key가 회전하는 로직
    private int[][] rotate(int[][] key) {
        int len = key.length;
        int [][] temp = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                temp[i][j] = key[len-j-1][i];
            }
        }
        return temp;
    }
}
