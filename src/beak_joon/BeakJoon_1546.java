package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
// 평균
public class BeakJoon_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double [] arr = new double[sc.nextInt()];

        for(int i =0; i < arr.length; i++){
            arr[i] = sc.nextDouble();
        }
        sc.close();

        double sum = 0;
        Arrays.sort(arr);

        for(int i = 0; i <  arr.length; i++){
            sum+=(arr[i]/arr[arr.length-1 * 100]);
        }
        System.out.println(sum/ arr.length);
    }
}
class BeakJoon_1546_2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double [] arr = new double[Integer.parseInt(br.readLine())];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < arr.length; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }

        double sum = 0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            sum+=(arr[i]/arr[arr.length-1]*100);
        }
        System.out.println(sum/ arr.length);
    }
}
class BeakJoon_1546_3{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int max = -1;
        double sum =0.0;

        for(int i = 0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());

            if(value > max){
                max = value;

            }

            sum += value;
        }
        System.out.println(((sum/max)* 100.0)/N);
    }
}