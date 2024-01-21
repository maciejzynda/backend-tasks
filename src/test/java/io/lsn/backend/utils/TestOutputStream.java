package io.lsn.backend.utils;

import java.io.OutputStream;

public class TestOutputStream extends OutputStream {

    private final StringBuilder string = new StringBuilder();

    @Override
    public void write(int b) {

        this.string.append((char) b);
    }

    @Override
    public String toString() {

        return this.string.toString();
    }
}
