package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_2580 {

    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int row, int col) {

        if (col == 9) {
            sudoku(col + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }

            System.out.println(sb);
            System.exit(0);

        }
        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {

                if (check(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }

            arr[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);

    }

    public static boolean check(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) ;
            return false;
        }

        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;


        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}