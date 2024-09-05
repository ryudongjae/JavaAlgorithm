package Softeer.level2;

import java.io.*;


public class blockSize {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] circle = String.valueOf(br.readLine()).split(" ");
        int max = 0;
        //반지름별로 for
        for (int i = 2; i < 100; i++) {
            //반지름
            int size = i;
            //각 반지름 별로 카운트 계산
            int blockCnt = 0;
            for (int j = 0; j < n; j++) {
                //연탄의 크기
                int compareSize = Integer.parseInt(circle[j]);

                if (compareSize % i == 0) {
                    blockCnt++;
                }

                if (j == 0 && i == 2){
                    max = blockCnt;
                }else{
                    if (max < blockCnt){
                        max = blockCnt;
                    }
                }
            }
        }

        System.out.println(max);

    }
}
