/*
USACO 2019 US Open Contest, Bronze
Problem 1. Bucket Brigade
*/
import java.util.*;
import java.io.*;

public class BucketBrigade {
    static int bx = 0; static int by = 0;
    static int rx = 0; static int ry = 0;
    static int lx = 0; static int ly = 0;
    public static void main(String args[]) throws IOException {
         // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
         for (int i = 0; i < 10; i++) {
             String s = br.readLine();
             for (int j = 0; j < 10; j++) {
                 char c = s.charAt(j);
                 if (c == 'B') { bx = i; by = j; } 
                 else if (c == 'R') { rx = i; ry = j; }
                 else if (c == 'L') { lx = i; ly = j; }
             }
         }
         int count;
         if (bx == rx && rx == lx && y()) count = Math.abs(by-ly)+1;
         else if(by == ly && ly == ry && x()) count = Math.abs(bx-lx)+1;
         else count = Math.abs(bx-lx) + Math.abs(by-ly) - 1;
         pw.println(count);
         pw.close();
    }
    public static boolean x() { return (bx < rx && rx < lx) || (bx > rx && rx > lx); }
    public static boolean y() { return (by < ry && ry < ly) || (by > ry && ry > ly); }
}
