package boj.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gear_14891 {
    /**
     * 12시부터 순서대로 8개의 정수를 입력 -> 0 : N극 / 1 : S극
     * 1번 톱니바퀴 : 2번 인덱스
     * 2번, 3번 톱니바퀴 : (좌)6번, (우)2번
     * 4번 : (좌)6번
     *
     * 회전시 서로 다른 극일때만 회전함
     * 3번 시계 회전 -> 2번 반시계 회전 -> if 1번의 2번 인덱스와 2번의 6번 인덱스가 서로 같은 극이면 1번 회전 x
     *
     * 최종 톱니바퀴 상태에서 12시 극을 확인하고 점수 측정
     */
    static int[][] gears = new int[4][8];
    static int[] check = new int[4];
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = input.charAt(j) - '0';
            }
        }

        int K = atoi(br.readLine());
        int[][] command = new int[K][2];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            command[i][0] = atoi(st.nextToken());
            command[i][1] = atoi(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            int index = command[i][0] - 1;
            int dir = command[i][1];

            func(index, dir);
        }

        int result = getResult();

        System.out.println(result);

    }

    private static void func(int index, int dir) {
        if (index == 0) {
            int tmp = dir * -1;
            check[0] = dir;
            for (int i = 0; i < 3; i++) {
                if (checkRight(i)) {
                    check[i+1] = tmp;
                    tmp *= -1;
                } else {
                    break;
                }
            }
        } else if (index == 1) {
            check[1] = dir;
            if (checkLeft(1)) {
                check[0] = dir * -1;
            }

            if (checkRight(1)) {
                check[2] = dir * -1;
                if (checkRight(2)) {
                    check[3] = dir;
                }
            }
        } else if (index == 2) {
            check[2] = dir;
            if (checkLeft(2)) {
                check[1] = dir * -1;
                if (checkLeft(1)) {
                    check[0] = dir;
                }
            }
            if (checkRight(2)) {
                check[3] = dir * -1;
            }
        } else if (index == 3) {
            int tmp = dir * -1;
            check[3] = dir;
            for (int i = 3; i > 0; i--) {
                if (checkLeft(i)) {
                    check[i - 1] = tmp;
                    tmp *= -1;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (check[i] == 1) {
                rotateClockwise(i);
            } else if (check[i] == -1) {
                rotateAntiClockwise(i);
            }
        }

        Arrays.fill(check, 0);

    }

    private static boolean checkLeft(int index) {
        int tmp = gears[index][6];
        int neighbor = gears[index - 1][2];

        return !(tmp == neighbor);
    }

    private static boolean checkRight(int index) {
        int tmp = gears[index][2];
        int neighbor = gears[index + 1][6];

        return !(tmp == neighbor);
    }

    // 시계 방향 회전
    private static void rotateClockwise(int index) {
        int[] buff = new int[8];

        for (int i = 0; i < buff.length - 1; i++) {
            buff[i + 1] = gears[index][i];
        }
        buff[0] = gears[index][7];

        gears[index] = buff.clone();
    }

    // 반시계 방향 회전
    private static void rotateAntiClockwise(int index) {
        int[] buff = new int[8];

        for (int i = 0; i < buff.length - 1; i++) {
            buff[i] = gears[index][i + 1];
        }
        buff[7] = gears[index][0];

        gears[index] = buff.clone();
    }

    private static int getResult() {
        int result = 0;

        if (gears[0][0] == 1) {
            result += 1;
        }
        if (gears[1][0] == 1) {
            result += 2;
        }
        if (gears[2][0] == 1) {
            result += 4;
        }
        if (gears[3][0] == 1) {
            result += 8;
        }

        return result;
    }

    private static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
