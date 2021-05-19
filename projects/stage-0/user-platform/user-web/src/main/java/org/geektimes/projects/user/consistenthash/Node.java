package org.geektimes.projects.user.consistenthash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenyue
 * @Date 2021-05-18
 */
public class Node {
    private String name;
    private String host;
    private String port;
    Map<Integer, Object> nodeData = new HashMap<>();

    public Node(String name, String host, String port) {
        this.name = name;
        this.host = host;
        this.port = port;
    }

    public void putDate(Object obj) {
        nodeData.put(obj.hashCode(), obj);
    }

    Object getDate(Object obj) {
        return nodeData.get(obj.hashCode());
    }

    @Override
    public int hashCode() {
        return Math.abs(name.hashCode() % 100);
    }

    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}
