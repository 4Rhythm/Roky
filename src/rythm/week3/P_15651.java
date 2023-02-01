package rythm.week3;

import java.io.*;
import java.util.StringTokenizer;

// N과M 3
public class P_15651 {
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
        search(0, arr);

        System.out.println(sb);
    }

    static public void search(int depth, int[] arr) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            search(depth + 1, arr);
        }
    }
}

