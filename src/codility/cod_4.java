package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cod_4 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int X, Y, D;

    static void input() {
        X = scan.nextInt();
        Y = scan.nextInt();
        D = scan.nextInt();
    }

    static int pro() {
        int a = Y - X;

        if (a % D > 0) return (a / D) + 1;
        return a / D;
    }

    public static void main(String[] args) {
        input();
        System.out.println(pro());
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
