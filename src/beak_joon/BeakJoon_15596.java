package beak_joon;
/*
* 정수 N개의 합
* */
public class BeakJoon_15596 {
    long sum(int [] a){
        long sum = 0;

        for(int i =0; i < a.length; i++){
            sum+= a[i];
        }

        return sum;

    }
}
