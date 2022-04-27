/**
 * CSES Problem Set
 * Dice Combinations
 */
import java.util.*;
public class Dice {
    static long[] c;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        c = new long[n+1];
        long res = count(n);
        System.out.print(res);
    }
    static long count(int k) {
        if (c[k] != 0) return c[k];
        else if (k <= 2) c[k] = k;
        else {
            long sum = 0; 
            for (int i = Math.max(0, k-6); i < k; i++) {
                sum += count(i) % (10E9 + 7);
                sum %= (10E9 + 7);
            }
            if (k <= 6) sum++;
            c[k] = sum;
        }
        return c[k];
    }
}