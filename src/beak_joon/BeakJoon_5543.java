package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//상근버거
public class BeakJoon_5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int burger = 2001;
        int drink = 2001;

        //버거
        for(int i = 0; i <3; i++){
            int value = sc.nextInt();
            if(value < burger){
                value = burger;
            }
        }

        //음료
        for(int i = 0; i< 2; i++){
            int value  = sc.nextInt();
            if(value<drink){
                value = drink;
            }
        }

        System.out.println(burger + drink -50);
    }
}
class BeakJoon_5543_2{
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int burger = 2001;
        int drink = 2001;

        for(int i = 0; i< 3; i++){
            int value = Integer.parseInt(br.readLine());
            if (value <burger){ //최솟값 찾기
                value = burger;
            }
        }

        for(int i =0; i < 2; i++){
            int value = Integer.parseInt(br.readLine());
            if(value < drink){  //최솟값 찾기
                value  = drink;
            }
        }

        System.out.println(burger + drink -50 );
    }
}