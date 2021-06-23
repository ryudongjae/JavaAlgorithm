package algorithm;

import java.util.ArrayList;

public class Kmp_Algo {
    public static ArrayList<Integer> kmp(String str, String pattern) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] pi = getPi(pattern);
        int n = str.length();
        int m = pattern.length();
        int j = 0;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        // str - 전체 문자열, pattern - 찾을 문자열
        // j - 찾을 문자열의 비교 인덱스.
        // i - 전체 문자열과 비교할 인덱스이기 때문에 1씩 증가하기만 함. 절대 불규칙적으로 변경되지 않음.

        for (int i = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) {
                // 중간 단계 뛰어넘기.
                // pi배열을 이용하여 j인덱스를 변경시킴으로써 while문 중단.
                j = pi[j - 1];
            }

            if (s[i] == p[j]) {
                if (j == m - 1) {
                    // j는 비교 인덱스로써, 인덱스가 찾을 문자열의 크기에 도달하면 문자열 찾음.
                    list.add(i - m + 1);
                    // 여러 개의 찾을 문자열이 있을 수 있기 때문.
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return list;
    }

    private static int[] getPi(String pattern) {
        int m = pattern.length();
        int j = 0;
        char[] p = new char[m];
        int[] pi = new int[m];

        p = pattern.toCharArray();

        for (int i = 1; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }
            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }

        return pi;

    }

}
