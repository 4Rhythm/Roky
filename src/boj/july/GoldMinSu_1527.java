package boj.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldMinSu_1527 {
    /**
     * 4와 7로 이루어진 수
     * 금민수의 개수 출력
     * <p>
     * 4, 7, 47, 74, 77, 444, 447, 474, ...
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        a = Integer.parseInt(A);
        b = Integer.parseInt(B);
        search(0);

        System.out.println(cnt);
    }
    static int a, b;
    static int cnt = 0;
    public static void search(int input) {
        if (input > b) {
            return;
        }

        if (input >= a && input <= b) {
            cnt++;
        }

        search(input * 10 + 4);
        search(input * 10 + 7);
    }
}
