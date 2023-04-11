package BOJ;

import java.util.Scanner;

public class boj_13223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currenTime = sc.next();
        String saltTime = sc.next();

        int currentH = Integer.parseInt(currenTime.split(":")[0]);
        int currentM = Integer.parseInt(currenTime.split(":")[1]);
        int currentS = Integer.parseInt(currenTime.split(":")[2]);

        int targetH = Integer.parseInt(saltTime.split(":")[0]);
        int targetM = Integer.parseInt(saltTime.split(":")[1]);
        int targetS = Integer.parseInt(saltTime.split(":")[2]);

        int current = currentH * 3600 + currentM * 60 + currentS;
        int target = targetH * 3600 + targetM * 60 + targetS;
        int need = target - current;
        if (need <= 0) need += 24 * 3600;

        int H = need / 3600;
        int M = (need % 3600) / 60;
        int S = need % 60;

        System.out.printf("%02d:%02d:%02d", H, M, S);
    }
}
