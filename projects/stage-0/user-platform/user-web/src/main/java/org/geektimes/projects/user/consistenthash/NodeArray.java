package org.geektimes.projects.user.consistenthash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author chenyue
 * @Date 2021-05-18
 */
public class NodeArray {
    /**
     * 按照 键 排序
     */
    TreeMap<Integer, Node> nodes = new TreeMap<>();

    public void addNode(Node node) {
        nodes.put(node.hashCode(), node);
    }

    public void put(Object obj) {
        int objHashcode = obj.hashCode();
        Node node = nodes.get(objHashcode);
        if (node != null) {
            node.putDate(obj);
            return;
        }

        // 找到比给定 key 大的集合
        SortedMap<Integer, Node> tailMap = nodes.tailMap(objHashcode);
        // 找到最小的节点
        int nodeHashcode = tailMap.isEmpty() ? nodes.firstKey() : tailMap.firstKey();
        nodes.get(nodeHashcode).putDate(obj);

    }

    public Object getNodeDate(Object obj) {
        return getNode(obj).getDate(obj);
    }

    public Node getNode(Object obj) {
        Node node = nodes.get(obj.hashCode());
        if (node != null) {
            return node;
        }

        // 找到比给定 key 大的集合
        SortedMap<Integer, Node> tailMap = nodes.tailMap(obj.hashCode() % 100);
        // 找到最小的节点
        int nodeHashcode = tailMap.isEmpty() ? nodes.firstKey() : tailMap.firstKey();
        return nodes.get(nodeHashcode);
    }
}
