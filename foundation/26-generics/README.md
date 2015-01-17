## Generics

Open your command prompt and `cd` into this README's directory (`foundation/26-generics`). Edit `Main.java`, put a bunch of `Toy`s in the `ToyBox` by creating several `Toy` instances using the classes found in the `com.bloc.generics.things` package.

After you've finished, compile your code by running the following command:

```bash
$ javac -d bin src/com/bloc/generics/*.java src/com/bloc/generics/things/*.java
```

After it compiles successfully, `cd` into the bin directory:

```bash
$ cd bin/
```

From within bin, execute your code by running the following command:

```bash
$ java -ea com.bloc.generics.Main
```

If you see the congrats message, you've successfully added toys to your toy box!

## All Done?

Commit and push your work to GitHub:

```bash(/Users/your_user_name/where/you/keep/your/work/android-source)
$ git add .
$ git commit -m "Checkpoint 26 completed"
$ git push
```