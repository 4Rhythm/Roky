package rythm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1749 {
    static int[][] arr, prefix;
    static int N,M;
    static long result = Long.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        prefix = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefix[i][j] = arr[i][j] + prefix[i][j-1] + prefix[i-1][j] - prefix[i-1][j-1];
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                search(i, j);
            }
        }

        System.out.println(result);


    }

    private static void search(int x, int y) {
        int lx = x;
        int ly = y - 1;
        int rx = x - 1;
        int ry = y;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                long sum = prefix[x][y] - prefix[lx][ly - j] - prefix[rx - i][ry] + prefix[rx - i][ly - j];
                result = Math.max(result, sum);
            }
        }
    }
}
