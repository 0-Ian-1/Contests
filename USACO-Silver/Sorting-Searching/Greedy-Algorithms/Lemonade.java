/**
 * USACO 2018 US Open Contest, Silver
 * Problem 2. Lemonade Line
 */
import java.util.*;
import java.lang.*;
import java.io.*;
public class Lemonade {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("lemonade.in"));
        PrintWriter pw = new PrintWriter("lemonade.out");
        int N = scan.nextInt();
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = scan.nextInt();
        }
        Arrays.sort(w);
        int count = N;
        for (int i = 0; i < N; i++) {
            if (i > w[N-i-1]) {
                count = i;
                break;
            }
        }
        pw.println(count);
        pw.close();
        scan.close();
    }
}