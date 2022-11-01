package boj.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Class> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            queue.add(new Class(start, end));
        }

        // 강의실 개수 구하기
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(queue.poll().end); // 첫번째 강의의 종료시간 삽입

        while (!queue.isEmpty()) {
            int endTime = pq.peek();

            Class tmp = queue.poll();

            if (tmp.start >= endTime) { // 강의실 추가 없이 수업을 이어서 할 수 있음
                pq.poll();
            }
            pq.add(tmp.end);
        }

        System.out.println(pq.size());
    }
}

class Class implements Comparable<Class>{
    int start;
    int end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 시작 시간을 기준으로 오름차순 정렬
    // 시작 시간이 같으면 종료 시간을 기준으로 오름차순 정렬
    @Override
    public int compareTo(Class o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}
