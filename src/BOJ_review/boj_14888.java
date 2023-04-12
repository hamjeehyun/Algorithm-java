package BOJ_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, min, max;
    static int[] A, operators;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++)
            A[i] = scan.nextInt();
        operators = new int[5];
        for (int i = 1; i <= 4; i++)
            operators[i] = scan.nextInt();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    static int cal(int a, int operator, int b) {
        if (operator == 1) return a + b;
        else if (operator == 2) return a - b;
        else if (operator == 3) return a * b;
        else return a / b;
    }

    static void solution(int k, int n) {
        if (k == N) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operators[i] > 0) {
                    operators[i]--;
                    solution(k + 1, cal(n, i, A[k + 1]));
                    operators[i]++;

                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        solution(1, A[1]);
        sb.append(max).append(' ').append(min);
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
