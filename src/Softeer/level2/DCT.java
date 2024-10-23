package Softeer.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DCT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int ascendingCount = 0;
        int descendingCount = 0;
        for(int i = 1; i < split.length; i++){
            Integer thisCount = Integer.valueOf(split[i-1]);
            Integer nextCount = Integer.valueOf(split[i]);
            if (thisCount > nextCount){
                descendingCount++;
            }else{
                ascendingCount++;
            }
        }
        if (descendingCount==7) System.out.println("descending");
        else if (ascendingCount==7) System.out.println("ascending");
        else System.out.println("mixed");
    }
}
