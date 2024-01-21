package io.lsn.backend.tasks.impl;

import io.lsn.backend.tasks.AbstractTask;
import io.lsn.backend.utils.InputReader;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.TreeMap;

public class TaskSecond extends AbstractTask {

    private static final Integer BORDER_NUMBER = 13;

    // TreeSet contains unique and sorted elements by default
    // Performance of add elements to the tree: log(n)
    private final TreeMap<Integer, Integer> numbersAndOccurrences = new TreeMap<>();

    public TaskSecond(InputStream input, PrintStream output) {

        super(input, output);
    }

    @Override
    public void execute() {

        // Read first line from input or mock
        // and add every integer to the set and count its occurrences automatically
        // Read only number less than or equals 13
        new InputReader(input)
                .readAllIntegers(this::parseIntegerFromIO);

        // Print results
        for (Map.Entry<Integer, Integer> entry : numbersAndOccurrences.entrySet()) {

            Integer number = entry.getKey();
            Integer occurrence = entry.getValue();

            // Break the loop if the first number in pair is greater or equals than the second one
            int potentialPair = BORDER_NUMBER - number;
            if (number >= potentialPair) {
                break;
            }

            // Some pairs can occur multiple times
            // and have to be printed more than onec
            if (numbersAndOccurrences.containsKey(potentialPair)) {
                for (int a = 0; a < occurrence; a++) {
                    output.println(number + " " + potentialPair);
                }
            }
        }
    }

    private void parseIntegerFromIO(Integer integer) {

        if (integer <= BORDER_NUMBER) {
            Integer occurrence = numbersAndOccurrences.getOrDefault(integer, 0);
            numbersAndOccurrences.put(integer, ++occurrence);
        }
    }
}