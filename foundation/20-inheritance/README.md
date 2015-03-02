## Inheritance

Open your command prompt and `cd` to this README's directory (`foundation/20-inheritance`). Edit the following three files:

* `Chihuahua.java`
Extend the `Dog` class. Chihuahuas have a high metabolism; they only grow to a new size after being fed *five times*.

* `GreatDane.java`
Extend the `Dog` class. Great Danes can get rather large. Add another size category for them, “huge”. If a Great Dane is “large,” it becomes “huge” after *three additional meals*.

* `GoldenRetriever.java`
Extend the `Dog` class. Golden Retrievers are incredibly athletic. They shrink by one size after *only three plays*.

Make sure you name the classes *identically* to their respective file names. Otherwise, the tests will fail. Most importantly, the implementation of `Dog` differs from the previous assignment. Pay particular attention to the following four methods: `changeSize(boolean)`, `getSizeIndex()`, `getSizeIndex(String)` and `fromSizeIndex(int)`. These are helper methods that you may override.

After you've finished, compile your Java code by running the following command:

```bash
$ javac -d bin/ src/com/bloc/inherit/*
```

Correct compilation errors as they are a result of modifications made by you.

After it returns successfully, `cd` to the bin directory:

```bash
$ cd bin/
```

From within bin, execute your code by running the following command:

```bash
$ java com.bloc.inherit.Main
```

If you see a nice congrats message, you've written some pretty solid subclasses.

## All Done?

Commit and push your work to GitHub:

```bash(/Users/your_user_name/where/you/keep/your/work/android-source)
$ git add .
$ git commit -m "Checkpoint 20 completed"
$ git push
```