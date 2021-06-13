package beak_joon;

import datastructure.hash.HashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
HashSet 은 자바 Collection 중 Set 의 파생클래스이다.
중복되는 원소를 넣을 경우 하나만 저장한다. 즉, 중복원소를 허용하지 않는다.
HashSet 은 순서 개념이 없다.
 따라서 Collections.sort() 메소드를 사용할 수 없다. 만약 정렬을 하고 싶다면 리스트로 변환 후 정렬해야한다.
*/

//HashSet.add() 메소드는 HashSet에 저장하는 메소드이다.
// 처음 생성할 때 HashSet<Integer> 으로 타입을 Integer로 선언했기 때문에 int 형 또는 Integer 객체를 넣어주어야한다.
//또한 이 메소드에서 값을 넣을 때 만약 중복되는 값이 없으면 HashSet 에 저장되면서 True 를 반환하고,
// 만약 중복되어 저장되지 않으면 False 를 반환한다.

//나머지
public class BeakJoon_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> h = new HashSet<Integer>();

        for(int i = 0; i < 10; i++){
            h.add(Integer.parseInt(br.readLine())%42);
        }
        System.out.println(h.size());
    }
}

//입력받은 값의 %42 을 통한 나머지 값의 index 을 true 로 바꾸어 준 뒤, 입력이 종료되면 true 값인 배열원소의 개수를 세어준다.
class BeakJoon_3052_2{
    public static void main(String[] args) throws IOException {

        boolean [] arr = new boolean[42];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<10; i++){
            arr[Integer.parseInt(br.readLine()) % 42] = true;
        }

        int count = 0;
        for (boolean value : arr) {
            if(value){
                count++;
            }
        }
        System.out.println(count);
    }
}