/*
USACO 2021 January Contest, Bronze
Problem 3. Just Stalling

SAMPLE INPUT:
4
1 2 3 4
2 4 3 4
SAMPLE OUTPUT:
8

submission
1   06/12   did not use long for total
2   12/12
*/
import java.util.*;
public class Stalling {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] h = new long[n];
        long[] maxh = new long[n];
        for (int i = 0; i < n; i++) {
            h[i] = scan.nextLong();
        }
        for (int i = 0; i < n; i++) {
            maxh[i] = scan.nextLong();
        }
        Arrays.sort(h);
        // start with the tallest cow
        int rank = 0;
        long total = 1;
        for (int i = n-1; i >= 0; i--) {
            long cow = h[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (maxh[j] >= cow) count++;
            }
            total *= count-rank;
            rank++;
        }
        System.out.println(total);
    }
}
