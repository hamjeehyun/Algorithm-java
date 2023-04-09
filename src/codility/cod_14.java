package codility;

public class cod_14 {

    static int[] A = new int[]{4, 2, 2, 5, 1, 5, 8};

    static int pro() {
        int len = A.length;

        // 0~i까지의 평균
        int[] avg = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            avg[i] = sum / (i + 1);
        }

        int min = 0;
        int ans = 0;
        for (int i = 0; i < len; i++)
            for (int j = i; j < len; j++) {
                if ((avg[j] - avg[i]) < min) {
                    min = avg[j] - avg[i];
                    ans = i;
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pro());
    }

}
