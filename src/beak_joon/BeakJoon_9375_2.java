package beak_joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BeakJoon_9375_2 {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            for(int t = 1; t <= T; t++) {
                int n = Integer.parseInt(br.readLine().trim());
                Map<String, Integer> count = new HashMap<>();
                for(int i = 0; i < n; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine().trim());
                    st.nextToken();
                    String type = st.nextToken();
                    if(!count.containsKey(type)) {
                        count.put(type, 0);
                    }
                    count.put(type, count.get(type) + 1);
                }
                long mul = 1;
                for(String type : count.keySet()) {
                    mul *= count.get(type) + 1;
                }
                mul--;
                System.out.println(mul);
            }
        }


}
