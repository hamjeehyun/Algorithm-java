package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1068 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input() {
        N = scan.nextInt();
        child = new ArrayList[N];
        leaf = new int[N];
        for (int i = 0; i < N; i++)
            child[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int par = scan.nextInt();
            if (par == -1) {
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = scan.nextInt();
    }

    static void dfs(int x, int par) {
        if (child[x].isEmpty())
            leaf[x]++;
        for (int y : child[x]) {
            if (y == par) continue;
            dfs(y, x);
            leaf[x] += leaf[y];
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            if (child[i].contains(erased))
                child[i].remove(child[i].indexOf(erased));
        }

        if (root != erased) dfs(root, -1);

        System.out.println(leaf[root]);
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
