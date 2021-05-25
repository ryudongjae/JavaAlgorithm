package algorithm;

import java.util.List;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("펙토리얼 계산을 위한 정수값 입력 ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int fac = 1;
        for (int i = 1; i<=num; i++){  //(int i = num; i>0; i--)
            fac *= i;
        }

        System.out.println(num + "! = "+ fac);
    }
}

class addList{
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 23, 45, 34, 432};

        int sum = 0;
//
//        for (int i = 0; i < a.length; i++){
//            sum +=a[i];
//        }
        for(int e : a){
            sum += e;
        }

        System.out.println(sum);
    }
}
