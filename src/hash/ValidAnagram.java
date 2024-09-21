/***************************************************************************
 * Problem No. : 242
 * Problem Name: Valid Anagram
 * Date        : August 9, 2024
 * Author      : @codingbro
 *
 * meta        : tag-array-map, tag-sort
 ***************************************************************************/

package hash;


public class ValidAnagram {

    boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] countMap = new int[26]; // key - ASCII char for a letter, val - frequency
        int len = s.length();
        for (int i = 0; i < len; i++) {
            countMap[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            int index = t.charAt(i) - 'a';
            countMap[index]--;

            if (countMap[index] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram test1 = new ValidAnagram();
        System.out.println(test1.isAnagram("anagram", "nagaram")); // true

        ValidAnagram test2 = new ValidAnagram();
        System.out.println(test2.isAnagram("computer", "putercon")); // false
    }
}
