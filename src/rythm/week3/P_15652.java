package rythm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과M 4
public class P_15652 {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        int[] arr = new int[M];
        search(0, arr, 1);

        System.out.println(sb);
    }

    static public void search(int depth, int[] arr, int start) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            search(depth + 1, arr, i);
        }
    }
}

