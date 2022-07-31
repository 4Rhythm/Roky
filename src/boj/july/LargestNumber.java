package boj.july;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class LargestNumber {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 0, 0, 0};

        String result = solution(numbers);
        System.out.println(result);
    }

    /**
     * 숫자 범위 : 0 ~ 1000
     * 정수를 이어 붙여 만들 수 있는 가장 큰 정수
     * 6, 10, 2 -> 6210
     */
    public static String solution(int[] numbers) {
        String answer = "";

        // 30 33 60 90 9 9 1 12 2 13 3

        String[] buff = new String[numbers.length];
        int tmp = 0;

        for (int number : numbers) {
            buff[tmp++] = String.valueOf(number);
        }
        // 문자열 정렬
        Arrays.sort(buff, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        // 1 30 34 3
        // 1 30 3 34

        StringBuilder sb = new StringBuilder();

        for (int i = buff.length - 1; i >= 0; i--) {
            sb.append(buff[i]);
        }

        if (sb.toString().charAt(0) == '0') { // 0000
            return "0";
        } else {
            answer = sb.toString();
        }

        return answer;
    }
}
