package boj.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Time implements Comparable<Time>{
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 종료 시간은 기준으로 오름차순
    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}

public class Problem_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());
        StringTokenizer st;

        PriorityQueue<Time> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = atoi(st.nextToken());
            int end = atoi(st.nextToken());

            queue.add(new Time(start, end));
        }

        int count = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            Time node = queue.poll();
            if (node.start >= time) {
                count++;
                time = node.end;
            }
        }

        System.out.println(count);
    }

    private static int atoi(String str) {
        return Integer.parseInt(str);
    }
}
