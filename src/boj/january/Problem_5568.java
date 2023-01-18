package boj.january;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Problem_5568 {
    static boolean[] visited;
    static Set<Integer> set;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        set = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        search(arr, "", K);

        System.out.println(set.size());
    }

    public static void search(String[] arr, String str, int K) {
        if (K == 0) {
            set.add(Integer.parseInt(str));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                search(arr, str + arr[i], K - 1);
                visited[i] = false;
            }
        }
    }
}
