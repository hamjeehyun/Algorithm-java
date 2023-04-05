package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_14676 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N, M;
    static int[] indeg, cnt, satisfaction;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt(); // 노드
        M = scan.nextInt(); // 간선
        K = scan.nextInt(); // 게임 정보 개수

        adj = new ArrayList[N + 1]; // 관계
        indeg = new int[N + 1]; // 들어오는 간선의 수
        cnt = new int[N + 1];
        satisfaction = new int[N + 1]; // 영향을 받는 건물

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        boolean abnormal = false;

        // 정보의 회수 만큼
        while (K-- > 0) {
            // 파괴되는 건물의 정보 입력
            int t = scan.nextInt();
            int x = scan.nextInt();


            if (t == 1) {
                // x의 선행 건물들이 모두 지어졌는지 확인
                if (satisfaction[x] < indeg[x])
                    abnormal = true;

                cnt[x]++;

                // x가 처음 지어짐 -> 영향을 주는 건물들에게 얄려주기
                if (cnt[x] == 1)
                    for (int y : adj[x])
                        satisfaction[y]++;
            } else {
                // x 건물이 한개 이상 지어졌는지 확인하기
                if (cnt[x] == 0)
                    abnormal = true;

                // 파괴하기
                cnt[x]--;

                // x가 더이상 남아있지 않음 0> 영향을 주는 건물들에게 알려주기
                if (cnt[x] == 0)
                    for (int y : adj[x])
                        satisfaction[y]--;
            }
        }

        if (abnormal) System.out.println("Lier!");
        else System.out.println("King-God-Emperor");
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
