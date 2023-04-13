package test.goorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class goorm_2 {

    // 아래 메서드의 내용을 수정 작성하여 완성해 주세요.
    public double solution(int l, int[] a) {
        ArrayList<Double> distance = new ArrayList<>();
        Arrays.sort(a);

        // 길의 시작에 가로등이 없을 경우 : 시작 점 넣어주기
        if (a[0] != 0) {
            distance.add(0.0);
        }

        // 길의 끝에 가로등이 없을 경우 : 끝 점 부터 길의 끝까지의 거리 넣어주기
        if (a[a.length - 1] != l) {
            distance.add((double) l - a[a.length - 1]);
        }

        // 가로등 사이의 거리 / 2 넣어주기
        for (int i = 1; i < a.length; i++) {
            distance.add((double) (a[i] - a[i - 1]) / 2);
        }

        double d = Collections.max(distance);
        return d;
    }


    public static void main(String[] args) throws Exception {
        goorm_2 main = new goorm_2();

        int l = 20;
        int[] a = {1, 3, 6, 8, 13, 17, 19};

        double result = main.solution(l, a);

        System.out.println(result);
    }
}
