package programmers;

import java.math.BigInteger;

public class PlainSquare {
    public long solution(int w, int h) {
        long total = (long) w *(long) h;
        long diagonalCount = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
        return total - diagonalCount;
    }
}
