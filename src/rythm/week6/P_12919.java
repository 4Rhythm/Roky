package rythm.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_12919 {
    static int L;
    static String S, T;
    static int result;
    static int countA, countB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = 0;
        S = br.readLine();
        T = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') {
                countA++;
            } else {
                countB++;
            }
        }
        L = T.length() - S.length();

        search(T, 0);
        System.out.println(result);
    }

    private static void search(String T, int cnt) {
        if (L == cnt) {
            if (S.equals(T)) {
                result = 1;
            }
            return;
        }

        if (T.charAt(0) == 'B') {
            String tmp = new StringBuffer(T.substring(1)).reverse().toString();
            search(tmp, cnt + 1);
        }

        if (T.charAt(T.length() - 1) == 'A') {
            search(T.substring(0, T.length() - 1), cnt + 1);
        }

    }

}
