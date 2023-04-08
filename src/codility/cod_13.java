package codility;

public class cod_13 {
    static StringBuilder sb = new StringBuilder();

    static String S = "CAGCCTA";
    static int[] P = new int[]{2, 5, 0};
    static int[] Q = new int[]{4, 5, 6};

    static int[] pro() {
        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            String nS = S.substring(P[i], Q[i] + 1);
            if (nS.contains("A")) result[i] = 1;
            else if (nS.contains("C")) result[i] = 2;
            else if (nS.contains("G")) result[i] = 3;
            else result[i] = 4;
        }

        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < P.length; i++)
            sb.append(pro()[i]).append(' ');
        System.out.println(sb);
    }
}
