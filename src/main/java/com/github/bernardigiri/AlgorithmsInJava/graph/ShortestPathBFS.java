package com.github.bernardigiri.AlgorithmsInJava.graph;

import java.util.*;

public class ShortestPathBFS {

    public static List<String> shortestPathBFS(Map<String, List<String>> graph, String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return new ArrayList<>();
        }
        Queue<String> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(start);
        Map<String, String> evaluatedPaths = new HashMap<>();
        evaluatedPaths.put(start, null);
        while (!nodesToVisit.isEmpty()) {
            String current = nodesToVisit.remove();
            if (current == end) {
                return getPath(evaluatedPaths, start, end);
            }
            for (String neighbor:graph.get(current)) {
                if (!evaluatedPaths.containsKey(neighbor)) {
                    nodesToVisit.add(neighbor);
                    evaluatedPaths.put(neighbor, current);
                }
            }
        }
        return new ArrayList<>();
    }

    private static List<String> getPath(Map<String, String> previous, String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        for (int i=0, j=path.size()-1; i<j; i++, j--) {
            String temp = path.get(i);
            path.set(i, path.get(j));
            path.set(j, temp);
        }
        return path;
    }
}
