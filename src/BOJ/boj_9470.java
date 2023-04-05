package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_9470 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N, M;
    static int[] indeg, order, maxCnt;
    static ArrayList<Integer>[] adj;

    static void input() {
        K = scan.nextInt(); // 테스트 케이스 번호
        N = scan.nextInt(); // 노드의 수 - 바다와 만나는 노드
        M = scan.nextInt(); // 간선 의 수

        adj = new ArrayList[N + 1]; // 노드의 관계
        indeg = new int[N + 1]; // 들어오는 노드의 수
        order = new int[N + 1];
        maxCnt = new int[N + 1];

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
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            if (indeg[i] == 0) {
                queue.add(i); // 들어오는 노드가 없는 경우 - 제일 앞에 있는 노드
                order[i] = maxCnt[i] = 1; // 초기값 세팅
            }

        int ans = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();

            // 만약 들어오는 수서 중 가장 큰 순서가 2개 이상이면 자신의 순서를 1증가
            if (maxCnt[x] >= 2)
                order[x]++;

            ans = Math.max(ans, order[x]); // 정답 갱신

            for (int y : adj[x]) {
                indeg[y]--; // 연결된 간선 제거
                if (indeg[y] == 0)
                    queue.add(y); // 다음에 탐색할 노드

                // 순서 계산을 위해서 y번 정범에 들어오는 최대 순서를 갱신
                if (order[y] == order[x])
                    maxCnt[y]++;
                else if (order[y] < order[x]) {
                    order[y] = order[x];
                    maxCnt[y] = 1;
                }
            }
        }
        System.out.println(K + " " + ans);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();

        while (T-- > 0) {
            input();
            pro();
        }
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
