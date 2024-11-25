/**
 * Find all prime numbers up to N using the Sieve of Eratosthenes algorithm.
 */

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {

    // Function to find all prime numbers up to N using the Sieve of Eratosthenes
    public static List<Integer> sieve(int N) {
        // Create a boolean array to mark prime numbers
        boolean[] isPrime = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();
        
        // Initialize all entries as true
        for (int i = 0; i <= N; i++) {
            isPrime[i] = true;
        }
        
        // Mark 0 and 1 as non-prime
        isPrime[0] = isPrime[1] = false;
        
        // Implement the sieve
        for (int p = 2; p * p <= N; p++) {
            // If p is prime, mark all multiples of p as non-prime
            if (isPrime[p]) {
                for (int i = p * p; i <= N; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        // Collect the prime numbers
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }

    public static void main(String[] args) {
        int N = 50; // Example, find all primes up to 50
        List<Integer> primes = sieve(N);
        
        // Print the prime numbers
        System.out.println("Prime numbers up to " + N + ": " + primes);
    }
}
