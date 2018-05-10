/**
 * Author:   shitian
 * Date:     2018/5/10 17:33
 * Description:
 */
package com.sort.inner.impl;

import com.sort.inner.NumberSort;

import java.lang.annotation.ElementType;

/**
 * 〈归并排序〉
 *
 * @author shitian
 * @create 2018/5/10
 * @since 1.0.0
 */
public class MergeSort implements NumberSort {

    @Override
    public void sort(int[] elements) {
        mergeSort(elements, 0, elements.length - 1);
    }

    private void mergeSort(int[] list, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //递归不断拆分，直到左右两个数组都只有一个元素
            mergeSort(list, low, mid);
            mergeSort(list, mid + 1, high);
            //对左右两个数组进行排序归并
            //从最底层（左右都是一个元素）开始归并，按照左小右大归并，所以往上层的归并，左右两个数组都是有序数组
            merge(list, low, mid, high);
        }
    }

    private void merge(int[] list, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        //对左右两个数组进行归并，从小到大排序
        while (i <= mid && j <= high) {
            if (list[i] < list[j]) {
                temp[k++] = list[i++];
            } else {
                temp[k++] = list[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = list[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = list[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            list[x + low] = temp[x];
        }
    }
}
