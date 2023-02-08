package rythm.week4;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}
public class P_19598 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Meeting(start, end));
        }

        // 끝나는 시간들이 들어가는 우선순위 큐
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        Meeting first = pq.poll();
        rooms.add(first.end);
        while (!pq.isEmpty()) {
            if (pq.peek().start >= rooms.peek()) {
                rooms.poll();
            }
            rooms.add(pq.poll().end);
        }

        System.out.println(rooms.size());

        bw.flush();
        bw.close();
    }

}

/*
5
0 5
0 10
8 10
10 20
15 50

4
0 15
5 20
18 22
16 25
 */