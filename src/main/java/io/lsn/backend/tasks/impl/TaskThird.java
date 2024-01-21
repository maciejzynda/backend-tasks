package io.lsn.backend.tasks.impl;

import io.lsn.backend.model.graph.Graph;
import io.lsn.backend.model.graph.VerticesConnection;
import io.lsn.backend.tasks.AbstractTask;
import io.lsn.backend.utils.GraphCollector;
import org.apache.commons.collections4.CollectionUtils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TaskThird extends AbstractTask {


    // List of all Graphs
    // A particular graph contains a set of its connected vertices
    // This solves the problem of duplicate vertices
    private final List<Graph> allGraphs = new ArrayList<>();

    int totalLinesCount;

    public TaskThird(InputStream input, PrintStream output) {

        super(input, output);
    }

    @Override
    public void execute() {

        // Read lines count
        inputReader.readOneInteger(integer -> totalLinesCount = integer);

        for (int i = 0; i < totalLinesCount; i++) {

            // Read next connection from IO
            VerticesConnection connection
                    = inputReader.readVerticesConnectionFromNewLine(VerticesConnection::new);

            // Find all graphs containing any of the vertices:
            // - One or more graphs found -> merge to one and add connected vertices there
            // - No graph found -> create it
            List<Graph> graphsToMerge = isConnectionBelongsToTheGraph(allGraphs, connection);
            if (CollectionUtils.isNotEmpty(graphsToMerge)) {
                Graph graph = mergeGraphsAndConnection(graphsToMerge, connection);
                allGraphs.add(graph);
                graphsToMerge.forEach(allGraphs::remove);
            } else {
                Graph graph = new Graph(connection);
                allGraphs.add(graph);
            }

        }

        // Print result
        output.println(allGraphs.size());
    }

    private static Graph mergeGraphsAndConnection(List<Graph> connectionBelongsToGraph, VerticesConnection currentConnection) {

        Graph mergedGraph = connectionBelongsToGraph.stream()
                .map(Graph::getConnectedVertices)
                .flatMap(Collection::stream)
                .collect(createMergedGraph());

        mergedGraph.addConnection(currentConnection);
        return mergedGraph;
    }

    private static Collector<Integer, Set<Integer>, Graph> createMergedGraph() {

        return new GraphCollector();
    }

    private static List<Graph> isConnectionBelongsToTheGraph(List<Graph> allGraphs, VerticesConnection currentConnection) {

        return allGraphs.stream()
                .filter(graph -> graph.containsVerticeFromConnection(currentConnection))
                .collect(Collectors.toList());
    }
}