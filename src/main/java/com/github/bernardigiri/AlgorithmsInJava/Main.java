package com.github.bernardigiri.AlgorithmsInJava;

import com.github.bernardigiri.AlgorithmsInJava.arrays.CommonSubsequence;
import com.github.bernardigiri.AlgorithmsInJava.graph.Clustering;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {
        System.out.println("See algorithm unit tests.");
        Random r = new Random();
        Clustering.Point[] graph = new Clustering.Point[30];
        for (int i=0;i<graph.length;i++) {
            graph[i] = new Clustering.Point(r.nextInt(140) + 10, r.nextInt(75));
        }
        System.out.println(Clustering.renderGraph(graph));
        Clustering.Cluster[] clusters = Clustering.kMeans(graph, 4);
        System.out.println(Clustering.renderClusters(clusters, graph));
    }
}
