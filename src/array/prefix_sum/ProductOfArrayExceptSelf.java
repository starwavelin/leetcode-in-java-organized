/***************************************************************************
 * Problem No. : 238
 * Problem Name: Product of Array Except Self
 * Date        : September 23, 2024
 * Author      : @codingbro
 *
 * meta        : tag-prefix-sum
 ***************************************************************************/

package array.prefix_sum;

import utils.ArrayUtil;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int acc = 1;

        // from left to right
        for (int i = 0; i < n-1; i++) {
            res[i+1] = res[i] * nums[i];
        }

        // from the right to left, get res[i] first, then update acc
        for (int i = n-1; i >= 0; i--) {
            res[i] *= acc;
            acc *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();

        int[] nums1 = {1,2,3,4};
        ArrayUtil.displayIntArray(test.productExceptSelf(nums1)); // [24, 12, 8, 6]

        int[] nums2 = {-3,5,4};
        ArrayUtil.displayIntArray(test.productExceptSelf(nums2)); // [20, -12, -15]
    }
}
