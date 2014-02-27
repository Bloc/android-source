## Threads

Open your command prompt and `cd` into this README's directory (threads). Extract the image downloading code found in `Main.java` to a separate thread class, `ImageGetter.java`.

Allow custom URLs and a boolean option for whether or not the file should be launched after completion. Start an **ImageGetter** thread in place of the code found in **Main**.

After you've finished, compile your code by running the following command:

``` bash
$ javac -d bin src/com/bloc/threads/*.java
```

After it compiles successfully, `cd` into the bin directory:

``` bash
$ cd bin/
```

From within bin, execute your code by running the following command:

``` bash
$ java com.bloc.threads.Main
```

2 things should happen: your image should appear and the congratulations text should be printed to the prompt. If both occur, well done!

Commit and push your changes often.