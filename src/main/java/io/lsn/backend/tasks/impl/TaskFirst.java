package io.lsn.backend.tasks.impl;

import io.lsn.backend.tasks.AbstractTask;
import io.lsn.backend.utils.InputReader;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.SortedSet;
import java.util.TreeSet;

public class TaskFirst extends AbstractTask {

    private long totalElementsCount;

    // TreeSet contains unique and sorted elements by default
    // Performance of add elements to the tree: log(n)
    // It is more optimal than an array or linked list because do not require additional sorting
    private final SortedSet<Integer> sortedAndUniqueElements = new TreeSet<>();

    public TaskFirst(InputStream input, PrintStream output) {

        super(input, output);
    }

    @Override
    public void execute() {

        // Read all numbers and add to the set
        new InputReader(input)
                .readAllIntegers(this::readData);

        int size = sortedAndUniqueElements.size();
        if (size > 0) {

            // Store statistics
            Integer first = sortedAndUniqueElements.first();
            Integer last = sortedAndUniqueElements.last();

            // Print elements in ascending order by removing elements
            // It is an optimal method in terms of CPU and heap usage
            // and do not require conversion to array or anything else.
            // The stream could cause stack overflow with huge data set.
            // Performance - n * log(n)
            for (int i = 1; i < size; i++) {
                output.print(sortedAndUniqueElements.removeFirst() + " ");
            }
            // Print the last element without dangling space in the end of line
            output.println(sortedAndUniqueElements.last());

            // Print statistics
            output.println("count: " + totalElementsCount);
            output.println("distinct: " + size);
            output.println("min: " + first);
            output.println("max: " + last);
        }
    }

    private void readData(Integer integer) {

        sortedAndUniqueElements.add(integer);
        totalElementsCount++;
    }
}