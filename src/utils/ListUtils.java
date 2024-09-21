package utils;

import linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static void displayIntegers(List<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("The result set is empty!");
            return;
        }

        for (int num : list) {
            System.out.print(" " + num);
        }
        System.out.println();
    }

    public static void displayStrings(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("The result set is empty!");
            return;
        }

        for (String str: list) {
            System.out.print(" " + str);
        }
        System.out.println();
    }

    public static void display2DStrings(List<List<String>> list) {
        if (list.isEmpty()) {
            System.out.println("The result set is empty!");
            return;
        }

        for (List<String> strs: list) {
            for (String s : strs) {
                System.out.print(" " + s);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void display2DIntegers(List<List<Integer>> list) {
        if (list.isEmpty()) {
            System.out.println("The result set is empty!");
            return;
        }

        for (List<Integer> nums: list) {
            for (int num : nums) {
                System.out.print(" " + num);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void displayLinkedList(ListNode head) {
        List<Integer> res = new ArrayList<>();

        while (head != null) {
            res.add(head.val);
            head = head.next;
        }

        ListUtils.displayIntegers(res);
    }
}
