package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cod_test_1 {

    static FastReader scan = new FastReader();

    static int N;


    static int pro() {
        String[] nStr = String.valueOf(N).split("");
        Arrays.sort(nStr);

        int ans = 0;
        for (int i = 0; i < nStr.length; i++) {
            ans += Integer.parseInt(nStr[i]) * Math.pow(10, i);
        }

        return ans;
    }

    public static void main(String[] args) {
        N = scan.nextInt();
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
