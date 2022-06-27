package boj.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalReading_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Character>[] qList = new Queue[5];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            qList[i] = new LinkedList<>();
            if (input.length() > maxLen) {
                maxLen = input.length();
            }
            for (int j = 0; j < input.length(); j++) {
                qList[i].add(input.charAt(j));
            }
        }
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        while (cnt < maxLen) {
            for (int i = 0; i < 5; i++) {
                if (!qList[i].isEmpty()) {
                    sb.append(qList[i].poll());
                }
            }
            cnt++;
        }

        System.out.println(sb);
    }
}
