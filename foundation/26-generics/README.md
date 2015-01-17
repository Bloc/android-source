## Generics

Open your command prompt and `cd` into this README's directory (`generics`). Edit `Main.java`, put a bunch of `Toy`s in the `ToyBox` by creating several `Toy` instances using the classes found in the `com.bloc.generics.things` package.

After you've finished, compile your code by running the following command:

``` bash
$ javac -d bin src/com/bloc/generics/*.java src/com/bloc/generics/things/*.java
```

After it compiles successfully, `cd` into the bin directory:

``` bash
$ cd bin/
```

From within bin, execute your code by running the following command:

``` bash
$ java -ea com.bloc.generics.Main
```

If you see a nice congrats message, you've successfully added toys to your toy box!

Commit and push your changes often.