package boj.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] < B) {
                result++;
            } else {
                arr[i] -= B;
                if (arr[i] % C == 0) {
                    result += arr[i] / C + 1;
                } else {
                    result += arr[i] / C + 2;
                }
            }
        }

        System.out.println(result);
    }
}
