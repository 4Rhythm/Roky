package boj.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        char[] dna = {'A', 'C', 'G', 'T'};
        int[] count = new int[4];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char c = arr[j][i];
                for (int k = 0; k < 4; k++) {
                    if (c == dna[k]) {
                        count[k]++;
                    }
                }
            }
            int max = 0;
            int index = 0;
            for (int j = 0; j < 4; j++) {
                if (count[j] > max) {
                    index = j;
                    max = count[j];
                }
            }
            sb.append(dna[index]);
            Arrays.fill(count, 0);
        }

        int totalDistance = 0;
        for (int i = 0; i < N; i++) {
            int distance = 0;
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != sb.charAt(j)) {
                    distance++;
                }
            }
            totalDistance += distance;
        }

        System.out.println(sb);
        System.out.println(totalDistance);
    }
}
