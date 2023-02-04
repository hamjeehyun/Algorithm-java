package solution;


import java.util.HashSet;

class sol1845 {
    public static void main(String[] args) {
        int[] array1 = {3, 1, 2, 3};
        int[] array2 = {3, 3, 3, 2, 2, 4};
        int[] array3 = {3, 3, 3, 2, 2, 2};


        System.out.println("array1 =====> " + solution(array1));
        System.out.println("array2 =====> " + solution(array2));
        System.out.println("array3 =====> " + solution(array3));
    }

    public static int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        return Math.min(hashSet.size(), nums.length / 2);
    }
}