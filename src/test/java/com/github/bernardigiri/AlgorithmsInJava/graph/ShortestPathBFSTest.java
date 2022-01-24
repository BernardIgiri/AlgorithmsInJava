package com.github.bernardigiri.AlgorithmsInJava.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ShortestPathBFSTest {

    private static Map<String, List<String>> defaultGraph() {
        Map<String,List<String>> graph = new HashMap<>();
        graph.put("Min", Arrays.asList(
                "William",
                "Jayden",
                "Omar"
        ));
        graph.put("William", Arrays.asList(
                "Min",
                "Noam"));
        graph.put("Jayden", Arrays.asList(
                "Min",
                "Amelia",
                "Ren",
                "Noam"));
        graph.put("Ren", Arrays.asList(
                "Jayden",
                "Omar"));
        graph.put("Amelia", Arrays.asList(
                "Jayden",
                "Adam",
                "Miguel"));
        graph.put("Adam", Arrays.asList(
                "Amelia",
                "Miguel",
                "Sofia",
                "Lucas"));
        graph.put("Omar", Arrays.asList(
                "Min",
                "Ren"));
        graph.put("Noam", Arrays.asList(
                "William",
                "Jayden"));
        graph.put("Miguel", Arrays.asList(
                "Amelia",
                "Adam"));
        graph.put("Sofia", Arrays.asList(
                "Adam"));
        graph.put("Lucas", Arrays.asList(
                "Adam"));
        return graph;
    }

    @Test
    public void shortestPathBFSMinAdam() throws Exception {
        Map<String,List<String>> graph = defaultGraph();
        List<String> actual = ShortestPathBFS.shortestPathBFS(graph, "Min", "Adam");
        List<String> expected = Arrays.asList("Min","Jayden","Amelia","Adam");
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void shortestPathBFSRenSofia() throws Exception {
        Map<String,List<String>> graph = defaultGraph();
        List<String> actual = ShortestPathBFS.shortestPathBFS(graph, "Ren", "Sofia");
        List<String> expected = Arrays.asList("Ren","Jayden","Amelia","Adam","Sofia");
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}