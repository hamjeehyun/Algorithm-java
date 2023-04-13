package test.goorm;

import java.util.ArrayList;
import java.util.Arrays;

public class goorm_1 {
    public int[] solution(int[] a, int[] b) {
        int[] c;

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            if (A.contains(b[i]))
                C.add(b[i]);
        }
        c = new int[C.size()];
        for(int i=0; i< C.size(); i++) {
            c[i] = C.get(i);
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        goorm_1 main = new goorm_1();
        int[] a = {1, 2, 2, 3, 3, 3};
        int[] b = {2, 3, 3, 4, 5};
        int[] result = main.solution(a, b);

        System.out.println(Arrays.toString(result));
    }
}
