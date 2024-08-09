/***************************************************************************
 * Problem No. : 217
 * Problem Name: Contains Duplicate
 * Date        : August 9, 2024
 * Author      : @codingbro
 *
 * meta        : tag-set
 ***************************************************************************/

package array;

import java.util.HashSet;
import java.util.Set;


public class ContainDuplicate {

    boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainDuplicate test1 = new ContainDuplicate();
        int[] nums1 = {1, 2, 3, 5, 1};
        System.out.println(test1.containsDuplicate(nums1)); // true

        ContainDuplicate test2 = new ContainDuplicate();
        int[] nums2 = {5, 8, 19, 4};
        System.out.println(test2.containsDuplicate(nums2)); // false
    }
}