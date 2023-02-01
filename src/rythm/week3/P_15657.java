package rythm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과M 8
public class P_15657 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        sb = new StringBuilder();

        int[] tmp = new int[M];
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        search(0, tmp, 1);

        System.out.println(sb);
    }

    static public void search(int depth, int[] tmp, int start) {
        if (depth == M) {
            for (int i : tmp) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            tmp[depth] = arr[i];
            search(depth + 1, tmp, i);
        }
    }
}

