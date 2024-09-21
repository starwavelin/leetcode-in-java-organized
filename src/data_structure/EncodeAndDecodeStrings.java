/***************************************************************************
 * Problem No. : 271
 * Problem Name: Encode and Decode Strings
 * Date        : August 15, 2024
 * Author      : @codingbro
 *
 * meta        : tag-data-structure, tag-string, tag-serialization
 ***************************************************************************/

package data_structure;

import utils.ListUtils;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int delimIndex = s.indexOf('/', i);
            int len = Integer.parseInt(s.substring(i, delimIndex));
            res.add(s.substring(delimIndex + 1, delimIndex + 1 + len));
            i = delimIndex + 1 + len;
        }

        return res;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings test = new EncodeAndDecodeStrings();

        List<String> strs1 = Arrays.asList(new String[]{""});
        String encodedStrs1 = test.encode(strs1);
        List<String> decodedStrs1 = test.decode(encodedStrs1);
        System.out.println("Encoded strs1: " + encodedStrs1); // "0/"
        System.out.print("Decoded strs1:");
        ListUtils.displayStrings(decodedStrs1); // [""]

        List<String> strs2 = Arrays.asList(new String[]{"ab"});
        String encodedStrs2 = test.encode(strs2);
        List<String> decodedStrs2 = test.decode(encodedStrs2);
        System.out.println("Encoded strs2: " + encodedStrs2); // "2/ab"
        System.out.print("Decoded strs2:");
        ListUtils.displayStrings(decodedStrs2); // ["ab"]

        List<String> strs3 = Arrays.asList(new String[]{"5/55/", "hah"});
        String encodedStrs3 = test.encode(strs3);
        List<String> decodedStrs3 = test.decode(encodedStrs3);
        System.out.println("Encoded strs3: " + encodedStrs3); // "5/5/55/3/hah"
        System.out.print("Decoded strs3:");
        ListUtils.displayStrings(decodedStrs3); // ["5/55/", "hah"]
    }
}
