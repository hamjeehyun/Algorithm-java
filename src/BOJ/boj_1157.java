package BOJ;

import java.util.Scanner;

public class boj_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

        int start = 0;
        int cnt = 0;

        while (true) {
            int cur = doc.indexOf(word, start);
            if (cur < 0)
                break;
            cnt++;
            start = cur + word.length();
        }

        System.out.println(cnt);
    }
}
