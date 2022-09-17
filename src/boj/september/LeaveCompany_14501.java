package boj.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeaveCompany_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());
        int[] T = new int[N + 10];
        int[] P = new int[N + 10];
        int[] dp = new int[N + 10];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = atoi(st.nextToken());
            P[i] = atoi(st.nextToken());
        }
        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[T[i] + i] + P[i]);
            }
        }
        System.out.println(dp[1]);
    }

    public static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
