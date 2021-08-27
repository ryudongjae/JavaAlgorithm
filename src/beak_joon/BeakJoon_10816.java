package beak_joon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeakJoon_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i< N; i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i< M; i++){
            int value = Integer.parseInt(st.nextToken());

           bw.write(hi(value,arr)-lo(value,arr)+" ");

        }
        bw.close();
        System.out.println(bw);
    }

    private static int lo(int value, int[] arr) {
        int fir = 0;
        int fin = arr.length;

        while (fir<fin){
            int mid = (fir+fin)/2;
            if(value <= arr[mid])fin=mid;
            else fir=mid+1;
        }
        return fir;
    }

    private static int hi(int value, int[] arr) {
        int fir = 0;
        int fin = arr.length;

        while (fir<fin){
            int mid = (fir+fin)/2;
            if(value < arr[mid])fin=mid;
            else fir=mid+1;
        }
        return fir;
    }
}
