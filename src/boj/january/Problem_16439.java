package boj.january;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Problem_16439 {
    static int N, M;
    static boolean[] visited;
    static int[] maxArr, index;
    static int[][] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        maxArr = new int[N];
        index = new int[3];
        result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[M];

        search(3);
        System.out.println(result);

    }

    public static void search(int count) {
        if (count == 0) {
            setMaxHappy();
            int sum = 0;
            for (int i = 0; i < maxArr.length; i++) {
                sum += maxArr[i];
            }

            result = Math.max(sum, result);
            return;
        }

        for (int i = 0; i < M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                search( count - 1);
                visited[i] = false;
            }
        }
    }

    public static void setMaxHappy() {
        Arrays.fill(maxArr, 0);
        for (int i = 0; i < M; i++) {
            if (visited[i]) {
                for (int j = 0; j < N; j++) {
                    if (maxArr[j] < arr[j][i]) {
                        maxArr[j] = arr[j][i];
                    }
                }
            }
        }
    }
}
