package boj.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jump_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());

        int[][] arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j++] = atoi(st.nextToken());
            }
        }

        long dp[][] = new long[N][N]; // 범위 문제때문에 long 사용
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0 || (i == N - 1 && j == N - 1)) {
                    continue;
                }

                int dist = arr[i][j];
                int right = dist + j;
                int down = dist + i;

                if (right < N) {
                    dp[i][right] += dp[i][j];
                }
                if (down < N) {
                    dp[down][j] += dp[i][j];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[N-1][N-1]);
    }

    public static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
