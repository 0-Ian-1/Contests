/*
USACO 2018 December Contest, Bronze
Problem 2. The Bucket List

SAMPLE INPUT:
3
4 10 1
8 13 3
2 6 2
SAMPLE OUTPUT:
4

submission
1   10/10
*/

import java.util.*;
import java.io.*;
public class BucketList {
    static int[][] interval;
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        int n = Integer.parseInt(br.readLine());
        interval = new int[n][3];               // si, ti, bi
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            interval[i][0] = Integer.parseInt(st.nextToken());
            interval[i][1] = Integer.parseInt(st.nextToken());
            interval[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(interval, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int count = 0; 
        for (int i = 0; i < n; i++) {
            count = Math.max(count, bucket(i));
        }
        pw.println(count);
        pw.close();
    }

    /**
     * at time t, cow index gets the milk. we schedule him with 
     * the buckets that are free. if a ealier cow has a later
     * finish time then index, index has to use buckets other then 
     * the buckets that cow is using, i.e., Ti > Sindex.
     * @param index
     * @return
     */
    public static int bucket(int index) {
        int count = interval[index][2];
        for (int i = 0; i < index; i++) {
            if (interval[i][1] > interval[index][0]) count += interval[i][2];
        }
        return count; 
    }
}