package sieve;

/**
 * This class generates prime numbers up to a user specified 
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 * Given an array of integers starting at 2:
 * Find the first uncrossed integer, and cross out all its 
 * multiples. Repeat until there are no more multiples
 * in the array.
 */
public class PrimeGenerator {
    
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        }



        return result;
    }
}
