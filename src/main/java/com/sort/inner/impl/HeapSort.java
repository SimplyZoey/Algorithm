/**
 * Author:   shitian
 * Date:     2018/5/10 14:55
 * Description: 堆排序
 */
package com.sort.inner.impl;

import com.sort.inner.NumberSort;

/**
 * 〈堆排序〉
 *
 * @author shitian
 * @create 2018/5/10
 * @since 1.0.0
 */
public class HeapSort implements NumberSort {

    /**
     * 1：根据len/2-1获取所有根节点
     * 2：从最后一个跟节点开始
     *  2.1：根据根下标n，获取左（2*n+1）右（2*（n+1））孩子节点
     *  2.2：获取三者最大节点，然后交换【递归执行该逻辑，针对N不是最后一个根情况】
     * 3：循环第二步操作
     * @param elements
     */
    @Override
    public void sort(int[] elements) {
        maxHeapSort(elements);
        printList(elements);
    }

    private void maxHeapSort(int[] elements) {
        int len = elements.length;
        //len/2-1获取的该数组中所有的根
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(elements, i, len);
        }

    }

    private void heapify(int[] list, int parent, int size) {
        int left = 2 * parent + 1;
        int right = 2 * (parent + 1);
        int max = parent;
        //两次if判断获取三者之间最大的下标
        if (left < size && list[left] > list[max]) {
            max = left;
        }
        if (right < size && list[right] > list[max]) {
            max = right;
        }
        //如果最大的不是根节点，则交换
        if (max != parent) {
            int temp = list[parent];
            list[parent] = list[max];
            list[max] = temp;

            //递归大根堆比较[针对该根的叶子节点也是根的情况，所以要一直比较到叶子节点]
            heapify(list, max, size);
        }
    }

    private void printList(int[] list) {
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            //每次循环的数组长度都i--，含义为每次将堆顶的最大值与尾部交换，然后将除尾部的元素外，其他元素再次排序获得最大堆顶
            heapify(list, 0, i);
        }
    }
}
