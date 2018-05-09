/**
 * Author:   shitian
 * Date:     2018/5/7 11:43
 * Description: 直接插入排序
 */
package com.sort.inner.impl;

import com.sort.inner.NumberSort;

import java.util.Arrays;

/**
 * 〈直接插入排序〉
 *
 * @author shitian
 * @create 2018/5/7
 * @since 1.0.0
 */
public class InsertSort implements NumberSort{

    /**
     * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
     * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
     * @param elements
     */
    public void sort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < elements[i - 1]) {       //移动有序表后插入
                int j = i - 1;
                int temp = elements[i];        //临时存储要插入的元素
                while (j >= 0 && temp < elements[j]) {  //查找在有序表的插入位置
                    elements[j + 1] = elements[j];   //元素后移
                    j--;
                }
                elements[j + 1] = temp;      //插入到正确位置，由于while循环j--，所以最后需要改为j+1
            }
        }
    }

}
