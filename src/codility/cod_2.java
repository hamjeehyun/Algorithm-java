package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cod_2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K;
    static int[] A = new int[5];

    static void input() {
        for (int i = 0; i < 5; i++)
            A[i] = scan.nextInt();
        K = scan.nextInt();
    }

    static int[] pro() {
        // 배열의 길이
        int len = A.length;
        int[] nA = new int[len];

        // 옮겨가는 위치 = (원래 위치 + K) % 배열의 길이
        for (int i = 0; i < len; i++)
            nA[(i + K) % len] = A[i];

        return nA;
    }

    public static void main(String[] args) {
        input();
        int[] result = pro();
        for (int i = 0; i < 5; i++)
            sb.append(result[i]).append(' ');
        System.out.println(sb);
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
