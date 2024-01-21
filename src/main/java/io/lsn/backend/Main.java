package io.lsn.backend;

import io.lsn.backend.tasks.Task;
import io.lsn.backend.tasks.impl.TaskFirst;
import io.lsn.backend.tasks.impl.TaskSecond;
import io.lsn.backend.tasks.impl.TaskThird;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Wrong parameter. See README.md please.");
            System.exit(0);
        }

        Task task = null;
        switch (args[0]) {
            case "Task1":
                task = new TaskFirst(System.in, System.out);
                break;
            case "Task2":
                task = new TaskSecond(System.in, System.out);
                break;
            case "Task3":
                task = new TaskThird(System.in, System.out);
                break;
            default:
                System.out.println("Wrong parameter. See README.md please.");
                System.exit(0);
        }
        task.execute();
    }
}