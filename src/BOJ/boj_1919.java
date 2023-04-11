package BOJ;

import java.util.Scanner;

public class boj_1919 {
    static int[] getCount(String str) {
        int count[] = new int[26];

        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'a']++;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 없애야만 하는 문자 : 공통 문자를 제외한 부분
        String a = sc.next();
        String b = sc.next();

        int[] countA = getCount(a);
        int[] countB = getCount(b);

        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans += Math.abs(countA[i] - countB[i]);
        System.out.println(ans);
    }
}
