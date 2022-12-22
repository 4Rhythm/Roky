package boj.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Problem_1967 {
    static class Node {
        int weight;
        int num;

        public Node(int num, int weight) {
            this.weight = weight;
            this.num = num;
        }
    }

    static int farthestNode;
    static int max;
    static List<Node>[] nodeArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        max = 0;
        farthestNode = 0;
        nodeArr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodeArr[input[0]].add(new Node(input[1], input[2]));
            nodeArr[input[1]].add(new Node(input[0], input[2]));

        }

        // 루트로부터 가중치가 가장 큰 노트 탐색
        visited[1] = true;
        dfs(1, 0);

        // 초기화
        Arrays.fill(visited, false);
        max = 0;
        visited[farthestNode] = true;

        // 탐색
        dfs(farthestNode, 0);

        System.out.println(max);
        System.exit(0);
    }

    public static void dfs(int num, int sum) {
        if (sum > max) {
            max = sum;
            farthestNode = num;
        }

        for (Node node : nodeArr[num]) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, sum + node.weight);
            }
        }
    }

    public static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
