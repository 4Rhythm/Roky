package boj.june;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RoadAndTrafficLight_2980 {
    public static void main(String[] args) throws IOException {
        /**
         * 1초에 1미터 이동
         * 신호는 D가 증가하는 순서
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Light> lights = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lights.add(new Light(l, r, b));
        }

        int location = 0;
        int time = 0;

        while (!lights.isEmpty()) {
            Light light = lights.poll();
            int distance = light.loc - location;
            location += distance;

            time += distance;
            if ((time % (light.red + light.blue) < light.red)) {
                // 빨간불
                time += light.red - (time % (light.red + light.blue));

            }

        }
        time += L - location;
        System.out.println(time);
    }
}

class Light {
    int loc;
    int red;
    int blue;

    public Light(int loc, int red, int blue) {
        this.loc = loc;
        this.red = red;
        this.blue = blue;
    }
}
