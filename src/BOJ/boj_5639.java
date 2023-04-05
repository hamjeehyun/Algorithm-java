package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_5639 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer> a;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        a = new ArrayList<>();
        while ((input = br.readLine()) != null) {
            int x = scan.nextInt();
            a.add(Integer.parseInt(input));
        }
    }

    static void traverse(int l, int r) {
        if (l > r) return;
        int mid = r;
        for (int i = l + 1; i <= r; i++) {
            if (a.get(i) > a.get(l)) {
                mid = i - 1;
                break;
            }
        }

        traverse(l + 1, mid);
        traverse(mid + 1, r);
        sb.append(a.get(l)).append('\n');
    }

    static void pro() {
        traverse(0, a.size() - 1);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
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
