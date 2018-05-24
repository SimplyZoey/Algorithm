/**
 * Author:   shitian
 * Date:     2018/5/24 14:00
 * Description: 字典算法
 */
package com.search.number.impl;

import com.search.number.NumberSearch;

import java.util.Arrays;

/**
 * 〈字典序算法〉
 *
 * @author shitian
 * @create 2018/5/24
 * @since 1.0.0
 */
public class DictionarySearch implements NumberSearch {

    /**
     * 主流程，返回最近一个大于自身的相同数字组成的整数。
     * 1.从右往左找，找到第一个左边小于右边的数字list[i]，小的数字的下标i
     * 2.从右往左找，找到第一个大于list[i]的数字list[j]，下标为j
     * 3.交换list[i]与list[j]
     * 4.最后将下标i后面的元素从小到大排序，不包含下标i
     */
    @Override
    public void findNumber() {
        int number = 123456;
        int[] numbers = convertArray(number);
        //获取10次数据
        for (int i = 0; i < 10; i++) {
            numbers = findNearestNumber(numbers);
            outputNumbers(numbers);
        }
    }

    //将数字按照顺序转换为数组
    private int[] convertArray(int number) {
        String temp = String.valueOf(number);
        int length = temp.length();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
        }
        return result;
    }


    private int[] findNearestNumber(int[] numbers) {
        //拷贝入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        //1.从后向前查看,找到第一个左边小于右边的数字下标
        int index = findTransferPoint(numbersCopy);
        //如果数字置换边界是0，说明整个数组已经排列完成
        if (index == 0) {
            return null;
        }
        //2.从右往左找到第一个大于list[i]的数字，并交换
        exchangeHead(numbersCopy, index);
        //3.从下标i+1开始，将这部分数据从小到大排序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    /**
     * 1.从右往左找到第一个左边小于右边的数字下标
     *
     * @param numbers
     * @return
     */
    private int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i - 1;
            }
        }
        return 0;
    }

    /**
     * 2.从右往左找到第一个大于list[i]的数字，并交换
     * @param numbers
     * @param index
     * @return
     */
    private int[] exchangeHead(int[] numbers, int index) {
        for (int i = numbers.length - 1; i > index; i--) {
            if (numbers[index] < numbers[i]) {
                int temp = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = temp;
                break;
            }
        }
        return numbers;
    }


    /**
     * 3.从下标i+1开始，将这部分数据从小到大排序
     * @param num
     * @param index
     * @return
     */
    private int[] reverse(int[] num, int index) {
        for (int i = index + 1, j = num.length - 1; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }


    //输出数组
    private void outputNumbers(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i);
        }
        System.out.println();
    }

}
