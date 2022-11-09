package boj.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_4796 {
    public static void main(String[] args) throws IOException {
        /**
         * 연속하는 P일 중, L일동안만 사용 가능
         * 입력은 L P V순
         * 8일중에 5일 사용 가능 -> 20 / 8 = 2 -> 10일 + 나머지 4일 -> 14
         * 5 8 17 -> 10일 + 1일 -> 11일
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            if (L == 0) {
                break;
            }
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            long result = 0;

            result = V / P * L;
            if (V % P > L) {
                result += L;
            } else {
                result += V % P;
            }

            System.out.println("Case " + index++ + ": " + result);
        }
    }
}
