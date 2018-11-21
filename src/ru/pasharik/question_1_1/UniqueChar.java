package ru.pasharik.question_1_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pasharik on 21/11/18.
 */
public class UniqueChar {
    public boolean allUnique(String str) {
        Map<Character, Integer> map = new HashMap();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (map.containsKey(ch)) return false;
            map.put(ch, 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueChar().allUnique("abcd123"));
    }
}
