package adsaufgabe2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prim_ssommer implements IPrim {
    public Prim_ssommer() {
    }

    @Override
    public boolean computeMSB(IGraph graph, int sourceVertex) {
        this.graph = graph;
        int numberVertices = graph.getNumberVertices();

        vertexData = IntStream.range(0, numberVertices)
                .mapToObj(index -> new Vertex(index))
                .toArray(Vertex[]::new);
        vertexData[sourceVertex].distance = 0;

        int order = 1;
        while (true) {
            Vertex next = nextVertex(vertexData);
            if (next == null) {
                break;
            }

            next.finished = true;
            next.order = order++;

            for (Vertex vertex : vertexData) {
                if (!graph.containsEdge(next.index, vertex.index)) {
                    continue;
                }

                if (!vertex.finished && graph.getWeight(next.index, vertex.index) < vertex.distance) {
                    vertex.distance = graph.getWeight(next.index, vertex.index);
                    vertex.predecessor = next.index;
                }
            }
        }

        return Stream.of(vertexData).noneMatch(vertex -> !vertex.finished);
    }

    @Override
    public int getPredecessor(int targetVertex) {
        if (targetVertex < 0 || targetVertex >= vertexData.length) {
            return -1;
        }
        return vertexData[targetVertex].predecessor;
    }

    @Override
    public int getSumOfWeights() {
        return Stream.of(vertexData)
                .filter(vertex -> vertex.predecessor != -1)
                .mapToInt(vertex -> graph.getWeight(vertex.index, vertex.predecessor))
                .sum();
    }

    @Override
    public int getProcessingOrder(int vertex) {
        if (vertex < 0 || vertex >= vertexData.length) {
            return 0;
        }
        return vertexData[vertex].order;
    }

    private static Vertex nextVertex(Vertex[] verticesData) {
        Vertex next = null;
        int minDistance = Integer.MAX_VALUE;
        for (Vertex data : verticesData) {
            if (!data.finished && data.distance < minDistance) {
                minDistance = data.distance;
                next = data;
            }
        }
        return next;
    }

    private class Vertex {
        Vertex(int vertex) {
            index = vertex;
            distance = Integer.MAX_VALUE;
            order = 0;
            predecessor = -1;
        }

        int index;
        int distance;
        int order;
        int predecessor;
        boolean finished;
    }

    private IGraph graph;
    private Vertex[] vertexData;
}
