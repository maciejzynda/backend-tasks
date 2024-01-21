package io.lsn.backend.tasks;

import io.lsn.backend.utils.InputReader;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class AbstractTask implements Task {

    protected final InputStream input;

    protected final PrintStream output;

    protected InputReader inputReader;

    public AbstractTask(InputStream input, PrintStream output) {

        this.input = input;
        this.inputReader = new InputReader(input);

        this.output = output;
    }

    public abstract void execute();
}
