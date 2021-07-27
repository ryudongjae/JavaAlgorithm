package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BeakJoon_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int J = Integer.parseInt(br.readLine());
            if(J == 0){
                stack.pop();
            }else {
                stack.push(J);
            }
        }
        int total = 0;
        for (int to : stack) {
            total += to;
        }

        System.out.println(total);
    }
}
