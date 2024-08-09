/***************************************************************************
 * Problem No. : 1
 * Problem Name: Two Sum
 * Date        : August 9, 2024
 * Author      : @codingbro
 *
 * meta        : tag-map, tag-array
 ***************************************************************************/

package array.two_pointers;

import utils.ArrayUtil;

import java.util.Map;
import java.util.HashMap;

public class TwoSumSol2 {

    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // key - num, val - index

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSumSol2 test = new TwoSumSol2();

        int[] nums1 = {2, 11, 15, 7};
        ArrayUtil.displayIntArray(test.twoSum(nums1, 9)); // [0, 3] or [3, 0]

        int[] nums2 = {5, 8, 4, 7};
        ArrayUtil.displayIntArray(test.twoSum(nums2, 11)); // [2, 3] or [3, 2]

        int[] nums3 = {5, 8, 4, 7, 2, 0};
        ArrayUtil.displayIntArray(test.twoSum(nums3, 6)); // [2, 4] or [4, 2]
    }
}