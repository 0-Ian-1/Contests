/*
USACO 2017 US Open Contest, Bronze
Problem 2. Bovine Genomics

3 8
AATCCCAT
GATTGCAA
GGTCGCAA
ACTCCCAG
ACTCGCAT
ACTTCCAT
SAMPLE OUTPUT:
1
*/

import java.util.*;
import java.io.*;
public class BovineGenomics {
    public static void main(String args[]) throws IOException
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());        //n m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] s = new boolean[4][m];                                    // soptty 
        boolean[][] p = new boolean[4][m];                                    // plain
        for (int i = 0; i < n; i++)
        {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
            {
                char c = str.charAt(j);
                s[gti(c)][j] = true;
            }
        }
        for (int i = 0; i < n; i++)
        {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
            {
                char c = str.charAt(j);
                p[gti(c)][j] = true;
            }
        }
        int count = 0; 
        for (int j = 0; j < m; j++)
        {
            if (s[0][j] && p[0][j] || s[1][j] && p[1][j] || s[2][j] && p[2][j] || s[3][j] && p[3][j]) count += 0;
            else {
                count++;
            }
        }
        pw.println(count);
        pw.close();
        /*
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }
        */
    }

    public static int gti(char g)
    {
        if (g == 'A') return 0;
        else if (g == 'C') return 1;
        else if (g == 'G') return 2;
        else return 3;
    }
}
