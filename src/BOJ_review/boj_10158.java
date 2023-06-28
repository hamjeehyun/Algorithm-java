package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10158 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int w, h, p, q, t;

    static void input() {
        w = scan.nextInt();
        h = scan.nextInt();
        p = scan.nextInt();
        q = scan.nextInt();
        t = scan.nextInt();
    }

    static void pro() {
        int currentX = (p + t) % (2 * w);
        int currentY = (q + t) % (2 * h);

        if (currentX > w) currentX = 2 * w - currentX;
        if (currentY > h) currentY = 2 * h - currentY;

        sb.append(currentX).append(" ").append(currentY);
        System.out.println(sb);
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
