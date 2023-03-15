package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11652 {
    static FastReader scan = new FastReader();

    static int N;
    static long[] cards;

    static void input() {
        N = scan.nextInt();
        cards = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            cards[i] = scan.nextLong();
        }
    }

    static void pro() {
        Arrays.sort(cards, 1, N+1);
        int curCnt = 1, modeCnt = 1; // 현재 카운트, 최고 카운트
        long mode = cards[1]; // 최빈값

        for (int i = 2; i <= N; i++) {
            if (cards[i - 1] == cards[i]) {
                // 이전거 == 지금거
                curCnt++;
            } else {
                curCnt = 1;
            }
            if (curCnt > modeCnt) {
                modeCnt = curCnt;
                mode = cards[i];
            }
        }
        System.out.println(mode);
    }

    public static void main(String[] args) {
        input();
        pro();
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

        Long nextLong() {
            return Long.parseLong(next());
        }
    }
}
