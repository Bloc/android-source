## Methods

Open your command prompt and `cd` into this README's directory (methods). In the src path is a file named Methods.java. Open it and fill in the portions of the code where the comments have indicated.

When you've completed your work, test your code by compiling it with the following command:

``` bash
$ javac -d bin/ -classpath libs/test_jar.jar src/com/bloc/methods/Methods.java
```

Correct any and all errors that appear. If something goes wrong during compilation, it will be a result from the new code.

After it returns successfully, `cd` into the bin directory:

``` bash
$ cd bin/
```

From within bin, run the following command:

``` bash
# Replace ':' with ';' on Windows machines
$ java -cp .:../libs/test_jar.jar com.bloc.methods.Methods
```

If you see a message telling you that your methods worked perfectly, you're done! Commit your changes and push them to Github.