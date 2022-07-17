package boj.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemoteController_1107 {
    /**
     * 리모컨 클릭 수 -> 숫자 + (+,-) 버튼으로 이동하는 횟수
     *
     */
    static boolean[] remote;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 원하는 채널
        int M = Integer.parseInt(br.readLine());
        int now = 100;
        remote = new boolean[10];
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                remote[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int answer = Math.abs(N - now); // 직접 이동
        int min = 987654321;
        int cnt = 0;
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean skip = false;
            for (int j = 0; j < str.length(); j++) {
                if (remote[str.charAt(j) - '0']) {
                    skip = true;
                    break;
                }
            }
            if (skip) {
                continue;
            }
            cnt = str.length() + Math.abs(i - N);

            min = Math.min(cnt, min);

        }
        System.out.println(Math.min(answer, min));
    }
}
