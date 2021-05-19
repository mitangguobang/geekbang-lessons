package org.geektimes.configuration.consistenthash;

import org.geektimes.projects.user.consistenthash.Node;
import org.geektimes.projects.user.consistenthash.NodeArray;
import org.geektimes.projects.user.consistenthash.VirtualNodeArray;

/**
 * @Author chenyue
 * @Date 2021-05-18
 */
public class ConsistenthashTest {
    public static void main(String[] args) {
        NodeArray nodeArray = new NodeArray();
        VirtualNodeArray  virtualNodeArray = new VirtualNodeArray();

        Node[] nodes = {
                new Node("Node1", "127.0.0.1", "0001"),
                new Node("Node2", "127.0.0.1", "0002"),
                new Node("Node3", "127.0.0.1", "0003")};

        for (Node node : nodes) {
            nodeArray.addNode(node);
            virtualNodeArray.addNode(node);
        }
        int objSize = 100;
        for (int obj = 0; obj < objSize; obj++) {
            nodeArray.put(obj);
            virtualNodeArray.put(obj);
        }

        System.out.println("========== nodeArray before  =============");
        for (int obj = 0; obj < objSize; obj++) {
            System.out.println(String.format("key=%s, node=%s",obj, nodeArray.getNode(obj).getName()));
        }

        System.out.println("========== nodeArray add node  =============");
        nodeArray.addNode(new Node("Node4-add", "127.0.0.1", "0004"));

        System.out.println("========== nodeArray after  =============");
        for (int obj = 0; obj < objSize; obj++) {
            System.out.println(String.format("key=%s, node=%s",obj, nodeArray.getNode(obj).getName()));
        }

        System.out.println("========== virtualNodeArray before  =============");
        for (int obj = 0; obj < objSize; obj++) {
            System.out.println(String.format("key=%s, node=%s",obj, virtualNodeArray.getNode(obj).getName()));
        }

        System.out.println("========== virtualNodeArray add node  =============");
        virtualNodeArray.addNode(new Node("Node5-add", "127.0.0.1", "0005"));

        System.out.println("========== virtualNodeArray after  =============");
        for (int obj = 0; obj < objSize; obj++) {
            System.out.println(String.format("key=%s, node=%s",obj, virtualNodeArray.getNode(obj).getName()));
        }
    }

}
