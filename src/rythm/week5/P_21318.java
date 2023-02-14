package rythm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] music = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int Q = Integer.parseInt(br.readLine());

        int[][] section = new int[Q][2];
        StringTokenizer st;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            section[i][0] = Integer.parseInt(st.nextToken()) - 1;
            section[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        long[] prefix = new long[N];
        if (N > 1) {
            if (music[0] > music[1]) {
                prefix[0] = 1;
            }
        }
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1];
            if (music[i - 1] > music[i]) {
                prefix[i] += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(prefix[section[i][1]] - prefix[section[i][0]]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
