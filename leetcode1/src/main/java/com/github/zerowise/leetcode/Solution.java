package com.github.zerowise.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;


public class Solution {

    /**
     * 爱丽丝有一手（hand）由整数数组给定的牌。
     *
     * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
     *
     * 如果她可以完成分组就返回 true，否则返回 false。
     */
    public static boolean isNStraightHand(int[] hand, int w) {
        if (w == 1) {
            return hand.length >= w;
        }
        int firstEleIndex = 0;
        int num = 0;
        while (firstEleIndex + w <= hand.length) {
            int[] tmpArray = new int[w];
            tmpArray[0] = hand[firstEleIndex];
            int tempInHandsIndex = firstEleIndex + 1;
            int tempInTempIndex = 0;
            while (tempInHandsIndex < hand.length) {
                if (hand[tempInHandsIndex] == tmpArray[tempInTempIndex] + 1) {
                    tmpArray[tempInTempIndex + 1] = hand[tempInHandsIndex];
                    tempInTempIndex++;
                    if (tempInTempIndex == w - 1) {
                        num++;
                        if (num >= w) {
                            return true;
                        }
                        break;
                    }
                }
                tempInHandsIndex++;
            }
            firstEleIndex++;
        }
        return false;
    }


    public static void main(String[] args) {
        //System.out.println(isNStraightHand(new int[]{2, 1}, 2));
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }


    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     *
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须原地修改，只允许使用额外常数空间。
     *
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * @param array
     */

    public static void nextPermutation(int[] array) {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = array.length - 1;
            while (j >= 0 && array[j] <= array[i]) {
                j--;
            }
            swap(array, i, j);
        }

        reverse(array, i + 1);
    }

    private static void reverse(int[] array, int start) {
        int i = start;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j++;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] == 0 && !(i == nums.length - 1 || nums[i + 1] == 0)) {
//                int j = i + 1;
//                for (; j < nums.length; j++) {
//                    if (nums[j] == 0) {
//                        break;
//                    }
//                    nums[j - 1] = nums[j];
//                }
//                nums[j - 1] = 0;
//            }
//        }

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                counter++;
            } else {
                nums[i - counter] = nums[i];
                if (counter > 0)
                    nums[i] = 0;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        if (nums != null && nums.length != 0) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[j++] = nums[i];
                }
            }
            return j;
        }
        return 0;
    }

    /**
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rs = null;
        ListNode last = null;
        ListNode cur = null;
        int val = 0;
        while (null != l1 || null != l2) {
            if (null != l1) {
                val += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                val += l2.val;
                l2 = l2.next;
            }
            cur = new ListNode(val % 10);
            val = val / 10;
            if (null == last) {
                rs = cur;
            } else {
                last.next = cur;
            }
            last = cur;
        }
        if (val > 0) {
            cur = new ListNode(val);
            last.next = cur;
        }
        return rs;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
//    public int removeDuplicates(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//
//        }
//    }


    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
     *
     * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
     *
     * 你可以假设 nums1 和 nums2 不同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 中位数是 (2 + 3)/2 = 2.5
     * @param nums1
     * @param nums2
     * @return
     *
     *
     *  see https://blog.csdn.net/hk2291976/article/details/51107778
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int lo = 0, hi = 2 * len1;//加入了类似manacher算法的虚拟元素，目的是保持一般性
        int l1 = 0, r1 = 0, l2 = 0, r2 = 0;
        while (lo <= hi) {
            int c1 = (lo + hi) / 2;

            // 按前k个数字给的割点，那么对于中位数k = m + n
            int c2 = len2 + len1 - c1;

            l1 = c1 == 0 ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            r1 = c1 == 2 * len1 ? Integer.MAX_VALUE : nums1[c1 / 2];

            l2 = c2 == 0 ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            r2 = c2 == 2 * len2 ? Integer.MAX_VALUE : nums2[c2 / 2];

            if (l1 > r2) {
                hi = c1 - 1;
            } else if (l2 > r1) {
                lo = c1 + 1;
            } else {
                break;
            }
        }
        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
    }
}