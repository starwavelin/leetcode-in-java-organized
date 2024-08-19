/***************************************************************************
 * Problem No. : 3
 * Problem Name: Longest Substring Without Repeating Characters
 * Date        : August 19, 2024
 * Author      : @codingbro
 *
 * meta        : tag-sliding-window, tag-substring
 ***************************************************************************/

package string.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int len = 0; // store the result
        Set<Character> set = new HashSet<>(); // store the characters from s

        for (int l = 0, r = 0; r < n; r++) {
            // handle r - part 1 is r++


            // handle l, after the end of this while loop, l will be at the new starting position of a possible longest
            // substring
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r)); // handle r - part 2

            // update max result
            len = Math.max(len, r - l + 1);
        }

        return len;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        String s1 = "abcbdeca";
        System.out.println(test.lengthOfLongestSubstring(s1)); // 5

        String s2 = "cccccc";
        System.out.println(test.lengthOfLongestSubstring(s2)); // 1

        String s3 = "pwwkew";
        System.out.println(test.lengthOfLongestSubstring(s3)); // 3
    }
}
