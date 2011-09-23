package dstywho.probably;

//--------------------------------------
//Systematically generate combinations.
//--------------------------------------

import java.math.BigInteger;

public class CombinationGenerator {

	private int[] a;
	private int n;
	private int r;
	private BigInteger numLeft;
	private BigInteger total;

	// ------------
	// Constructor
	// ------------
/**
 * The class is very easy to use. Suppose that you wish to generate all possible three-letter combinations of the letters "a", "b", "c", "d", "e", "f", "g". Put the letters into an array. Keep calling the combination generator's getNext () method until there are no more combinations left. The getNext () method returns an array of integers, which tell you the order in which to arrange your original array of letters. Here is a snippet of code which illustrates how to use the CombinationGenerator class.

String[] elements = {"a", "b", "c", "d", "e", "f", "g"};
int[] indices;
CombinationGenerator x = new CombinationGenerator (elements.length, 3);
StringBuffer combination;
while (x.hasMore ()) {
  combination = new StringBuffer ();
  indices = x.getNext ();
  for (int i = 0; i < indices.length; i++) {
    combination.append (elements[indices[i]]);
  }
  System.out.println (combination.toString ());
}
 */
	public CombinationGenerator(int n, int r) {
		if (r > n) {
			throw new IllegalArgumentException();
		}
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		this.n = n;
		this.r = r;
		a = new int[r];
		BigInteger nFact = getFactorial(n);
		BigInteger rFact = getFactorial(r);
		BigInteger nminusrFact = getFactorial(n - r);
		total = nFact.divide(rFact.multiply(nminusrFact));
		reset();
	}

	// ------
	// Reset
	// ------

	public void reset() {
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		numLeft = new BigInteger(total.toString());
	}

	// ------------------------------------------------
	// Return number of combinations not yet generated
	// ------------------------------------------------

	public BigInteger getNumLeft() {
		return numLeft;
	}

	// -----------------------------
	// Are there more combinations?
	// -----------------------------

	public boolean hasMore() {
		return numLeft.compareTo(BigInteger.ZERO) == 1;
	}

	// ------------------------------------
	// Return total number of combinations
	// ------------------------------------

	public BigInteger getTotal() {
		return total;
	}

	// ------------------
	// Compute factorial
	// ------------------

	private static BigInteger getFactorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i = n; i > 1; i--) {
			fact = fact.multiply(new BigInteger(Integer.toString(i)));
		}
		return fact;
	}

	// --------------------------------------------------------
	// Generate next combination (algorithm from Rosen p. 286)
	// --------------------------------------------------------

	public int[] getNext() {

		if (numLeft.equals(total)) {
			numLeft = numLeft.subtract(BigInteger.ONE);
			return a;
		}

		int i = r - 1;
		while (a[i] == n - r + i) {
			i--;
		}
		a[i] = a[i] + 1;
		for (int j = i + 1; j < r; j++) {
			a[j] = a[i] + j - i;
		}

		numLeft = numLeft.subtract(BigInteger.ONE);
		return a;

	}
}