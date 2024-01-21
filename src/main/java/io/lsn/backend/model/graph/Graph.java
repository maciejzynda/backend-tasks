package io.lsn.backend.model.graph;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Graph {

    private Set<Integer> connectedVertices;

    public Graph(VerticesConnection currentConnection) {

        connectedVertices = new HashSet<>();
        addConnection(currentConnection);
    }

    public Graph(Set<Integer> set) {

        connectedVertices = set;
    }

    public void addConnection(VerticesConnection currentConnection) {

        connectedVertices.add(currentConnection.getLeftVertice());
        connectedVertices.add(currentConnection.getRightVertice());
    }

    public boolean containsVerticeFromConnection(VerticesConnection currentConnection) {

        return connectedVertices.stream()
                .anyMatch(currentConnection::contains);
    }
}
