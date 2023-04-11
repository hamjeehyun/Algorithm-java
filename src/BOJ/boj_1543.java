package BOJ;

import java.util.Scanner;

public class boj_1543 {
    static int[] getCount(String str) {
        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++)
            cnt[str.charAt(i) - 'A']++;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        A = A.toUpperCase();

        int[] cnt = getCount(A);

        int maxCnt = -1;
        char maxA = '?';
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = Math.max(maxCnt, cnt[i]);
                maxA = (char) (i + 'A');
            } else if (cnt[i] == maxCnt) {
                maxA = '?';
            }
        }
        System.out.println(maxA);
    }
}
