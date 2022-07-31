package boj.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1번 컴퓨터 감염
 */
class Graph {
    List<List<Integer>> graph;

    public Graph (int size) {
        graph = new ArrayList<>();
        init(size);
    }

    private void init(int size) {
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void put(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public List<Integer> getNode(int x) {
        return graph.get(x);
    }


}

public class Virus_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        status = new boolean[N];
        Arrays.fill(status, false);

        // 그래프 생성
        Graph graph = new Graph(N);

        // 그래프 연결
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.put(x - 1, y - 1);
        }

        // 그래프 탐색
        search(graph, 0);

        // 1번 컴퓨터를 제외한 감염된 컴퓨터 개수
        int result = -1;
        for (int i = 0; i < N; i++) {
            if (status[i]) {
                result++;
            }
        }

        System.out.println(result);
    }
    static boolean[] status;
    public static void search(Graph graph, int index) {
        List<Integer> list = graph.getNode(index);
        status[index] = true;

        for (int i : list) {
            if (!status[i]) {
                search(graph, i);
            }
        }
    }
}
