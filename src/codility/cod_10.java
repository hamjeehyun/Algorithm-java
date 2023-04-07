package codility;

import java.util.HashSet;
import java.util.Set;

public class cod_10 {

    static int[] A = new int[]{1, 3, 6, 4, 1, 2};

    static int pro() {
        Set<Integer> set = new HashSet<>();

        for (int a : A) set.add(a);

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (!set.contains(i))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pro());
    }
}
