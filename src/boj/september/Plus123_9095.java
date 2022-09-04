package boj.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus123_9095 {
    static int nArr[] = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());
        nArr[1] = 1;
        nArr[2] = 2;
        nArr[3] = 4;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = atoi(br.readLine());
            sb.append(func(input)).append("\n");
        }
        System.out.println(sb);
    }

    public static int func(int n) {
        if (n < 1) {
            return 0;
        } else {
            if (nArr[n] != 0) {
                return nArr[n];
            } else
                return nArr[n] = func(n -1) + func(n-2) + func(n-3);
        }
    }

    public static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
