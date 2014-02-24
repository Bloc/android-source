## Classes

Open your command prompt and **CD** into this README's directory (interfaces). Convert `Person.java` into a non-abstract class and 3 separate interfaces: `Driver.java`, `Skydiver.java` and `SalsaDancer.java`. Have the 3 people (`Albert.java`, `Mary.java`, `John.java`) implement the appropriate interface expected by `Main.java`.

After you've finished, compile your Java code by running the following command:

``` bash
javac -d bin src/com/bloc/interfaces/*.java src/com/bloc/interfaces/people/*.java src/com/bloc/interfaces/people/hobbies/*.java
```

Correct compilation errors as they are a result of modifications made by you.

After it returns successfully, **CD** into the bin directory:

``` bash
cd bin/
```

From within bin, execute your code by running the following command:

``` bash
java com.bloc.interfaces.Main
```

If you see a nice congrats message, you've implemented the methods properly.

Commit and push your changes often.