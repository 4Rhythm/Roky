package boj.january;
import java.io.*;
// 번데기
public class Problem_15721 {
    /*
    1회차 : 번 데기 번 데기 / 번 번 데기 데기
    n-1회차 : 번 데기 번 데기 / 번 * N 데기 * N
     */
    static int A, p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int flag = Integer.parseInt(br.readLine());

        int[] arr = new int[A];
        p = 0;
        int cnt = 0;
        int n = 2;
        while (true) {
            // 뻔 데기 뻔 데기
            for (int i = 0; i < 4; i++) {
                int tmp = 1;
                if (i % 2 == 0) {
                    tmp = 0;
                }
                if (tmp == flag) {
                    cnt++;
                    if (check(cnt, T)) {
                        return;
                    }
                }
                moveP();
            }

            // 뻔 * n 데기 * n
            for (int i = 0; i < n; i++) {
                arr[p] = 0;
                if (flag == 0) {
                    cnt++;
                    if (check(cnt, T)) {
                        return;
                    }
                }
                moveP();
            }

            for (int i = 0; i < n; i++) {
                arr[p] = 1;
                if (flag == 1) {
                    cnt++;
                    if (check(cnt, T)) {
                        return;
                    }
                }
                moveP();
            }
            n++;
        }

    }

    static void moveP() {
        if (p + 1 >= A) {
            p = 0;
        } else {
            p += 1;
        }
    }

    public static boolean check(int cnt, int T) {
        boolean flag = false;
        if (cnt == T) {
            flag = true;
            System.out.println(p);
        }

        return flag;
    }
}
