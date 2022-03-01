/* 
USACO 2018 January Contest, Bronze
Problem 3. Out of Place

SAMPLE INPUT:
6
2
4
7
7
9
3
SAMPLE OUTPUT:
3

----------------------------------------
***Logic:
In this problem, we're given a list of N integers, with the guarantee that 
removing exactly one of them can result in a sorted array.

Because removing one of them can result in a sorted array, if we consider
the elements that are not in the right order, those must form a sequence 
that is almost sorted, except that either the minimum element is in the 
rightmost slot or the maximum element is in the leftmost slot. Consequently, 
if there are K elements that are out of order, it will take K−1 swaps to fix 
them, since every swap except for the last one can only fix the location of 
one such element.
----------------------------------------
 */

import java.io.*;
import java.util.*;
public class OutOfPlace {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

		int n = Integer.parseInt(br.readLine());
		int[] height = new int[n];
		int[] sorted = new int[n];
		for(int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sorted[i] = height[i];
		}
		// count how many elements are out of order. 
		Arrays.sort(sorted);
		int swaps = -1;
		for(int a = 0; a < n; a++) {
			if(sorted[a] != height[a]) {
				swaps++;
			}
		}
		swaps = Math.max(0, swaps);
		pw.println(swaps);
		pw.close();
	}
}