package rythm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P_4659 {
    static String[] vowel = {"a", "e", "i", "o", "u"};
    static Map<Character, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] result = {"is acceptable.", "is not acceptable."};
        map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);

        while (true) {
            String str = br.readLine();

            if (str.equals("end")) {
                break;
            }

            sb.append("<" + str + "> ");
            sb.append(result[check(str)]);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static int check(String str) {
        boolean flag1 = false;
        boolean flag2 = true;
        int ja = 0;
        int mo = 0;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                flag1 = true;
                ja = 0;
                mo++;
            } else {
                ja++;
                mo = 0;
            }

            if (ja == 3 || mo == 3) {
                flag2 = false;
                break;
            }
        }

        if (!flag1 || !flag2) {
            return 1;
        }

        boolean check = false;
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            if (c1 != 'e' && c1 != 'o') {
                char c2 = str.charAt(i + 1);
                if (c1 == c2) {
                    return 1;
                }
            } else {
                if (!check) {
                    if (str.charAt(i + 1) == c1) {
                        check = true;
                    }
                } else {
                    if (str.charAt(i + 1) == c1) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

}
