package io.lsn.backend.utils;

import io.lsn.backend.model.graph.VerticesConnection;

import java.io.InputStream;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class InputReader {

    Scanner scanner;

    public InputReader(InputStream is) {

        scanner = new Scanner(is);
    }

    public void readAllIntegers(Consumer<Integer> intConsumer) {

        while (scanner.hasNextInt()) {
            int nextInt = scanner.nextInt();
            intConsumer.accept(nextInt);
        }
    }

    public VerticesConnection readVerticesConnectionFromNewLine(BiFunction<Integer, Integer, VerticesConnection> bi) {

        return bi.apply(scanner.nextInt(), scanner.nextInt());
    }

    public void readOneInteger(Consumer<Integer> intConsumer) {

        int nextInt = scanner.nextInt();
        intConsumer.accept(nextInt);
    }
}
