## Singletons

Open your command prompt and `cd` into this README's directory (singletons). Edit `Speakerphone.java` to create a singleton messaging center. Classes found within `talkers/` and `listeners/` are meant to communicate with one another.

The project **does not** compile initially. After implementing the methods required in `Speakerphone.java`, attempt to compile the project:

```bash
$ javac -d bin src/com/bloc/singletons/*.java src/com/bloc/singletons/*/*.java
```

Fix any and all compilation errors. After it compiles successfully, `cd` into the bin directory:

```bash
$ cd bin/
```

From within bin, execute your code by running the following command:

```bash
$ java com.bloc.singletons.Main
```

If you see the success message, your assignment is done!