/*
USACO 2020 January Contest, Bronze
Problem 1. Word Processor

10 7
hello my name is Bessie and this is my essay
SAMPLE OUTPUT:
hello my
name is
Bessie
and this
is my
essay

submission
1   10/10
*/

import java.util.*;
import java.io.*;
public class WordProcessor {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("word.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] a = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = st.nextToken();
        }
        int count = 0; 
        for (int i = 0; i < n; i++) {
            if (count == 0) { pw.print(a[i]); count += a[i].length(); }
            else if (count + a[i].length() <= k) { pw.print(" " + a[i]); count += a[i].length(); }
            else { pw.println(); count = 0; i--; }
        }
        pw.close();
    }
}
