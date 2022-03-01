/*
USACO 2020 January Contest, Bronze
Problem 2. Photoshoot

5
4 6 7 6
SAMPLE OUTPUT:
3 1 5 2 4

submission
1   1/10    problem unsolved

*with help of solution. The key is to generate permutation, 
but only on a[0] since the rest has to be fixed. Then, 
since the array a should not contain duplicates, we can 
achieve our goal by disregarding the outputs that contains
duplicates.
*/
import java.util.*;
import java.io.*;
public class Photoshoot {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("photo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];                   // array of a
        int[] b = new int[n-1];                 // array of b
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        boolean bad = false;
        for (int i = 1; i < b[0]; i++) {
            a[0] = i;
            boolean[] x = new boolean[2000];   // whether there is any duplicates
            for (int j = 1; j < n; j++) {
                a[j] = b[j-1] - a[j-1];
                if (a[j] <= 0 || x[a[j]]) { bad = true; break; }
                x[a[j]] = true;
            }
            if (!bad) break;
        }
        for (int i = 0; i < n; i++) {
            if (i == n-1) pw.print(a[i]);
            else pw.print(a[i] + " ");
        }
        pw.close();
    }
}
