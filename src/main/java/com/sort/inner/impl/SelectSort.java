/**
 * Author:   shitian
 * Date:     2018/5/9 15:32
 * Description: 选择排序
 */
package com.sort.inner.impl;

import com.sort.inner.NumberSort;

import java.util.Arrays;

/**
 * 〈选择排序〉
 *
 * @author shitian
 * @create 2018/5/9
 * @since 1.0.0
 */
public class SelectSort implements NumberSort{

    /**
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     * @param elements
     */
    public void sort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int min = i;
            //查找最小元素下标
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[min] > elements[j]) {
                    min = j;
                }
            }
            //交换元素
            if (min > i) {
                int temp = elements[i];
                elements[i] = elements[min];
                elements[min] = temp;
            }
        }
    }


}
