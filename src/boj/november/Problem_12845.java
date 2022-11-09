package boj.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_12845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int max = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input > max) {
                max = input;
                index = i;
            }
            arr[i] = input;
        }
        int total = 0;
        for (int i = 0; i < N; i++) {
            if (i == index) {
                continue;
            }
            total += arr[i];
        }

        int gold = max * (N-1) + total;

        System.out.println(gold);
    }
}
