package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BeakJoon_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            HashMap<String,Integer> fa = new HashMap<>();

            int N = Integer.parseInt(br.readLine());

            while (N-- > 0){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");

                st.nextToken();

                String kind = st.nextToken();

                if(fa.containsKey(kind)){
                    fa.put(kind,fa.get(kind)+1);
                }
                else{
                    fa.put(kind,1);
                }

            }
            int result = 1;

            for (int val : fa.values()) {
                result *= (val+1);
            }
            sb.append(result -1 ).append('\n');
        }
    }
}

