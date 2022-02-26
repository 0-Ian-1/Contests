/*
USACO 2021 January Contest, Bronze
Problem 1. Uddered but not Herd

SAMPLE INPUT:
abcdefghijklmnopqrstuvwxyz
mood
SAMPLE OUTPUT:
3

submission
1   01/10   did not use the while loop. while > for loop.
2   10/10
*/
import java.util.*;
public class Herd {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String c = scan.nextLine();     // cowphabet
        String w = scan.nextLine();     // the word
        int count = 0;
        int i = 0;
        while (i < w.length()){
            for (int j = 0; j < 26; j++) {
                if (i < w.length() && w.charAt(i) == c.charAt(j)) i++; 
            }
            count++;
        }
        System.out.println(count);
    }
}
