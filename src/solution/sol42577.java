package solution;

import java.util.HashMap;
import java.util.Map;

public class sol42577 {

    public static void main(String[] args) {
        String[] array1 = {"119", "97674223", "1195524421"};
        String[] array2 = {"123", "456", "789"};
        String[] array3 = {"12", "123", "1235", "567", "88"};


        System.out.println("array1 =====> " + solution(array1));
        System.out.println("array2 =====> " + solution(array2));
        System.out.println("array3 =====> " + solution(array3));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j)))
                    answer = false;
            }
        }

        return answer;
    }
}
