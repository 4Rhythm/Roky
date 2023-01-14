package boj.january;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// DNA
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

        int[] count = new int[4];
        char[] dna = {'A', 'C', 'G', 'T'};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            Arrays.fill(count, 0);
            for (int j = 0; j < N; j++) {
                char tmp = arr[j][i];
                switch (tmp) {
                    case 'A':
                        count[0] += 1;
                        break;
                    case 'C':
                        count[1] += 1;
                        break;
                    case 'G':
                        count[2] += 1;
                        break;
                    case 'T':
                        count[3] += 1;
                        break;
                }
            }
            int max = 0;
            int index = 0;
            for (int k = 0; k < 4; k++) {
                if (count[k] > max) {
                    max = count[k];
                    index = k;
                }
            }
            sb.append(dna[index]);
        }
        String result = sb.toString();
        int sumMin = 0;
        // 거리의 최소 합 구하기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (result.charAt(i) != arr[j][i]) {
                    sumMin += 1;
                }
            }
        }

        System.out.println(sb);
        System.out.println(sumMin);


    }
}
