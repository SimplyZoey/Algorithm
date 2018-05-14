/**
 * Author:   shitian
 * Date:     2018/5/11 14:25
 * Description: 迪克斯特拉算法
 */
package com.search.graph.impl;

import com.search.graph.GraphSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈狄克斯特拉算法〉
 * 原理：遍历查询深度1，完后再遍历深度2，依次类推，直到查询到目标
 * 适合场景(有向无环)
 * 1.判断A节点到B节点的最短消耗（边加权）
 *
 * @author shitian
 * @create 2018/5/11
 * @since 1.0.0
 */
public class DijkstraSearch implements GraphSearch {
    //存放图中的每个节点
    private Map<String, Node> nodeMap = new HashMap<>();

    @Override
    public void search() {
        generatroGraph();
        dijkstraSearch();
        System.out.println(nodeMap.get("end").getCost());
    }

    /**
     * 构造初始有向加权无环图
     */
    private void generatroGraph() {
        //生成初始图
        //start node
        Map<String, Integer> childMap = new HashMap<>();
        childMap.put("A", 5);
        childMap.put("B", 0);
        nodeMap.put("start", new Node("start", null, -1, childMap, true));

        //A node
        childMap = new HashMap<>();
        childMap.put("C", 15);
        childMap.put("D", 20);
        nodeMap.put("A", new Node("A", "start", 5, childMap, false));

        //B node
        childMap = new HashMap<>();
        childMap.put("C", 30);
        childMap.put("D", 35);
        nodeMap.put("B", new Node("B", "start", 0, childMap, false));

        //C node
        childMap = new HashMap<>();
        childMap.put("end", 20);
        nodeMap.put("C", new Node("C", null, -1, childMap, false));

        //D node
        childMap = new HashMap<>();
        childMap.put("end", 10);
        nodeMap.put("D", new Node("D", null, -1, childMap, false));

        //end node
        nodeMap.put("end", new Node("end", null, -1, null, false));
    }

    private void dijkstraSearch() {
        /**
         * 1.还有未处理的节点
         * 2.获取cost最小的节点
         * 3.更新其邻居的开销
         * 4.如果邻居开销被更新，同时更新其parent
         * 5.该节点标记为处理过
         */
        Node node = getLowestCostNode(nodeMap);
        while (node != null) {
            int nodeCost = node.getCost();
            String[] child = node.getChild();
            if (child != null && child.length > 0) {
                int newCost = 0;
                Node childNod = null;
                for (String temp : child) {
                    childNod = nodeMap.get(temp);
                    newCost = nodeCost + node.getChildCost(temp);
                    if(childNod.getCost() < 0 || newCost < childNod.getCost()){
                        childNod.setCost(newCost);
                        childNod.setParent(temp);
                    }
                }
            }
            node.setProcessed(true);

            node = getLowestCostNode(nodeMap);
        }
    }

    private Node getLowestCostNode(Map<String, Node> nodes) {
        Node temp = null;
        Integer lowestCost = Integer.MAX_VALUE;
        for (Node node : nodes.values()) {
            //遍历所有的node，获取cost最小的node，并且没有被处理过
            if (node.getCost() >= 0 && node.getCost() < lowestCost && !node.isProcessed()) {
                lowestCost = node.getCost();
                temp = node;
            }
        }
        return temp;
    }
}

class Node {
    private String name;
    private String parent;
    private Integer cost;
    private Map<String, Integer> child;
    private boolean processed;


    public Node(String name, String parent, Integer cost, Map<String, Integer> child, boolean processed) {
        this.name = name;
        this.parent = parent;
        this.cost = cost;
        this.child = child;
        this.processed = processed;
    }


    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getName() {
        return name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String[] getChild() {
        String[] result = null;
        if(child != null){
            result = child.keySet().toArray(new String[0]);
        }
        return result;
    }

    public Integer getChildCost(String childName){
        return child.get(childName);
    }

}
