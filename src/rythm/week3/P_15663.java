package rythm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// N과M 9
public class P_15663 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;
    static Set<String> set;

    /*
    3 1
    1 19 2
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        set = new LinkedHashSet<>();
        int[] tmp = new int[M];
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        search(0, tmp);

        for (String value : set) {
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }

    static public void search(int depth, int[] tmp) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : tmp) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                search(depth + 1, tmp);
                visited[i] = false;
            }
        }
    }
}

