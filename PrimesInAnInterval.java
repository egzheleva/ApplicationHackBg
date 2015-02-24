/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primesinaninterval;

/**
 *
 * @author eli
 */
public class PrimesInAnInterval {

    public int sumOfDivisors(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public boolean isPrime(int n) {
        return n == sumOfDivisors(n);
    }

    public void primesInAnInterval(int from, int to) {
        if (from < 0 || to < 0 || from > to) {
            System.out.print("Invalid input!");
            System.exit(0);
        }
        while (from <= to) {
            if (isPrime(from)) {
                System.out.println(from);
                from++;
            } else {
                from++;
            }
        }
    }
    
    public static void main(String[] args) {
        PrimesInAnInterval p = new PrimesInAnInterval();
        p.primesInAnInterval(1, 100);
    }

    
}
