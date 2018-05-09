/**
 * Author:   shitian
 * Date:     2018/5/9 16:42
 * Description: 快速排序
 */
package com.sort.inner.impl;

import com.sort.inner.NumberSort;

/**
 * 〈快速排序〉
 *
 * @author shitian
 * @create 2018/5/9
 * @since 1.0.0
 */
public class QuickSort implements NumberSort {

    @Override
    public void sort(int[] elements) {
        quickSort(elements, 0, elements.length - 1);
    }

    //分治，递归
    private void quickSort(int[] elements, int low, int high) {
        if (low < high) {
            int middle = getMiddle(elements, low, high);
            System.out.println(middle + "_" + low + "_" + high);
            quickSort(elements, low, middle - 1);
            quickSort(elements, middle + 1, high);
        }
    }

    private int getMiddle(int[] elements, int low, int high) {
        int temp = elements[low];   //第一个元素为中轴
        while (low < high) {
            while (low < high && temp < elements[high]) {
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
