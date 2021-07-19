package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_5086{
    static String f,m,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        f = "factor\n"; m = "multiple\n";  n = "neither\n";

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
             st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(first == 0 && second == 0 )break;

            if(second % first == 0 ){
                sb.append(f);
            }
            else if(first % second == 0){
                sb.append(m);
            }else{
                sb.append(n);
            }
        }
        System.out.println(sb);
    }
}
