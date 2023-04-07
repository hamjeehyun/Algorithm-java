package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class cod_7 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int X;
    static int[] A = new int[8];

    static void input() {
        X = scan.nextInt();
        for (int i = 0; i < 8; i++)
            A[i] = scan.nextInt();
    }

    static int pro() {
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            s.add(A[i]);

            if(s.size() == X)
                return i;
        }

        return -1;
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
