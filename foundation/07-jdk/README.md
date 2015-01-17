## Your First Java Class

To get this show on the road, open your command prompt and `cd` into this README's directory (jdk).

Run the following command:

``` bash
$ javac -d bin src/com/bloc/firstpackage/MyFirstJavaClass.java
```

If you see an error, check to make sure you've typed in the command exactly and try again.

After it returns successfully, `cd` into the bin directory:

``` bash
$ cd bin/
```

From within bin, run the following command:

``` bash
$ java com.bloc.firstpackage.MyFirstJavaClass
```

You should see the following outputted to your prompt:

```
Welcome to Bloc's Android apprenticeship! You're on your way!
```

Congratulations, you've ran some pretty gnarly code! Ready for more? Of course you are.

## All Done?

Commit and push your work to GitHub:

```bash(/Users/your_user_name/where/you/keep/your/work/android-source)
$ git add .
$ git commit -m "Checkpoint 7 completed"
$ git push
```
