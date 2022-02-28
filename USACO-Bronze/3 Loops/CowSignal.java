/*
USACO 2016 December Contest, Bronze
Problem 3. The Cow-Signal
 */

import java.util.*;
import java.io.*;

public class CowSignal {
    public static void main(String args[]) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());    // 5 4 2
        int m = Integer.parseInt(st.nextToken());                   // 5
        int n = Integer.parseInt(st.nextToken());                   // 4
        int k = Integer.parseInt(st.nextToken());                   // 2

        char[][] signal = new char[m][n];                           // create 2D array and copy the data
        for (int i = 0; i < m; i++)
        {
            String s = br.readLine();
            for (int j = 0; j < n; j++)
            {
                signal[i][j] = s.charAt(j);
            }
        }

        char[][] amplified = new char[k*m][k*n];                    // loop to print signal[i] k times to the right and down.
        for (int i = 0; i < k*m; i += k)                            // or, we can loop to print signal[i] k times, then
        {                                                           // loop that line k times. 
            for (int j = 0; j < k*n; j += k)                        // in this way, we can amplify the signal as we read it
            {
                char c = signal[i/k][j/k];
                for (int x = i; x < k+i; x++)
                {
                    for (int y = j; y < k+j; y++)
                    {
                        amplified[x][y] = c;

                    }
                }
            }
        }

        System.out.println();
        
        for (int i = 0; i < m*k; i++){
            for (int j = 0; j < n*k; j++){
                pw.print(amplified[i][j]);
            }
            pw.println();
        }
        pw.close();
    }
}
