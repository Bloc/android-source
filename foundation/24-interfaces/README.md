## Interfaces

Open your command prompt and `cd` into this README's directory (`foundation/24-interfaces`). Populate three separate interfaces: `Driver.java`, `Skydiver.java` and `SalsaDancer.java`.

Have the three people classes (`Albert.java`, `Mary.java`, `John.java`) implement the appropriate interfaces as expected by `Main.java`.

After you've finished, compile your Java code by running the following command:

```bash
$ javac -d bin src/com/bloc/interfaces/*.java src/com/bloc/interfaces/*/*.java src/com/bloc/interfaces/*/*/*.java
```

Correct any compilation errors.

After it compiles successfully, `cd` into the bin directory:

```bash
$ cd bin/
```

From within bin, execute your code by running the following command:

```bash
$ java com.bloc.interfaces.Main
```

If you see a nice congrats message, you've implemented the methods properly.

## All Done?

Commit and push your work to GitHub:

```bash(/Users/your_user_name/where/you/keep/your/work/android-source)
$ git add .
$ git commit -m "Checkpoint 24 completed"
$ git push
```