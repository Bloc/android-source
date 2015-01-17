## Exceptions

Open your command prompt and `cd` into this README's directory (`foundation/29-exceptions`). Inside `Main.java` are two methods: `tryGetMax` and `tryRemove`. These methods call a couple others from within `FunMethods.java` which may or may not throw some exceptions.

Compile and execute the code in order to locate the first uncaught exception. Modify `Main.java` with the fewest uses of `try… catch` in order to correct the errors.

After you've finished, compile your code by running the following command:

```bash
$ javac -d bin src/com/bloc/exceptions/*.java
```

After it compiles successfully, `cd` into the bin directory:

```bash
$ cd bin/
```

From within bin, execute your code by running the following command:

```bash
$ java com.bloc.exceptions.Main
```

If you see a nice congrats message, you've caught some hot exceptions!

## All Done?

Commit and push your work to GitHub:

```bash(/Users/your_user_name/where/you/keep/your/work/android-source)
$ git add .
$ git commit -m "Checkpoint 29 completed"
$ git push
```