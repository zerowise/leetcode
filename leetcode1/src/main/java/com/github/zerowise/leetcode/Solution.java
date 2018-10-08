package com.github.zerowise.leetcode;

import java.util.Arrays;
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
                nums[i-counter] = nums[i];
                if (counter > 0)
                    nums[i] = 0;
            }
        }

        System.out.println(Arrays.toString(nums));
    }


}