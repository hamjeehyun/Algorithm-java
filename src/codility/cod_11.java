package codility;

public class cod_11 {

    static int[] A = new int[]{0, 1, 0, 1, 1};

    static int pro() {
        int len = A.length;
        int sum = 0;
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (A[i] == 0) sum++;
            else result += sum;
        }

        if (result > 1000000000) return -1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pro());
    }
}
