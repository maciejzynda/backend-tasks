# Backend tasks

## Compile and package
Application requires Apache Maven. The command:

    mvn package

The jar will be created and ready to use in the command line.

The package folder is 'target' by default.
## Run
The application is an executable jar, so you just need to type the following command where the jar is located:

    java -jar tasks-1.0-SNAPSHOT-jar-with-dependencies.jar [task_name] < [data]
where:
- [task_name] - The name of the task: Task1 / Task2 / Task3
- [data] - The file that contains input data. Ex: data.txt

For sample:

		java -jar tasks-1.0-SNAPSHOT-jar-with-dependencies.jar Task1 < data.txt

## Solutions description

All task solutions have been described in comments in the source code.

See classes in the package:

	io.lsn.backend.tasks.impl

In case of question don't hesitate to ask.

Have a good day. 
