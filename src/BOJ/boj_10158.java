package BOJ;

import java.util.Scanner;

public class boj_10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int T = sc.nextInt();

        int deltaX = 1;
        int deltaY = 1;

        while (T-- > 0) {
            if (P == W) deltaY = -1;
            else if (P == 0) deltaY = 1;
            if (Q == H) deltaX = -1;
            else if (Q == 0) deltaX = 1;
            P += deltaX;
            Q += deltaY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(P).append(' ').append(Q);
        System.out.println(sb);
    }
}
