package boj.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2422 {
    /*
    N : 아이스크림 종류
    M : 섞으면 안되는 조합의 개수
     */
    static int cnt, N, M;
    static boolean[] visited;
    static boolean[][] check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        sb = new StringBuilder();
        check = new boolean[N][N];
        for (boolean[] arr : check) {
            Arrays.fill(arr, true);
        }

        for (int i = 0; i < N; i++) {
            check[i][i] = false;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a-1][b-1] = false;
            check[b-1][a-1] = false;
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (!check[i][j] || !check[j][i]) {
                    continue;
                }
                for (int k = j; k < N; k++) {
                    if (!check[j][k] || !check[k][j] || !check[i][k] || !check[k][i])
                        continue;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
