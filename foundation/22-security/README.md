## Security And Packages

Open your command prompt and `cd` into this README's directory (`foundation/22-security`). The sample code **does not compile**. Fix the access and package organization of this project. You will need to move or modify **all files**, including `Main.java`.

Begin by attempting to compile the application using the following command:

```bash
$ javac -d bin src/com/bloc/securitypackages/*/*.java src/com/bloc/securitypackages/*.java
```

All of the compilation errors may be fixed by importing and assigning proper access modifiers. Continue to tweak the project until it compiles successfully. Then `cd` into the `bin/` directory:

```bash
$ cd bin/
```

From within bin, execute your code by running the following command:

```bash
$ java com.bloc.securitypackages.Main
```

If you see a nice congrats message, everything's been properly organized!

## All Done?

Commit and push your work to GitHub:

```bash(/Users/your_user_name/where/you/keep/your/work/android-source)
$ git add .
$ git commit -m "Checkpoint 22 completed"
$ git push
```
