package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16472 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, kind;
    static String A;
    static int[] cnt;

    static void input() {
        N = scan.nextInt();
        A = scan.nextLine();
        cnt = new int[26];
    }

    static void add(char x) {
        cnt[x - 'a']++;
        if (cnt[x - 'a'] == 1) kind++;
    }

    static void erase(char x) {
        cnt[x - 'a']--;
        if (cnt[x - 'a'] == 0) kind--;
    }

    static void solution() {
        int len = A.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            add(A.charAt(R));

            while (kind > N) {
                erase(A.charAt(L++));
            }

            ans = Math.max(ans, R - L + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solution();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
