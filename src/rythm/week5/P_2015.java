package rythm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P_2015 {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        long result = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            if (arr[i] == K) {
                result++;
            }
        }

        Map<Integer, Long> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            if (map.containsKey(arr[i] - K)) {
                result += map.get(arr[i] - K);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
        }


        System.out.println(result);
    }
}
