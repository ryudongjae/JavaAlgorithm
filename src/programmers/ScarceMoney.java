package programmers;

public class ScarceMoney {
    public long solution(int price, int money, int count) {
        long value = 0;
        for(int i = 1; i <= count; i++){
            value += price*i;
        }
        value = value - money;
        if (value < 0){
            return 0;
        }
        return value;
    }
}
