package rythm.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1421 {
    static int N, C, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int[] woods = new int[N];

        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(woods);

        int max = 0;

        for (int i = 1; i <= woods[N - 1]; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                int cut = 0;
                if (woods[j] < i) {
                    continue;
                }
                int tmp = woods[j] / i;

                cut += tmp;

                if (woods[j] % i == 0) {
                    cut--;
                }

                if (i * W * tmp - cut * C > 0) {
                    sum += i * W * tmp - cut * C;
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }

}
/*
3 1000 10
100
1000
10

4 1000 1
2
1
1
1
 */
