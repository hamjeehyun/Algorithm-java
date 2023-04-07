package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class cod_6 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] A = new int[5];

    static void input() {
        for (int i = 0; i < 5; i++)
            A[i] = scan.nextInt();
    }

    static int pro() {
        List<Integer> result = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < A.length; i++)
            sum += A[i];

        int left = 0;
        int right = 0;
        for (int P = 1; P < A.length - 1; P++) {
            left += A[P - 1];
            right = sum - left;

            result.add(Math.abs(left - right));
        }

        return Collections.min(result);
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
