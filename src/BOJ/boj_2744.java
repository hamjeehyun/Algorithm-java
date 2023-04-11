package BOJ;

import java.util.Scanner;

public class boj_2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder ans= new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z')
                ans.append((char) ('a' + ch - 'A'));
            else
                ans.append((char) ('A' + ch - 'a'));
        }
        System.out.println(ans);
    }
}
