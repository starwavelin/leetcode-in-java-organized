package heap;

import utils.ListUtils;

import java.util.*;

public class TopKFrequentElementsSol1 {

    List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        // map to store the num and its frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // use MinHeap to keep the k elements in the heap
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        map.forEach((key, val) -> {
            if (minHeap.size() < k) {
                minHeap.offer(Map.entry(key, val));
            } else if (val > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(Map.entry(key, val));
            }
        });

        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().getKey());
        }

        return res;
    }


    public static void main(String[] args) {
        TopKFrequentElementsSol1 test = new TopKFrequentElementsSol1();

        int[] nums1 = {1,1,1,2,2,3};
        int k1 = 2;
        ListUtils.displayIntegers(test.topKFrequent(nums1, k1)); // [1, 2] order doesn't matter


        int[] nums2 = {1,1,1,2,2,3, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int k2 = 3;
        ListUtils.displayIntegers(test.topKFrequent(nums2, k2)); // [5, 1, 3]
    }
}
