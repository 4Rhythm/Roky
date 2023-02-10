package rythm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P_1092 {
    static int boxP;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] ships = new Integer[N];
        for (int i = 0; i < N; i++) {
            ships[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> boxList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            boxList.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(ships, (v1, v2) -> v2 - v1);
        Collections.sort(boxList, Collections.reverseOrder());

        if (boxList.get(0) > ships[0]) {
            System.out.println(-1);
            return;
        }

        int T = 0;
        while (!boxList.isEmpty()) {
            int shipIndex = 0;
            int boxIndex = 0;

            while (shipIndex < N) {
                if (boxIndex == boxList.size()) {
                    break;
                }
                if (ships[shipIndex] >= boxList.get(boxIndex)) {
                    boxList.remove(boxIndex);
                    shipIndex++;
                } else {
                    boxIndex++;
                }
            }
            T++;
        }
        System.out.println(T);

    }
}
