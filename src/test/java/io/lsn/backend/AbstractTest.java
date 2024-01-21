package io.lsn.backend;

import io.lsn.backend.tasks.Task;
import io.lsn.backend.utils.TestOutputStream;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractTest implements Task {

    private final String input;

    private final String output;

    protected AbstractTest(String input, String output) {

        this.input = input;
        this.output = output;
    }

    protected void executeTest(BiFunction<InputStream, PrintStream,Task> taskToTest) {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        TestOutputStream testOutputStream = new TestOutputStream();
        PrintStream printStream = new PrintStream(testOutputStream);

        Task task = taskToTest.apply(inputStream, printStream);
        task.execute();

        assertEquals(output, testOutputStream.toString());
    }
}
