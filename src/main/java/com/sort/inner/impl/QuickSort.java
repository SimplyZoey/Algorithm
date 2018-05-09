/**
 * Author:   shitian
 * Date:     2018/5/9 16:42
 * Description: 快速排序
 */
package com.sort.inner.impl;

import com.sort.inner.NumberSort;

import java.util.Arrays;

/**
 * 〈快速排序〉
 *
 * @author shitian
 * @create 2018/5/9
 * @since 1.0.0
 */
public class QuickSort implements NumberSort {

    /**
     * 1)默认以第一个元素为基准
     * 2)比基准小的都放左边，大的都放右边，相同可以放左，也可以放右，自己定义[相同的不处理会导致死循环]
     * 3)此时，基准元素将数组分为两个部分
     * 4)采用分治，递归，最终实现有序
     * @param elements
     */
    @Override
    public void sort(int[] elements) {
        quickSort(elements, 0, elements.length - 1);
    }

    //分治，递归
    private void quickSort(int[] elements, int low, int high) {
        if (low < high) {
            int middle = getMiddle(elements, low, high);
            quickSort(elements, low, middle - 1);
            quickSort(elements, middle + 1, high);
        }
    }

    private int getMiddle(int[] elements, int low, int high) {
        int temp = elements[low];   //第一个元素为中轴
        while (low < high) {
            //一定要加=，否则数组中出现两个数字相同就会导致死循环
            while (low < high && temp <= elements[high]) {
                high--;
            }
            elements[low] = elements[high];
            while (low < high && temp > elements[low]) {
                low++;
            }
            elements[high] = elements[low];
        }
        elements[low] = temp;
        return low;
    }
}
