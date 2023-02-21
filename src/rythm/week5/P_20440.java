package rythm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
4
2 16
4 10
5 6
10 12
 */
public class P_20440 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] sArr = new int[N];
        int[] eArr = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            set.add(s);
            set.add(e);
            sArr[i] = s;
            eArr[i] = e;
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);



        int[] sum = new int[list.size()];

        for (int i = 0; i < N; i++) {
            int s = Collections.binarySearch(list, sArr[i]);
            int e = Collections.binarySearch(list, eArr[i]);
            for (int j = s; j < e; j++) {
                sum[j]++;
            }
        }
        int max = 0;
        int rs = -1;
        int re = -1;

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > max) {
                max = sum[i];
                rs = i;
                re = i;
            }
            if (sum[i] == max && i - 1 == re) {
                re = i;
            }
        }



        sb.append(max).append("\n");
        sb.append(list.get(rs)).append(" ").append(list.get(re + 1));

        System.out.println(sb);




    }

}
