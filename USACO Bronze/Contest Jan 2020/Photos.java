/*
USACO 2021 January Contest, Bronze
Problem 2. Even More Odd Photos

SAMPLE INPUT:
7
1 3 5 7 9 11 13
SAMPLE OUTPUT:
3

SAMPLE INPUT:
7
11 2 17 13 1 15 3
SAMPLE OUTPUT:
5

submission
1   6/11
2   7/11    should be (odd-even) % 3, not odd % 3
3   11/11
*/
import java.util.*;
public class Photos {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int even = 0;
        int odd = 0;
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            if (a % 2 == 0) even++;
            else odd++;
        }
        int sol = 1;
        if (even > odd) sol = odd * 2 + 1;
        else if (even == odd) sol = even + odd;
        // odd is more than even
        else { 
            sol = even * 2 + (odd-even)/3 * 2;
            if ((odd-even)%3 == 1) sol--;
            if ((odd-even)%3 == 2) sol++;
        }
        System.out.println(sol);
    }
}