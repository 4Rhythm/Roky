package rythm.week5;

import java.io.*;
import java.util.*;

public class P_20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int K = Integer.parseInt(st.nextToken()); // 졸고 있는 학생 수
        int Q = Integer.parseInt(st.nextToken()); // 출석 코드를 보낼 학생 수
        int M = Integer.parseInt(st.nextToken()); // 구간 수

        boolean[] students = new boolean[N + 3];
        boolean[] sleep = new boolean[N + 3];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            sleep[Integer.parseInt(st.nextToken())] = true;
        }

        int[] call = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            call[i] = Integer.parseInt(st.nextToken());
        }

        int[][] sections = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sections[i][0] = start;
            sections[i][1] = end;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < Q; i++) {
            int tmp = 1;
            if (sleep[call[i]]) {
                continue;
            }
            while (true) {
                if (call[i] * tmp > N + 2) {
                    break;
                }
                if (sleep[call[i] * tmp]) {
                    tmp += 1;
                    continue;
                }
                set.add(call[i] * tmp++);
            }
        }

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            students[iterator.next()] = true;
        }

        for (int i = 0; i < M; i++) {
            int start = sections[i][0];
            int end = sections[i][1];

            int count = 0;
            for (int j = start; j <= end; j++) {
                if (j > N + 2) {
                    break;
                }
                if (!students[j]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
        bw.flush();
        bw.close();
    }

}
