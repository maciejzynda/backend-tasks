package io.lsn.backend.tasks.impl;

import io.lsn.backend.AbstractTest;
import io.lsn.backend.tasks.impl.TaskSecond;
import org.junit.jupiter.api.Test;

class TaskSecondTest extends AbstractTest {

    private static final String INPUT_STRING = "1 2 10 7 5 3 6 6 13 0" + System.lineSeparator();

    private static final String OUTPUT_STRING = "0 13" + System.lineSeparator() +
            "3 10" + System.lineSeparator() +
            "6 7" + System.lineSeparator() +
            "6 7" + System.lineSeparator();

    protected TaskSecondTest() {

        super(INPUT_STRING, OUTPUT_STRING);
    }

    @Override
    @Test
    public void execute() {

        super.executeTest(TaskSecond::new);
    }
}