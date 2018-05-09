/**
 * Author:   shitian
 * Date:     2018/5/9 15:47
 * Description: 冒泡排序
 */
package com.sort.inner.impl;

import com.sort.inner.NumberSort;

/**
 * 〈冒泡排序〉
 *
 * @author shitian
 * @create 2018/5/9
 * @since 1.0.0
 */
public class BubbleSort implements NumberSort {

    /**
     * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     3、针对所有的元素重复以上的步骤，除了最后一个。
     4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param elements
     */
    @Override
    public void sort(int[] elements) {
        //一共需要循环len次
        for (int i = 0; i < elements.length; i++) {
            //每次循环获取一个最大的放在最后
            for (int j = 0; j < elements.length - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }
}
