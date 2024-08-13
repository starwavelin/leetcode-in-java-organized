/***************************************************************************
 * Problem No. : 49
 * Problem Name: Group Anagrams
 * Date        : August 13, 2024
 * Author      : @codingbro
 *
 * meta        : tag-map, tag-array
 ***************************************************************************/

package hash;

import utils.ListUtils;

import java.util.*;

public class GroupAnagrams {

    List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>(); // key - word key, val - ana words

        for (String str : strs) {
            String key = getKey(str);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str);
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }

    String getKey(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();

        String[] strs1 = {"anagram"};
        ListUtils.display2DStrings(test.groupAnagrams(strs1)); // [["anagrams"]]

        String[] strs2 = {""};
        ListUtils.display2DStrings(test.groupAnagrams(strs2)); // [[""]]

        String[] strs3 = {"eat","tea","tan","ate","nat","bat"};
        ListUtils.display2DStrings(test.groupAnagrams(strs3)); // [["eat","tea","ate"],["bat"],["tan","nat"]] order doesn't matter

        String[] strs4 = {"bingo","tea","gonib","ate","res","ser"};
        ListUtils.display2DStrings(test.groupAnagrams(strs4)); // [["bingo","gonib"],["tea", "ate"],["ser","res"]] order doesn't matter
    }
}
