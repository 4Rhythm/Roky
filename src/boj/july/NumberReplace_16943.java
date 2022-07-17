package boj.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberReplace_16943 {
    /**
     * A의 순열 중 B보다 작으면서 가장 큰 C
     * 0으로 시작 불가능
     * C가 없으면 -1 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        len = A.length();
        visited = new boolean[len];

        if (A.length() > String.valueOf(B).length()) {
            System.out.println(-1);
            return;
        }

        // dfs
        dfs(0, A, "");
        int answer = -1;
        for (int i : arr) {
            if (i <= B) {
                answer = Math.max(answer, i);
            }
        }
        System.out.println(answer);

    }
    static boolean[] visited;
    static int len;
    static List<Integer> arr = new ArrayList<>();
    public static void dfs(int depth, String str, String result) {
        if (depth == str.length()) {
            arr.add(Integer.parseInt(result.toString()));
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                if (depth == 0 && str.charAt(i) - '0' == 0) {
                    continue;
                }
                visited[i] = true;
                dfs(depth + 1, str, result + (str.charAt(i) - '0'));
                visited[i] = false;
            }
        }
    }
}
