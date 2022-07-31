package boj.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 단방향 그래프
 * 그래프 인접행렬 -> 인접리스트로 해결 가능
 * 노드별 dfs 탐색 후 상태 배열로 행 생성
 */
public class FindThePath_11403 {

    static boolean[][] status;
    static boolean[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        status = new boolean[N][N];
        result = new boolean[N][N];

        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 입력 값 -> 그래프 연결
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        if (N == 1) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < N; i++) {
            // dfs
            search(graph, i, i);
            for (int j = 0; j < N; j++) {
                Arrays.fill(status[j], false);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (result[i][j]) {
                    sb.append("1 ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void search(List<List<Integer>> graph, int index, int start) {
        List<Integer> list = graph.get(index);

        for (int i : list) {
            result[start][i] = true;
            if (!status[index][i]) {
                status[index][i] = true;
                search(graph, i, start);
            }
        }
    }
}
