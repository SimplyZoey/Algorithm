/**
 * Author:   shitian
 * Date:     2018/7/3 16:40
 * Description:
 */
package com.search.graph.impl;

import com.search.graph.GraphSearch;

import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个数组，里面全是正整数。数字大小表示这一步最多可以向后移动几个节点。
 * 总是从数组第一个元素开始移动。问如何移动，可以以最少步数移动到最后一个节点。
 * <p>
 * 例如：[3,4,2,1,3,1]初始状态指向3表示下一步可以移动1格，或者2格，或者3格
 * 最优的方式是指向3的时候移动一步，第二次选择移动4步，一共只需要两步即可移动到数组尾。
 * <p>
 * 输入：3,4,2,1,3,1
 * 输出：步经的点3,4,1
 *
 * @author shitian
 * @create 2018/7/3
 * @since 1.0.0
 */
public class NumberBreadthFirstSearch implements GraphSearch {

    @Override
    public void search() {
        int[] target = new int[]{3, 4, 2, 1, 3, 1};
        String result = BFSearch(generatorRel(target), target);
        System.out.println(result);
    }

    private static Map generatorRel(int[] target) {
        Map<Integer, List<Integer>> arriveMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            List<Integer> indexList = new ArrayList<>();
            int temp = target[i];
            for (int j = 1; j <= temp; j++) {
                indexList.add(i + j);
            }
            arriveMap.put(i, indexList);

        }
        return arriveMap;
    }

    private static String BFSearch(Map<Integer, List<Integer>> arriveMap, int[] target) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(target[0]);
        Queue queue = new LinkedBlockingQueue();
        putElementToQueue(queue, arriveMap.get(0));
        while (!queue.isEmpty()) {
            Integer temp = (Integer) queue.poll();
            if (arriveMap.get(temp).contains(5)) {
                buffer.append(target[temp]);
                return buffer.toString();
            } else {
                putElementToQueue(queue, arriveMap.get(temp));
            }
        }

        return null;
    }

    private static void putElementToQueue(Queue queue, List<Integer> elements) {
        for (Integer temp : elements) {
            queue.add(temp);
        }
    }

}
