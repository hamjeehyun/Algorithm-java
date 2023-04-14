package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj_1764 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A, B;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N + 1];
        B = new String[M + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.next();
        for (int i = 1; i <= M; i++) B[i] = scan.next();
    }

    static boolean binarySearch(int L, int R, String X) {
        while (L <= R) {
            int mid = (L + R) / 2;

            if (Objects.equals(B[mid], X)) return true;
            else if (B[mid].compareTo(X) < 0) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    static void solution() {
        Arrays.sort(A, 1, N + 1);
        Arrays.sort(B, 1, M + 1);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if(binarySearch(1, M, A[i])) ans.add(A[i]);
        }

        sb.append(ans.size()).append('\n');
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        solution();
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
