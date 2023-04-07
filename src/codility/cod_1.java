package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class cod_1 {
    static FastReader scan = new FastReader();
    static int N;

    static void pro() {
        N = scan.nextInt();

        // 이진 수 구하기
        String binaryString = Integer.toBinaryString(N);

        // 이진 수 반별하기
        String[] strArr = binaryString.split("");

        List<Integer> cnt = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0) continue;
            if (strArr[i].equals("0")) c++;
            if (strArr[i].equals("1")) {
                cnt.add(c);
                c = 0;
            }
        }

        if (cnt.size() == 0) System.out.println(0);
        else System.out.println(Collections.max(cnt));
    }

    public static void main(String[] args) {
        pro();
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
    }

}
