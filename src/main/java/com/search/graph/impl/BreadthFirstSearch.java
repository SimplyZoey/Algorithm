/**
 * Author:   shitian
 * Date:     2018/5/11 11:25
 * Description: 广度优先查询算法
 */
package com.search.graph.impl;

import com.search.graph.GraphSearch;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 〈广度优先查询算法〉
 * 原理：遍历查询深度1，完后再遍历深度2，依次类推，直到查询到目标
 * 适合场景
 * 1.判断A节点是否可达到B节点
 * 2.获取A节点到B节点的最短路径
 *
 * @author shitian
 * @create 2018/5/11
 * @since 1.0.0
 */
public class BreadthFirstSearch implements GraphSearch {

    //存放所有需要搜索的数据
    private Queue queue = new LinkedBlockingQueue();
    //初始化图数据存放
    private Map<String, String[]> graph = new HashMap<>();
    //被查询过的人加入该set，避免两个人互为朋友，造成死循环
    private Set<String> searched = new HashSet<>();

    @Override
    public void search() {
        generatorGraph();
        BFSSearch();
    }

    /**
     * 模拟创建一个深度为2的朋友关系网
     */
    private void generatorGraph() {
        String[] myFriends = new String[]{"bob", "claire", "alice"};
        String[] bobFriends = new String[]{"anuj", "peggy"};
        String[] claireFriends = new String[]{"thom", "jonny"};
        String[] aliceFriends = new String[]{"peggy_target"};

        //将图数据存放进map，模拟根据姓名获取所其所有朋友
        graph.put("shitian", myFriends);
        graph.put("bob", bobFriends);
        graph.put("claire", claireFriends);
        graph.put("alice", aliceFriends);

        //把已知的根节点加入队列，然后开始遍历关系网
        queue.offer("shitian");
    }

    private String BFSSearch() {
        String result = "";
        while (!queue.isEmpty()) {
            String name = queue.poll().toString();
            System.out.println("search [" + name + "]");
            if (!searched.contains(name)) {
                //查询过的人加入set
                searched.add(name);
                if (isTarget(name)) {
                    result = name;
                    System.out.println("find target:" + name);
                    break;
                } else {
                    //获取自己的朋友一次加入队列
                    putFriendsToQueue(graph.get(name));
                }
            }
        }
        return result;
    }

    private void putFriendsToQueue(String[] friends) {
        if (friends != null) {
            System.out.println("add to queue:" + Arrays.toString(friends));
            for (String temp : friends) {
                queue.offer(temp);
            }
        }
    }

    /**
     * 判断当前要找人的人是否为目标
     *
     * @param name
     * @return
     */
    private boolean isTarget(String name) {
        boolean flag = false;
        if (name.endsWith("target")) {
            flag = true;
        }
        return flag;
    }

}
