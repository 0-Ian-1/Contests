import java.util.*;
public class lonelyPhoto {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        char[] ch = scan.next().toCharArray();
        ArrayList<Integer> l = new ArrayList<Integer>();
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (ch[i] == ch[i-1]) count++;
            else { 
                l.add(count);
                count = 1;
            }
        }
        l.add(count);
        int total = 0;
        if (l.size()==2) {
            int left = l.get(0);
            int right = l.get(1);
            total = left-1 + right-1;
        }
        /*
        for (int i = 1; i < l.size()-1; i++) {
            int cur = l.get(i);
            int left = l.get(i-1);
            int right = l.get(i+1);
            if (cur == 1) {
                total += left*right + left-1 + right-1;
            } else {
                total += left-1 + 2*(cur-1) + right-1;
            }
        }
        */
        int[] a = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            a[i] = l.get(i);
        }
        System.out.println(count(a, 0, a.length-1));
    }

    public static int count(int[] a, int lo, int hi) {
        if (hi-lo==1) {
            return a[lo]-1 + a[hi]-1;
        }
        else if (hi-lo == 2) {
            int cur = a[lo+1];
            int left = a[lo];
            int right = a[hi];
            if (cur == 1) {
                return left*right + left-1 + right-1;
            } else {
                return left-1 + 2*(cur-1) + right-1;
            }
        } else {
            int mid = (hi-lo)/2;
            int plus = 0;
            if (a[mid]==1) plus += a[mid-1]*a[mid+1] + a[mid-1]-1 + a[mid+1]-1;
            if (a[mid-1]==1) plus += a[mid-2]*a[mid] + a[mid-2]-1 + a[mid]-1;
            if (a[mid-1]!=1 && a[mid]!=1) plus += a[mid]-1 + a[mid-1]-1;
            return count(a, lo, mid-1) + count(a, mid, hi) + plus;
        }
    }
}