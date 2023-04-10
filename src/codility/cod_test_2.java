package codility;

import java.util.HashSet;
import java.util.Set;

public class cod_test_2 {

    static boolean pro(int[] A) {
        // 중복 값 제거
        Set<Integer> set = new HashSet<>();

        for (int n : A) {
            // 1 만큼 다른 요소가 있다면 true
            if (set.contains(n - 1) || set.contains(n + 1))
                return true;
            set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        int A1[] = new int[]{7};
        int A2[] = new int[]{4, 3};
        int A3[] = new int[]{11, 1, 8, 12, 14};
        int A4[] = new int[]{4, 10, 8, 5, 9};
        int A5[] = new int[]{5, 5, 5, 5, 5};
        System.out.println("1 >>" + pro(A1));
        System.out.println("2 >>" + pro(A2));
        System.out.println("3 >>" + pro(A3));
        System.out.println("4 >>" + pro(A4));
        System.out.println("5 >>" + pro(A5));
    }
}
