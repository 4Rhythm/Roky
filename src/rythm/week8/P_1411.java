package rythm.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P_1411 {
    static int N;
    static String[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        inputs = new String[N];
        Map<Integer, Integer>[] mapArr = new HashMap[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            mapArr[i] = new HashMap<>();
            for (int j = 0; j < input.length(); j++) {
                mapArr[i].put(input.charAt(j) - 'a', mapArr[i].getOrDefault(input.charAt(j) - 'a', j));
            }
            inputs[i] = input;
        }
        int len = inputs[0].length();

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // 문자 2개 비교
                String a = inputs[i];
                String b = inputs[j];

                String tmpA = "";
                String tmpB = "";
                Map<Integer, Integer> mapA = mapArr[i];
                Map<Integer, Integer> mapB = mapArr[j];
                for (int k = 0; k < len; k++) {
                    tmpA += mapA.get(a.charAt(k) - 'a');
                    tmpB += mapB.get(b.charAt(k) - 'a');
                }

                if (tmpA.equals(tmpB)) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

}
