package boj.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin1_2293 {
    static int[] dp;
    static int[] coinList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = atoi(st.nextToken());
        int K = atoi(st.nextToken()); // target
        coinList = new int[N];
        dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            coinList[i] = atoi(br.readLine());
        }

        // 초기값 세팅
        dp[0] = 1;

        // 점화식 : dp[k] = dp[k] + dp[k - coin[i]]
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (coinList[i] > j) {
                    continue;
                }
                dp[j] += dp[j-coinList[i]];
            }
        }
        System.out.println(dp[K]);
    }

    public static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
