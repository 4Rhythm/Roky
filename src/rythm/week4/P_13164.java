package rythm.week4;

import java.io.*;
import java.util.*;

/**
 * N명을 K개의 조로 분리
 * 각 조에는 원생이 적어도 1명
 * 조에서 가장 큰 원생, 가장 작은 원생의 키 차이 -> 비용
 * 최소 비용
 *
 */

class Node implements Comparable<Node> {
    int index;
    int diff;

    public Node(int index, int diff) {
        this.index = index;
        this.diff = diff;
    }

    @Override
    public int compareTo(Node o) {
        return o.diff - this.diff;
    }
}
public class P_13164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // 탐색을 진행하면서 K개 만큼 숫자간의 차이가 가장 큰 수 저장
        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            pq.add(new Node(i, diff));
        }

        // ex) 4 3 2 2 가 나오고 K가 3일 때, 2가지 경우의 수를 확인
        List<Integer> list = new ArrayList<>();
        while (K - 1 > 0) {
            Node node = pq.poll();
            list.add(node.index);

            K--;
        }

        Collections.sort(list);

        int start = 0;
        int end = 0;
        int result = 0;
        for (int index : list) {
            end = index;
            int min = arr[start];
            int max = arr[end];

            result += (max - min);

            start = end + 1;
        }
        result += arr[N - 1] - arr[start];

        System.out.println(result);
        bw.flush();
        bw.close();
    }

}
