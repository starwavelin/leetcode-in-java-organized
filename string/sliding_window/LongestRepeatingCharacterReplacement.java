/***************************************************************************
 * Problem No. : 424
 * Problem Name: Longest Repeating Character Replacement
 * Date        : August 20, 2024
 * Author      : @codingbro
 *
 * meta        : tag-sliding-window, tag-map, tag-two-pointers
 ***************************************************************************/

package string.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    int charReplacement(String s, int k) {
        int n = s.length();

        int len = 0; // store the longest length
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (int l = 0, r = 0; r < n; r++) {
            // handle r
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            // handle l
            while ( (r -l + 1) - maxFreq > k ) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            // max res
            len = r - l + 1;
        }

        return len;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement test = new LongestRepeatingCharacterReplacement();
        String s1 = "DDDABCEF"; int i1 = 1;
        System.out.println(test.charReplacement(s1, i1)); // 4

        String s2 = "ABAB"; int i2 = 2;
        System.out.println(test.charReplacement(s2, i2)); // 4

        String s3 = "KKLADBDCDFK"; int i3 = 2;
        System.out.println(test.charReplacement(s3, i3)); // 5
    }
}
