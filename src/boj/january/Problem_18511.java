package boj.january;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_18511 {
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String number = st.nextToken();
        int N = Integer.parseInt(number);
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[K];
        String[] arr = br.readLine().split(" ");

        for (int i = 1; i <= number.length(); i++) {
            permutation(arr, i, K, N, "");
        }

        System.out.println(max);

    }

    public static void permutation(String[] arr, int count, int length, int target, String num) {
        if (count == 0) {
            int value = Integer.parseInt(num);
            if (value <= target) {
                if (value > max) {
                    max = value;
                }
            }
            return;
        }

        for (int i = 0; i < length; i++) {
            permutation(arr, count - 1, length, target, num + arr[i]);
        }
    }
}

