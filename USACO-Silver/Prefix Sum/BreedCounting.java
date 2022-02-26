/*

USACO 2015 December Contest, Silver
Problem 3. Breed Counting

Farmer John's N cows, conveniently numbered 1…N, are all standing in a row (they seem to do so often that it now takes very little prompting from Farmer John to line them up). Each cow has a breed ID: 1 for Holsteins, 2 for Guernseys, and 3 for Jerseys. Farmer John would like your help counting the number of cows of each breed that lie within certain intervals of the ordering.
INPUT FORMAT (file bcount.in):
The first line of input contains N and Q (1≤N≤100,000, 1≤Q≤100,000).
The next N lines contain an integer that is either 1, 2, or 3, giving the breed ID of a single cow in the ordering.

The next Q lines describe a query in the form of two integers a,b (a≤b).

OUTPUT FORMAT (file bcount.out):
For each of the Q queries (a,b), print a line containing three numbers: the number of cows numbered a…b that are Holsteins (breed 1), Guernseys (breed 2), and Jerseys (breed 3).
SAMPLE INPUT:
6 3
2
1
1
3
2
1
1 6
3 3
2 4
SAMPLE OUTPUT:
3 2 1
1 0 0
2 0 1

submissions:
1   15/15

*/
import java.util.*;
import java.io.*;
public class BreedCounting {
    public static void main(String args[]) throws IOException{
        Scanner scan = new Scanner(new File("bcount.in"));
        PrintWriter pw = new PrintWriter("bcount.out");
        int N = scan.nextInt();
        int Q = scan.nextInt();
        int[] b1 = new int[N+1];
        int[] b2 = new int[N+1];
        int[] b3 = new int[N+1];
        for (int i = 0; i < N; i++) {
            b1[i+1] = b1[i];
            b2[i+1] = b2[i];
            b3[i+1] = b3[i];
            int ID = scan.nextInt();
            if (ID==1) b1[i+1]++;
            else if (ID==2) b2[i+1]++;
            else if (ID==3) b3[i+1]++;
        }
        int[] lo = new int[Q];
        int[] hi = new int[Q];
        for (int i = 0; i < Q; i++) {
            lo[i] = scan.nextInt();
            hi[i] = scan.nextInt();
        }
        for (int i = 0; i < Q; i++) {
            int a = b1[hi[i]]-b1[lo[i]-1];
            int b = b2[hi[i]]-b2[lo[i]-1];
            int c = b3[hi[i]]-b3[lo[i]-1];
            pw.println(a + " " + b + " " + c);
        }
        pw.close();
    }
}
