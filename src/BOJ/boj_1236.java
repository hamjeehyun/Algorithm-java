package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1236 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static char[][] arr;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.next().toCharArray();
        }
    }

    static void pro() {
        // 각 행/열에 필요한 경비원이 있는지 확인
        boolean[] exitsColCnt = new boolean[N];
        boolean[] exitsRowCnt = new boolean[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'X') {
                    exitsColCnt[i] = true;
                    exitsRowCnt[j] = true;
                }
            }
        }

        // 보호받지 못하는 행/열의 개수 구하기
        int colCnt = 0;
        int rowCnt = 0;
        for (int i = 0; i < N; i++) {
            if (!exitsColCnt[i]) colCnt++;
        }
        for (int i = 0; i < M; i++) {
            if (!exitsRowCnt[i]) rowCnt++;
        }

        // 둘 중 큰 값 출력
        System.out.println(Math.max(colCnt, rowCnt));
    }

    public static void main(String[] args) {
        input();
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

        char nextChar() {
            return next().charAt(0);
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
