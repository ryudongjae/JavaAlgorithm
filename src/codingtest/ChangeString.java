package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[]arr = str.split(",");
        System.out.println(check(arr[0],arr[1]));

    }

    private static boolean check(String x, String y) {
        return !x.equals(y);
    }
}
