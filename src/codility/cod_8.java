package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cod_8 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] A = new int[4];

    static void input() {
        for (int i = 0; i < 4; i++)
            A[i] = scan.nextInt();
    }

    static int pro() {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (i + 1 != A[i]) return 0;
        }

        return 1;
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
