package boj.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Teaching_1062 {
    static boolean[] alphabet = new boolean[26];
    static int MAX = 0;
    static String[] wordList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        wordList = new String[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String subString = input.substring(4, input.length()-4);
            wordList[i] = subString;
        }
        // anta tica -> a n t i c는 항상 배움 5개
        if (K < 5) {
            System.out.println("0");
            return;
        } else if(K == 26) {
            System.out.println(N);
            return;
        }

        String str = "antatica";
        for (int i = 0; i < str.length(); i++) {
            if (!alphabet[str.charAt(i) - 'a']) {
                alphabet[str.charAt(i) - 'a'] = true;
            }
        }
        // K - 5 단어를 탐색 -> 최대로 읽을 수 있는 단어의 개수 출력
        int index = K - 5;
        search(index, 0, 0);

        System.out.println(MAX);

    }

    // 탐색
    public static void search(int index, int depth, int start) {
        if (index == depth) {
            // N개의 단어를 탐색해서 읽을 수 있는 단어의 개수 구하기
            int tmp  = checkWord();
            MAX = Math.max(tmp, MAX);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!alphabet[i]) {
                alphabet[i] = true;
                search(index, depth + 1, i + 1);
                alphabet[i] = false;
            }
        }
    }

    public static int checkWord() {
        int wordCount = 0;
        for (String str : wordList) {
            boolean check = true;
            for (int i = 0; i < str.length(); i++) {
                if (!alphabet[str.charAt(i) - 'a']) {
                    check = false;
                    break;
                }
            }
            if (check) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
