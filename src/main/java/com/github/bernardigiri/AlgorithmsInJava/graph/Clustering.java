package com.github.bernardigiri.AlgorithmsInJava.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Implements k map clustering
 */
public class Clustering {

    public static class Point {

        int x;

        int y;

        public Point(int x, int y) {
            this.set(x, y);
        }

        public Point(Point p) {
            this.set(p);
        }

        public void set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void set(Point p) {
            this.set(p.x, p.y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static class Cluster {

        private final List<Point> points;

        private final Point center;

        public Cluster() {
            this.points = new ArrayList<>();
            this.center = new Point(0, 0);
        }

        public Cluster(List<Point> points, Point center) {
            this.points = points;
            this.center = center;
        }

        public List<Point> getPoints() {
            return points;
        }

        public Point getCenter() {
            return center;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(center.toString());
            sb.append("{");
            if (points.size() > 0) {
                for (int i = 0; i < points.size() - 1; i++) {
                    sb.append(points.get(i).toString());
                    sb.append(", ");
                }
                sb.append(points.get(points.size() - 1));
            }
            sb.append("}");
            return sb.toString();
        }

        public static String arrayToString(Cluster[] clusters) {
            StringBuilder sb = new StringBuilder();
            if (clusters.length>0) {
                for (int i = 0; i < clusters.length -1; i++) {
                    sb.append(clusters[i].toString());
                    sb.append("\n");
                }
                sb.append(clusters[clusters.length-1].toString());
            }
            return sb.toString();
        }
    }

    public static String renderGraph(Point[] graph) {
        Point min = new Point(graph[0]), max = new Point(graph[0]);
        getGraphExtremes(min, max, Arrays.asList(graph));
        max.x -= min.x;
        max.y -= min.y;
        boolean[][] grid = new boolean[max.y+1][max.x+1];
        for (Point p:graph) {
            grid[p.y-min.y][p.x-min.x] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (boolean[] row:grid) {
            for (boolean hasPoint:row) {
                if (hasPoint) {
                    sb.append("*");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String renderClusters(Cluster[] clusters, Point[] graph) {
        Point min = new Point(graph[0]), max = new Point(graph[0]);
        getGraphExtremes(min, max, Arrays.asList(graph));
        max.x -= min.x;
        max.y -= min.y;
        int[][] clusterGrid = new int[max.y+1][max.x+1];
        for (int i=0; i<clusters.length; i++) {
            for (Point p:clusters[i].getPoints()) {
                clusterGrid[p.y-min.y][p.x-min.x] = i + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] row:clusterGrid) {
            for (int point:row) {
                if (point == 0) {
                    sb.append(" ");
                } else {
                    sb.append(point);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Cluster[] kMeans(Point []graph, final int k) {
        Cluster[] clusters = new Cluster[k];
        for (int i=0; i<k; i++) {
            clusters[i] = new Cluster();
        }
        Point min = new Point(graph[0]), max = new Point(graph[0]);
        getGraphExtremes(min, max, Arrays.asList(graph));
        final int farthestDistance = distance(min, max);
        // randomly set cluster points
        for (int i=0; i<k; i++) {
            int x = ThreadLocalRandom.current().nextInt(min.x, max.x);
            int y = ThreadLocalRandom.current().nextInt(min.y, max.y);
            clusters[i].getCenter().set(x, y);
        }
        int maxIterations = Integer.MAX_VALUE;
        boolean anyChanges = false;
        for (int iterations=0; iterations<maxIterations; iterations++) {
            // populate cluster for selected points
            for (int i=0; i<graph.length; i++) {
                int closestDistance = farthestDistance + 1;
                Cluster closestCluster = null;
                for (int j=0; j<k; j++) {
                    int clusterDistance = distance(graph[i], clusters[j].getCenter());
                    if (clusterDistance < closestDistance) {
                        closestCluster = clusters[j];
                        closestDistance = clusterDistance;
                    }
                }
                closestCluster.getPoints().add(graph[i]);
            }
            // reset cluster points
            if (iterations < maxIterations -1) {
                for (int i=0; i<k; i++) {
                    List<Point> points = clusters[i].getPoints();
                    if (points.size() > 0) {
                        Point clusterMin = new Point(points.get(0)),
                                clusterMax = new Point(points.get(0));
                        getGraphExtremes(clusterMin, clusterMax, points);
                        Point oldCenter = clusters[i].getCenter();
                        Point updatedCenter = new Point(
                                centerPoint(clusterMin.x, clusterMax.x),
                                centerPoint(clusterMin.y, clusterMax.y));
                        if (!oldCenter.equals(updatedCenter)) {
                            anyChanges = true;
                            oldCenter.set(updatedCenter);
                        }
                    }
                }
                // there are changes then clear the old points, else return the cluster
                if (anyChanges) {
                    anyChanges = false;
                    for (int i=0; i<k; i++) {
                        clusters[i].getPoints().clear();
                    }
                } else {
                    return clusters;
                }
            }

        }
        return clusters;
    }

    private static int centerPoint(int min, int max) {
        return (max - min)/2 + min;
    }

    private static void getGraphExtremes(Point min, Point max, List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            max.x = Math.max(max.x, p.x);
            max.y = Math.max(max.y, p.y);
            min.x = Math.min(min.x, p.x);
            min.y = Math.min(min.y, p.y);
        }
    }

    private static int distance(Point p1, Point p2) {
        double a = Math.abs(p1.x - p2.x);
        double b = Math.abs(p1.y - p2.y);
        double c = Math.sqrt(a*a + b*b);
        return (int)Math.floor(c);
    }
}
