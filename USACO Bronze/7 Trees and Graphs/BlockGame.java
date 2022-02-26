/*
USACO 2016 December Contest, Bronze
Problem 2. Block Game
*/

import java.util.*;
import java.io.*;
public class BlockGame {
    public static void main(String args[]) throws IOException
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());        //n
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[26];
        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            int[] a1 = new int[26];
            int[] a2 = new int[26];
            for (int j = 0; j < s1.length(); j++)
            {
                char c = s1.charAt(j);
                a1[c-97]++;
            }
            String s2 = st.nextToken();
            for (int j = 0; j < s2.length(); j++)
            {
                char c = s2.charAt(j);
                a2[c-97]++;
            }
            for (int j = 0; j < 26; j++)
            {
                a[j] += Math.max(a1[j], a2[j]);
            }
        }
        for (int i = 0; i < 26; i++)
        {
            pw.println(a[i]);
        }
        pw.close();
    }
}
