package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class cod_3 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] A = new int[6];

    static void input() {
        for (int i = 0; i < 6; i++)
            A[i] = scan.nextInt();
    }

    static int pro() {
        Arrays.sort(A);

        HashSet<Integer> nA = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (!nA.contains(A[i])) nA.add(A[i]);
            else nA.remove(A[i]);
        }

        ArrayList<Integer> al = new ArrayList<>(nA);
        return al.get(0);
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
