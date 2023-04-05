package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1991 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] child;

    static void input() {
        N = scan.nextInt();
        child = new int[30][2]; // 1 <= N <= 26 , 양쪽 자식 노드 저장
        for (int i = 0; i < N; i++) {
            char curCh = scan.next().charAt(0);
            int cur = curCh - 'A';
            for (int k = 0; k < 2; k++) {
                char ch = scan.next().charAt(0);
                if (ch != '.') child[cur][k] = ch - 'A';
                else child[cur][k] = -1;
            }
        }
    }

    static void in_order(int x) {
        if (x == -1) return;
        in_order(child[x][0]);
        sb.append((char) (x + 'A'));
        in_order(child[x][1]);
    }

    static void pre_order(int x) {
        if (x == -1) return;
        sb.append((char) (x + 'A'));
        pre_order(child[x][0]);
        pre_order(child[x][1]);
    }

    static void post_order(int x) {
        if (x == -1) return;
        post_order(child[x][0]);
        post_order(child[x][1]);
        sb.append((char) (x + 'A'));
    }

    static void pro() {
        pre_order(0);
        sb.append('\n');
        in_order(0);
        sb.append('\n');
        post_order(0);

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
