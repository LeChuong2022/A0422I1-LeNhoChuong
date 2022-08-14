package ss11_DSA_stack_queue.exercise.dem_so_lan_xuat_hien_moi_tu_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = input.nextLine();
        Map map = count(str);
        Set<Character> keys = map.keySet();
        for (Character c : keys)
            System.out.println(c + ": " + map.get(c) + " times");
    }

    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> map = new HashMap<>();
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (map.containsKey(c))
                    map.put(c, map.get(c) + 1);
                else
                    map.put(c, 1);
            }
        }
        return map;
    }
}
