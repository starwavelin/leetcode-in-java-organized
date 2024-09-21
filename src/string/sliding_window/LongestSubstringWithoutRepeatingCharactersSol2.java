/***************************************************************************
 * Problem No. : 3
 * Problem Name: Longest Substring Without Repeating Characters
 * Date        : August 19, 2024
 * Author      : @codingbro
 *
 * meta        : tag-sliding-window, tag-substring, tag-map
 ***************************************************************************/

package string.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersSol2 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int len = 0; // store the max length
        Map<Character, Integer> map = new HashMap<>(); // key - char, val - count

        for (int l = 0, r = 0; r < n; r++) {
            // handle r
            char cur = s.charAt(r);
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            // handle l, when repetition of cur happens, move l
            while (map.get(cur) == 2) {
                char left = s.charAt(l);
                map.put(left, map.get(left) - 1);
                l++;
            }

            // result, max result
            len = Math.max(len, r - l + 1);
        }

        return len;
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharactersSol2 test = new LongestSubstringWithoutRepeatingCharactersSol2();
        String s1 = "abcbdeca";
        System.out.println(test.lengthOfLongestSubstring(s1)); // 5

        String s2 = "cccccc";
        System.out.println(test.lengthOfLongestSubstring(s2)); // 1

        String s3 = "pwwkew";
        System.out.println(test.lengthOfLongestSubstring(s3)); // 3
    }
}
