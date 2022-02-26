/*
USACO 2017 December Contest, Bronze
Problem 2. The Bovine Shuffle

SAMPLE INPUT:
5
1 3 4 5 2
1234567 2222222 3333333 4444444 5555555
SAMPLE OUTPUT:
1234567
5555555
2222222
3333333
4444444

logic: 
1. this is a simulation loop array index problem.
2. based on index mapping rules, assign the next index. 
3. derive the reversed mapping rule. 
4. loop each cow three times to get reversed shuffle. 
*/

import java.util.*;
import java.io.*;

public class BovineShuffle
{
    static int n;
    static int[] a;
    static int[] id;
    public static void main(String args[]) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());                // n
        n = Integer.parseInt(st.nextToken());
        a = new int[n];                                                         // a array
        id = new int[n];                                                        // id array
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            a[i] = Integer.parseInt(st.nextToken())-1;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            id [i] = Integer.parseInt(st.nextToken());
        }
        id = inverseShuffle();
        id = inverseShuffle();
        id = inverseShuffle();
        // System.out.println(Arrays.toString(id));
        for (int i = 0; i < n; i++)
        {
            pw.println(id[i]);
        }
        pw.close();
    }

    // shuffle: cow at position i gets to a[i], or id'[i] = id[a[i]]
    // inverse shuffle: cow at position a[i] get back to i. id[i] = id'[a[i]]
    public static int[] inverseShuffle()
    {
        int[] copy = new int[n];
        for (int i = 0; i < n; i++)
        {
            copy[i] = id[a[i]];
        }
        return copy;
    }
}