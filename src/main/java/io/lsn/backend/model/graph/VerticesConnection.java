package io.lsn.backend.model.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class VerticesConnection {

    private final Integer leftVertice;

    private final Integer rightVertice;

    public boolean contains(Integer integer) {

        return Objects.equals(integer, leftVertice) || Objects.equals(integer, rightVertice);
    }
}
