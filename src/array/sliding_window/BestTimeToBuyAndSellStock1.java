/***************************************************************************
 * Problem No. : 121
 * Problem Name: Best Time To Buy And Sell Stock 1
 * Date        : August 19, 2024
 * Author      : @codingbro
 *
 * meta        : tag-two-pointers, tag-sliding-window
 ***************************************************************************/

package array.sliding_window;

public class BestTimeToBuyAndSellStock1 {

    int maxProfit(int[] nums) {
        int profit = 0;

        int n = nums.length;

        for (int l = 0, r = 1; r < n; r++) {
            // handle r

            // handle l
            if (nums[l] > nums[r]) {
                l = r;
            }

            // max result
            profit = Math.max(profit, nums[r] - nums[l]);
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock1 test = new BestTimeToBuyAndSellStock1();
        int[] nums1 = {1, 2, 3, 5, 1};
        System.out.println(test.maxProfit(nums1)); // 4

        int[] nums2 = {7, 6, 5, 4};
        System.out.println(test.maxProfit(nums2)); // 0

        int[] nums3 = {7, 1, 3, 4, 9, 5, 11, 4, 2};
        System.out.println(test.maxProfit(nums3)); // 10
    }
}
