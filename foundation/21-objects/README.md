## Objects

Open your command prompt and `cd` into this README's directory (`foundation/21-objects`). Edit the following files:

* `Artist.java`
* `Ensemble.java`
* `Song.java`
* `PopSong.java`

Each of these classes are missing their constructors, fill them in where the comments have indicated. After you've finished, compile your Java code by running the following command:

```bash
$ javac -d bin src/com/bloc/objects/*
```

Correct compilation errors as they are a result of modifications made by you.

After it returns successfully, `cd` into the bin directory:

```bash
$ cd bin/
```

From within bin, execute your code by running the following command:

```bash
$ java com.bloc.objects.Main
```

If you see a nice congrats message, your constructors are rocking it.

## All Done?

Commit and push your work to GitHub:

```bash(/Users/your_user_name/where/you/keep/your/work/android-source)
$ git add .
$ git commit -m "Checkpoint 21 completed"
$ git push
```