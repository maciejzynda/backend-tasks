package io.lsn.backend.tasks.impl;

import io.lsn.backend.AbstractTest;
import io.lsn.backend.tasks.impl.TaskThird;
import org.junit.jupiter.api.Test;

class TaskThirdTest extends AbstractTest {

    private static final String INPUT_STRING =
            "3" + System.lineSeparator() +
                    "4 3" + System.lineSeparator() +
                    "1 4" + System.lineSeparator() +
                    "5 6";
    private static final String OUTPUT_STRING = "2" + System.lineSeparator();

    protected TaskThirdTest() {

        super(INPUT_STRING, OUTPUT_STRING);
    }

    @Override
    @Test
    public void execute() {

        super.executeTest(TaskThird::new);
    }
}