package com.github.bernardigiri.AlgorithmsInJava;

import com.github.bernardigiri.AlgorithmsInJava.graph.Clustering;

public class Main {

    public static void main(String args[]) {
        System.out.println("See algorithm unit tests.");
        Clustering.Point[] graph = new Clustering.Point[]{
                new Clustering.Point(10, 100),
                new Clustering.Point(17, 105),
                new Clustering.Point(12, 115),
                new Clustering.Point(11, 125),
                new Clustering.Point(20, 117),
                new Clustering.Point(17, 120),
                new Clustering.Point(30, 105),
                new Clustering.Point(25, 120),
                new Clustering.Point(28, 115),
                new Clustering.Point(27, 112),
                new Clustering.Point(18, 125),
                new Clustering.Point(22, 119),
                new Clustering.Point(20, 117),
                new Clustering.Point(18, 118),
        };
        System.out.println(Clustering.renderGraph(graph));
        Clustering.Cluster[] clusters = Clustering.kMeans(graph, 4);
        System.out.println(Clustering.renderClusters(clusters, graph));
    }
}
