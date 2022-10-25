package boj.october;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin0_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = atoi(st.nextToken());
        int K = atoi(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = atoi(br.readLine());
        }

        int result = 0;

        for (int i = N - 1; i >= 0; i--) {
            int coin = coins[i];

            if (coin > K) {
                continue;
            } else {
                int cnt = K / coin;
                K -= coin * cnt;
                result += cnt;
            }
        }

        System.out.println(result);
    }

    public static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
