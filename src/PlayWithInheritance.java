/**
 * Just some Java code to allow you to explore inheritance, constructor
 * chaining, and polymorphism ("dynamic method lookup")
 * 
 */

public class PlayWithInheritance
{
	public static int RUN_EXAMPLE = 1; // change this to try different behaviors
										// below

	public static void main(String[] args)
	{
		StdOut.println();

		// common to all examples...

		// which constructors are called in the following?

		Die singleDie = new Die();
		CrookedDie1 crooked1 = new CrookedDie1();
		CrookedDie2 crooked2 = new CrookedDie2();

		StdOut.println();

		// change RUN_EXAMPLE above to run any one of the following 6 examples

		switch(RUN_EXAMPLE) {
		
			case 1: StdOut.println("Note the output: constructor chaining.");
			case 2: {
				
				// When a reference is treated like a String
				// => toString() is automatically invoked, and its returned value
				// used instead!
				
				StdOut.println(singleDie.toString());
				StdOut.print("toString() automatically called when reference treated as String: ");
				StdOut.println(singleDie.toString());
				StdOut.println("Concatenating a string to a reference: " + singleDie.toString());
			}
			case 3: {
				// concatenate " " + super.toString() to end of toString() code
				// inside each of 3 classes, then watch the result when run again.

				StdOut.println("die1's toString(): '" + singleDie + "'");
				StdOut.println("crooked1's toString(): '" + crooked1 + "'");
				StdOut.println("crooked2's toString(): '" + crooked2 + "'");
			}
			case 4: {
				// Die alias = die1; // try replacing this line with either below
				Die alias = crooked1; // upcasting!
				// Die alias = crooked2; // ditto

				StdOut.println("alias's toString(): '" + alias.toString() + "'");
				StdOut.println();
			}
			case 5: {
				Die alias;

				double toss = Math.random(); // [0.0..1.0)

				if (toss < 0.333) alias = singleDie;
				else if (toss < 0.666)	alias = crooked1;
				else alias = crooked2;

				// Can the compiler figure out the actual type
				// of alias in the following call?
				// No => dynamic runtime lookup happens

				describe("Which toString() is called? Answer is: ", alias);
			}
			case 6: {
				Dice dice = new Dice(singleDie, crooked1); // we'll try substituting here

				dice.roll();

				int result = dice.getLastRoll();

				StdOut.printf("Roll of '%s' and '%s' is: %d.\n", singleDie, crooked1, result);
			}
		
		}
		
		StdOut.println();
	}

	/**
	 * Shows polymorphism via passing either Die ref as toDescribe, or
	 * CrookedDie1 or CrookedDie2 ref instead
	 * 
	 * @param msg
	 * @param toDescribe
	 */

	public static void describe(String msg, Die toDescribe)
	{
		StdOut.printf("%s '%s' \n", msg, toDescribe.toString());
	}

}
