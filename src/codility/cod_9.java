package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cod_9 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A = new int[7];

    static void input() {
        N = 5;
        A = new int[]{3, 4, 4, 6, 1, 4, 4};
//        for (int i = 0; i < 7; i++)
//            A[i] = scan.nextInt();
    }

    static int[] pro() {
        int[] a = new int[N];
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) { // 값이 있으면 카운터 값 +1
                a[A[i] - 1]++;
            } else { // 값이 없으면 최대 카운터로 갱신
                int max = Arrays.stream(a).max().getAsInt();
                Arrays.fill(a, max);
            }
        }

        return a;
    }

    public static void main(String[] args) {
        input();
        for (int i = 0; i < N; i++)
            sb.append(pro()[i]).append(' ');
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
