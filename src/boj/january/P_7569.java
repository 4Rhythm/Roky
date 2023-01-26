package boj.january;

import java.io.*;
import java.util.*;

class Tomato {
    int x, y, z;

    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

// 토마토
public class P_7569 {
    /*
    2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100
     */
    static int N, M, H, T, remainTomato;
    static int[][][] box;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] dz = {1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][M][N];
        List<Tomato> list = new ArrayList<>();
        remainTomato = 0;

        // 입력
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int input = Integer.parseInt(st.nextToken());
                    box[i][j][k] = input;
                    // 익은 토마토 저장
                    if (input == 1) {
                        list.add(new Tomato(j, k, i));
                    } else if (input == 0) {
                        remainTomato++;
                    }
                }
            }
        }

        if (remainTomato == 0) {
            System.out.println(0);
            return;
        }

        T = 0;

        spread(list);

        if (remainTomato != 0) {
            T = -1;
        }
        System.out.println(T);


    }

    public static void spread(List<Tomato> tomatoes) {
        List<Tomato> tmp = new ArrayList<>();

        for (Tomato t : tomatoes) {
            // 4방
            for (int i = 0; i < 4; i++) {
                int nextX = t.x + dx[i];
                int nextY = t.y + dy[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (box[t.z][nextX][nextY] == 0) {
                        box[t.z][nextX][nextY] = 1;
                        tmp.add(new Tomato(nextX, nextY, t.z));
                        remainTomato--;
                    }
                }
            }
            // 위 아래
            for (int i = 0; i < 2; i++) {
                int nextZ = t.z + dz[i];
                if (nextZ >= 0 && nextZ < H) {
                    if (box[nextZ][t.x][t.y] == 0) {
                        box[nextZ][t.x][t.y] = 1;
                        tmp.add(new Tomato(t.x, t.y, nextZ));
                        remainTomato--;
                    }
                }
            }
        }

        if (tmp.size() == 0) {
            return;
        } else {
            T++;
            spread(tmp);
        }

    }

    // 박스에 모든 토마토가 익었는지 검사
    public static boolean checkBox() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
