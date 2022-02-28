/*
USACO 2018 December Contest, Bronze
Problem 3. Back and Forth

SAMPLE INPUT:
1 1 1 1 1 1 1 1 1 2
5 5 5 5 5 5 5 5 5 5
SAMPLE OUTPUT:
5

submission
1   10/10   with help from solution. 
Key: simulate the process by having a method for each day;
keep track of the possible results by a boolean
array, since answers should be in range 0 - 2000. 
*/

import java.util.*;
import java.io.*;
public class BackAndForth {
    static boolean[] answer = new boolean[2000];    // possible answers
    static int day = 1;
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
        ArrayList<Integer> a = new ArrayList<>();   // buckets
        ArrayList<Integer> b = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) { 
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) { 
            b.add(Integer.parseInt(st.nextToken()));
        }
        tue(1000, a, b);
        int count = 0;
        for (int i = 0; i < 2000; i++) {
            if (answer[i]) count++; 
        }
        pw.println(count);
        pw.close();
    }

    /**
     * 
     * @param A milk in a
     * @param a possible buckets in a
     * @param b possible buckets in b
     */
    static void tue(int A, ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            int k = a.get(i);
            ArrayList<Integer> newA = new ArrayList<>(a);
            ArrayList<Integer> newB = new ArrayList<>(b);
            newA.remove(i);
            newB.add(k);
            wed(A - k, newA, newB);
        }
    }

    static void wed(int A, ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < b.size(); i++) {
            int k = b.get(i);
            ArrayList<Integer> newA = new ArrayList<>(a);
            ArrayList<Integer> newB = new ArrayList<>(b);
            newA.add(k);
            newB.remove(i);
            thu(A + k, newA, newB);
        }
    }

    static void thu(int A, ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            int k = a.get(i);
            ArrayList<Integer> newA = new ArrayList<>(a);
            ArrayList<Integer> newB = new ArrayList<>(b);
            newA.remove(i);
            newB.add(k);
            fri(A - k, newA, newB);
        }
    }

    static void fri(int A, ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < b.size(); i++) {
            answer[A + b.get(i)] = true;
        } 
    }
}
