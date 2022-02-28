/*
USACO 2020 February Contest, Bronze
Problem 2. Mad Scientist

SAMPLE INPUT:
7
GHHHGHH
HHGGGHH
SAMPLE OUTPUT:
2

submission
1   
*/

import java.io.*;
import java.util.*;
public class MadScientist {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char[] a = new char[n];
        char[] b = new char[n];
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        int count = 0; 
        if (a[0] != b[0]) count = 1; 
        for (int i = 0; i < n-1; i++) {
            if (a[i+1] != b[i+1] && a[i] == b[i]) count++;  
        }
        pw.println(count);
        pw.close();
    }
}
