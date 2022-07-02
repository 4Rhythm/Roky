package boj.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alarm_2884 {
    public static void main(String[] args) throws IOException {
        // 45분 일찍 알람 설정하기
        // 0 <= h <= 23
        // 0 <= m <= 59
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        // 10 10 -> 9 25
        if (min < 45) {
            min = 60 + min - 45;
            if (hour == 0) {
                hour = 23;
            } else {
                hour--;
            }
        } else {
            min -= 45;
        }

        System.out.println(hour + " " + min);
    }
}
