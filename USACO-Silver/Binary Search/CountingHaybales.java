/*
USACO 2016 December Contest, Silver
Problem 1. Counting Haybales
*/
import java.io.*;
import java.util.*;
public class CountingHaybales {
    public static void main(String args[]) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) { 
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int lo = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(a, hi) - binarySearch(a, lo) + 1);
        }
    }

    static int binarySearch(int[] a, int k) {
        if (a[0] > k) return 0; 
        int lo = 0; 
        int hi = a.length - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] > k) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }
}
