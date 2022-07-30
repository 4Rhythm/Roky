package boj.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RotatingQueue_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[M];

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // deque 구현 -> 무조건 왼쪽에선만 꺼내야됨
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            int target = dq.indexOf(arr[i]);
            int mid = 0;
            if (dq.size() % 2 == 0) {
                mid = dq.size() / 2 - 1;
            } else {
                mid = dq.size() / 2;
            }

            if (target <= mid) {
                // 왼쪽에서 제거
                for (int j = 0; j < target; j++) {
                    int tmp = dq.pollFirst();
                    dq.addLast(tmp);
                    count++;
                }
            } else {
                // 오른쪽에서 제거
                for (int j = 0; j < dq.size() - target; j++) {
                    int tmp = dq.pollLast();
                    dq.addFirst(tmp);
                    count++;
                }
            }
            dq.pollFirst();
        }

        System.out.println(count);
    }

}
