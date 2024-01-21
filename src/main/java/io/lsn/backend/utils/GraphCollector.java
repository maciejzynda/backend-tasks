package io.lsn.backend.utils;

import io.lsn.backend.model.graph.Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GraphCollector implements Collector<Integer, Set<Integer>, Graph> {

    @Override
    public Supplier<Set<Integer>> supplier() {

        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<Integer>, Integer> accumulator() {

        return Set::add;
    }

    @Override
    public BinaryOperator<Set<Integer>> combiner() {

        return (a, b) -> {
            a.addAll(b);
            return a;
        };
    }

    @Override
    public Function<Set<Integer>, Graph> finisher() {

        return Graph::new;
    }

    @Override
    public Set<Characteristics> characteristics() {

        return Set.of(Characteristics.UNORDERED);
    }
}
