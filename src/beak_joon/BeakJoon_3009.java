package beak_joon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_3009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] coord_1 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        st = new StringTokenizer(br.readLine()," ");
        int[] coord_2 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        st = new StringTokenizer(br.readLine()," ");
        int[] coord_3 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };



        int x;
        int y;

        // x 좌표 비교
        // 1번 x좌표와 2번 x좌표 비교
        if (coord_1[0] == coord_2[0]) {
            x = coord_3[0];
        }
        // 1번 x좌표와 3번 x좌표 비교
        else if (coord_1[0] == coord_3[0]) {
            x = coord_2[0];
        }
        // 2번 x좌표와 3번 x좌표 비교
        else {
            x = coord_1[0];
        }

        // y 좌표 비교
        // 1번 x좌표와 2번 x좌표 비교
        if (coord_1[1] == coord_2[1]) {
            y = coord_3[1];
        }
        // 1번 x좌표와 3번 x좌표 비교
        else if (coord_1[1] == coord_3[1]) {
            y = coord_2[1];
        }
        // 2번 x좌표와 3번 x좌표 비교
        else {
            y = coord_1[1];
        }

        System.out.println(x + " " + y);


    }

}
