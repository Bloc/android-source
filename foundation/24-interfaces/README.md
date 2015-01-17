## Interfaces

Open your command prompt and `cd` into this README's directory (interfaces). Populate the 3 separate interfaces: `Driver.java`, `Skydiver.java` and `SalsaDancer.java`.

Have the 3 people (`Albert.java`, `Mary.java`, `John.java`) implement the appropriate interfaces as expected by `Main.java`.

After you've finished, compile your Java code by running the following command:

``` bash
$ javac -d bin src/com/bloc/interfaces/*.java src/com/bloc/interfaces/*/*.java src/com/bloc/interfaces/*/*/*.java
```

Correct any compilation errors.

After it compiles successfully, `cd` into the bin directory:

``` bash
$ cd bin/
```

From within bin, execute your code by running the following command:

``` bash
$ java com.bloc.interfaces.Main
```

If you see a nice congrats message, you've implemented the methods properly.

Commit and push your changes often.