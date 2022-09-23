package sieve;

public class Main {
    public static void main(String[] args) {
        for (int prime : PrimeGenerator.generatePrimes(15)) {
            System.out.println(prime);
        }
    }
}
