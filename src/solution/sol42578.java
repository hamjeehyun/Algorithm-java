package solution;

import java.util.HashMap;
import java.util.Map;

public class sol42578 {
    public static void main(String[] args) {
        String[][] array1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] array2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};


        System.out.println("array1 =====> " + solution(array1));
//        System.out.println("array2 =====> " + solution(array2));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, String> closet = new HashMap<>();

        for (String[] cloth : clothes) {
            closet.put(cloth[1], cloth[0]);
        }

        for (String val : closet.keySet()) {
            answer *= closet.size() + 1;
        }

        return answer-1;
    }
}
