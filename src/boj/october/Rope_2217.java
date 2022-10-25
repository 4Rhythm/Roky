package boj.october;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rope_2217 {
    /**
     * k개의 로프를 이용해서 w의 최대값을 구하라
     * w/k 만큼의 무게를 모두 동일하게 적용
     * 모든 로프 사용 x
     * 10 15 20 -> 30
     * 5 10 10 10 ->
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;

        for (int i = 0; i < N; i++) {
            int tmp = arr[i] * (N - i);
            if (tmp > max) {
                max = tmp;
            }
        }

        System.out.println(max);
    }
}
