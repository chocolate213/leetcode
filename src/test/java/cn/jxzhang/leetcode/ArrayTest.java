package cn.jxzhang.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Main
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class ArrayTest {

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例1：
     *
     *   给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *
     *   函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *
     *   你不需要考虑数组中超出新长度后面的元素。
     */
    @Test
    public void test1() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);

        System.out.println(i);
    }

    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[n] != nums[i]) {
                n++;
                nums[n] = nums[i];
            }
        }

        return n + 1;
    }

    /**
     * 给定一个整数数组，除了某个元素外其余元素均出现两次。请找出这个只出现一次的元素。
     */
    @Test
    public void test2() {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        int i = singleNumber(nums);
        System.out.println(i);
    }

    private int singleNumber(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int a = 0;

        for (int num : nums) {
            a = a ^ num;
        }

        return a;
    }

    /**
     * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     *
     * 可以假设整数不包含任何前导零，除了数字0本身。
     *
     * 示例 2:
     *
     *   输入: [4,3,2,1]
     *
     *   输出: [4,3,2,2]
     *
     *   解释: 输入数组表示数字 4321。
     *
     */
    @Test
    public void test3() {
        int[] nums = {9, 9, 9, 9};
        nums = plusOne(nums);
        System.out.println(Arrays.toString(nums));
    }

    private int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];

        for (int i = digits.length - 1; i >= 0; i--) {
            int afterPlus = digits[i] + 1;
            if (afterPlus != 10) {
                digits[i] = afterPlus;
                return digits;
            } else {
                digits[i] = 0;
                result[i] = 0;
            }
        }

        result[0] = 1;

        return result;
    }
}
