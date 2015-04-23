## Bloc's Android Source Repository

This repository contains the source code required to complete assignments associated with Bloc's Android curriculum.

## Assignments

Each assignment's source code is found in its corresponding directory in `foundation`. For example, the assignment for checkpoint number 23, "Static," is found in `foundation/23-static`.

Detailed assignment instructions are provided in a `README.md` file within each assignment's directory. **Read the instructions thoroughly** before proceeding. Not all assignments will compile immediately. For example, the assignment for checkpoint 12, "Syntax," does *not* compile without additional work. However, if an assignment compiles, that *does not* mean you have completed it.

**Every** assignment requires work and/or modification.

## Work Requirements

Assignment source files feature call-outs to locations where work must be completed. These are provided in the form of multi-line comments such as:

```java
		/*****************************************************************
		 *	ASSIGNMENT:
		 *	Assign 2.1 into dubs
		 *	Then divide dubs by itself
		******************************************************************/

		double dubs;

		if (!testX(x)) {
```

These multi-line assignment call-outs precede the area where work must be done. Therefore, read the assignment and implement the solution immediately beneath it. The completed work resembles:

```java
		/*****************************************************************
		 *	ASSIGNMENT:
		 *	Assign 2.1 into dubs
		 *	Then divide dubs by itself
		******************************************************************/

		double dubs = 2.1d;
		dubs /= dubs;

		if (!testX(x)) {
```

## Method Requirements

Method headers are used to specify where a method must be created by *you*. For instance:

```java
	/*
	 * returnNegative
	 * 
	 * This method returns the negated value of the given parameter.
	 *
	 * @param original the original integer value
	 * @return the negated integer value of original
	 */
	// ADD YOUR METHOD HERE, NAME MUST MATCH DESCRIPTION
```

In the description above, it demands a method named `returnNegative`. The method you create **must** match the method name found in the description. The statement following the method's name is a brief description of its purpose.

The `@param` specifies a single parameter. It is immediately followed by the name of the parameter and a short description. The order of `@param` qualifiers (from top-to-bottom) implies the order of parameters (left-to-right), these **must** match exactly.

Lastly, the `@return` informs you of which type of value this method must return. If it reads, `@return nothing`, then this method must return a `void` type. Given the description above, here is the completed method:

```java
	/*
	 * returnNegative
	 * 
	 * This method returns the negated value of the given parameter.
	 *
	 * @param original the original integer value
	 * @return the negated integer value of original
	 */
	 int returnNegative(int original) {
	     return -original;
	 }
```

## Look But Don't Touch

Do **not** *change*, *modify*, *move*, or otherwise *alter* in any way, shape or form the existing code unless explicitly instructed to by the assignment call-out or method header.

However, you are free to modify and experiment with the existing code found within after successfully completing the assignment and having received a verified completion from your mentor.