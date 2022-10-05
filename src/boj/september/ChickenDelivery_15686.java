package boj.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Chicken {
    int x, y;

    public Chicken(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Home {
    int x, y;

    public Home(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class ChickenDelivery_15686 {
    /**
     * 0 : 빈칸 / 1 : 집 / 2: 치킨집
     * 치킨 거리 : |r1 - r2| + |c1 - c2|
     * 도시에 있는 치킨집 중에서 최대 M개를 고르고 나머지는 폐업
     * 도시의 치킨 거리가 가장 작게 되는 경우 -> 모든 거리의 합이 최소
     */
    static int N, M;
    static int result = Integer.MAX_VALUE;
    static int[][] city;
    static List<Chicken> chickenList = new ArrayList<>();
    static List<Home> homeList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            int j = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int tmp = atoi(st.nextToken());
                city[i][j] = tmp;
                if (tmp == 1) {
                    homeList.add(new Home(i, j));
                }
                if (tmp == 2) {
                    chickenList.add(new Chicken(i, j));
                }
                j++;
            }
        }
        visited = new boolean[chickenList.size()];

        // 최소 거리 구하기
        search(0, 0);
        System.out.println(result);
        br.close();
    }

    private static void search(int depth, int start) {
        if (depth == M) {
            // 거리 측정
            int chickenDistance = getChickenDistance();
            result = Math.min(result, chickenDistance);
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                search(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static int getChickenDistance() {
        int totalDistance = 0;

        for (Home home : homeList) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chickenList.size(); i++) {
                if (visited[i]) {
                    int distance = Math.abs(home.x - chickenList.get(i).x) + Math.abs(home.y - chickenList.get(i).y);
                    min = Math.min(min, distance);
                }
            }
            totalDistance += min;
        }

        return totalDistance;
    }

    private static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
