package io.lsn.backend.tasks.impl;

import io.lsn.backend.AbstractTest;
import io.lsn.backend.tasks.impl.TaskFirst;
import org.junit.jupiter.api.Test;

class TaskFirstTest extends AbstractTest {

    private static final String INPUT_STRING = "1 10 20 20 2 5" + System.lineSeparator();

    private static final String OUTPUT_STRING = "1 2 5 10 20" + System.lineSeparator() +
            "count: 6" + System.lineSeparator() +
            "distinct: 5" + System.lineSeparator() +
            "min: 1" + System.lineSeparator() +
            "max: 20" + System.lineSeparator();

    protected TaskFirstTest() {

        super(INPUT_STRING, OUTPUT_STRING);
    }


    @Override
    @Test
    public void execute() {

        super.executeTest(TaskFirst::new);
    }
}