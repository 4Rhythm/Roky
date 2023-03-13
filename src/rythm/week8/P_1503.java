package rythm.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[1002];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            check[Integer.parseInt(st.nextToken())] = true;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 1001; i++) {
            if (check[i]) {
                continue;
            }
            for (int j = 1; j <= 1001; j++) {
                if (check[j]) {
                    continue;
                }
                for (int k = 1; k <= 1001; k++) {
                    if (check[k]) {
                        continue;
                    }
                    result = Math.min(result, Math.abs(N - (i * j * k)));
                }
            }
        }

        System.out.println(result);


    }

}
