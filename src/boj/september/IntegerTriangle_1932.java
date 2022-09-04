package boj.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IntegerTriangle_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());

        int[][] arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], -1);
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j++] = atoi(st.nextToken());
            }
        }

        int maxArr[][] = new int[N][N];
        maxArr[0][0] = arr[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) { // 왼쪽 끝 노드
                    maxArr[i][j] = maxArr[i-1][j] + arr[i][j];
                } else if (j == i) { // 오른쪽 끝 노드
                    maxArr[i][j] = maxArr[i-1][j-1] + arr[i][j];
                } else {
                    maxArr[i][j] = Math.max(maxArr[i-1][j-1], maxArr[i-1][j]) + arr[i][j];
                }
            }
        }
        int[] result = maxArr[N-1];
        Arrays.sort(result);
        System.out.println(result[N-1]);
    }

    public static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
