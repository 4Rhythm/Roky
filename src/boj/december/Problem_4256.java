package boj.december;

import java.io.*;
import java.util.stream.Stream;

// 트리 골드2
public class Problem_4256 {

    static int[] preorder;
    static int[] inorder;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            T--;
            N = Integer.parseInt(br.readLine());
            preorder = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            inorder = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb = new StringBuilder();

            search(0, 0, N);
            System.out.println(sb);

        }

    }

    public static void search(int rootIndex, int start, int end) {
        if (rootIndex >= N) {
            return;
        }
        int root = preorder[rootIndex];

        for (int i = start; i < end; i++) {
            if (root == inorder[i]) {
                // left
                search(rootIndex + 1, start, i);
                // right
                search(rootIndex + i + 1 - start, i + 1, end);
                sb.append(root).append(" ");
            }
        }
    }

}
