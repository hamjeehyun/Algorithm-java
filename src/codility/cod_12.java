package codility;

public class cod_12 {
    static int A = 6, B = 11, K = 2;

    static int pro() {
        if (A % K == 0)
            return B / K - A / K + 1;

        return B / K - A / K;
    }

    public static void main(String[] args) {
        System.out.println(pro());
    }
}
