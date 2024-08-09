/***************************************************************************
 * Problem No. : 1
 * Problem Name: Two Sum
 * Date        : August 9, 2024
 * Author      : @codingbro
 *
 * meta        : tag-two-pointers, tag-sort, tag-array
 ***************************************************************************/

package array.two_pointers;

import utils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class TwoSumSol1 {

    int[] twoSum(int[] nums, int target) {
        class Elem {
            final int num;
            final int index;

            public Elem(int num, int index) {
                this.num = num;
                this.index = index;
            }
        }

        int len = nums.length;
        List<Elem> elemList = new ArrayList<Elem>();

        for (int i = 0; i < len; i++) {
            elemList.add(new Elem(nums[i], i));
        }
        elemList.sort((a, b) -> a.num - b.num);

        // two pointers walking together
        int l = 0, r = len - 1;
        while (l < r) {
            if (elemList.get(l).num + elemList.get(r).num == target) {
                if (elemList.get(l).index < elemList.get(r).index) {
                    return new int[]{elemList.get(l).index, elemList.get(r).index};
                }
                return new int[]{elemList.get(r).index, elemList.get(l).index};
            } else if (elemList.get(l).num + elemList.get(r).num < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSumSol1 test = new TwoSumSol1();
        int[] nums1 = {2, 11, 15, 7};
        ArrayUtil.displayIntArray(test.twoSum(nums1, 9)); // [0, 3]

        int[] nums2 = {5, 8, 4, 7};
        ArrayUtil.displayIntArray(test.twoSum(nums2, 11)); // [2, 3]
    }
}
