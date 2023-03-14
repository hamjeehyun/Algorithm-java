package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        operator = new int[5];
        for (int i = 1; i <= 4; i++) operator[i] = scan.nextInt();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    static int N, min, max;
    static int[] nums, operator;

    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) return operand1 + operand2;
        if (operator == 2) return operand1 - operand2;
        if (operator == 3) return operand1 * operand2;
        else return operand1 / operand2;
    }

    static void rec_func(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if(operator[cand] >= 1) {
                    operator[cand]--;
                    rec_func(k+1, calculator(value, cand, nums[k+1]));
                    operator[cand]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            if (st == null || !st.hasMoreElements()) {
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
    }
}
