package boj.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Grade implements Comparable<Grade>{
    int x;
    int y;

    public Grade(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Grade o) {
        return this.x - o.x;
    }
}

public class Problem_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());


            // 서류 성적을 내림차순으로 정렬
            PriorityQueue<Grade> documentRankQueue = new PriorityQueue<>(new Comparator<Grade>() {
                @Override
                public int compare(Grade o1, Grade o2) {
                    return o2.x - o1.x;
                }
            });
            // 인터뷰 성적을 내림차순으로 정렬
            PriorityQueue<Grade> interviewRankQueue = new PriorityQueue<>(new Comparator<Grade>() {
                @Override
                public int compare(Grade o1, Grade o2) {
                    return o2.y - o1.y;
                }
            });

            PriorityQueue<Grade> inputQueue = new PriorityQueue<>();

            StringTokenizer st;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                Grade grade = new Grade(document, interview);

                inputQueue.add(grade);
            }

            // 초기 설정
            Grade grade = inputQueue.poll();
            documentRankQueue.add(grade);
            interviewRankQueue.add(grade);

            while (!inputQueue.isEmpty()) {
                Grade temp = inputQueue.poll();

                Grade document = documentRankQueue.peek();
                Grade interview = interviewRankQueue.peek();

                if (temp.y < interview.y) {
                    if (temp.x > document.x && temp.y > document.y) { // 적어도 1개는 성적이 좋아야함
                        continue;
                    }
                    documentRankQueue.add(temp);
                    interviewRankQueue.add(temp);
                }
            }
            System.out.println(interviewRankQueue.size());
        }



    }
}
