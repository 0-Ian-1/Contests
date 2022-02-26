/*
USACO 2017 December Contest, Bronze
Problem 3. Milk Measurement

SAMPLE INPUT:
4
7 Mildred +3
4 Elsie -1
9 Mildred -1
1 Bessie +2
SAMPLE OUTPUT:
3

submission
1   10/10 (with hints from solution)
*/

import java.util.*;
import java.io.*;
public class MilkMeasurement {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = 7; int e = 7; int m = 7;    // cow's milk production
        int[] d = new int[n];               // day
        String[] c = new String[n];         // cow name
        int[] dm = new int[n];              // change in production
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            c[i] = st.nextToken();
            dm[i] = Integer.parseInt(st.nextToken());
        }
        int hi = 0; int count = 0;
        boolean bon = true; boolean eon = true; boolean mon = true; 
        for (int i = 1; i <= 100; i++) {    // loop to start at day 1 to day 100
            for (int j = 0; j < n; j++) {
                if (d[j] == i) {
                    if (c[j].equals("Bessie")) b += dm[j];
                    else if (c[j].equals("Elsie")) e += dm[j];
                    else m += dm[j];
                }
                hi = Math.max(b, Math.max(e, m));
                // if any cow get on /get down the board, update, increment count
                if ((eon != (e == hi)) || (bon != (b == hi)) || mon != (m == hi)) count++;
                eon = e == hi;
                bon = b == hi;
                mon = m == hi;
            }
        }
        pw.println(count);
        pw.close();
    }
}
