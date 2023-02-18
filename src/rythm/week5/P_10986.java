package rythm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Long result = 0L;
        long[] arr = new long[(int) (N + 1)];

        // 나머지 배열 0 ~ M-1
        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());

        // (arr[i] - arr[j]) % M == 0
        // arr[i] % M == arr[j] % M
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] + num;
            int remain = (int)(arr[i] % M);
            if (remain == 0) {
                result++;
            }
            count[remain]++;
        }

        // nC2
        for (int i = 0; i < M; i++) {
            if (count[i] >= 2) {
                result += count[i] * (count[i] - 1) / 2;
            }
        }

        System.out.println(result);
    }
}
