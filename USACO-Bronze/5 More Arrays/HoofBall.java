/*
USACO 2018 February Contest, Bronze
Problem 2. Hoofball

SAMPLE INPUT:
5
7 1 3 11 4
SAMPLE OUTPUT:
2
*/

/* Initial ideas: 
 * 1. sorted array to sort all the cows' position
 * count increment once the derivative of the distance graph changes sign: 
 * either the distance between nodes changes from increasing to decreasing or vice versa
 * 2. Or, keep the last position value and the the distance between the last two nodes
 * boolean value isIncreasing indecates whether distance is increasing. 
 * if isIncreasing is true but the distance between this and the last position is 
 * less than that between the last two, count++, isIncreasing = false. 
 * 
 * Solution: 
 * Go through the array of position, calculate if the ball is at position
 * i, which position will it pass (say, j). count the number of time that other cows pass to 
 * the cow at position j. If the ball is never passed to some position by other cows, a ball
 * is needed at this position by the farmer. find the number of positions that are never passed
 * to by other cows. 
 */

import java.util.*;
import java.io.*;
public class HoofBall {
    static int[] a;
    static int n; 
    public static void main(String args[]) throws IOException
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());        //n
        n = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        //System.out.println(Arrays.toString(a));
        //System.out.println(balls());
        pw.println(balls());
        pw.close();
    }

    public static int balls()
    {
        if (n <= 3) return 1;                                           // if less then 3 cows are playing, one ball is enough
        boolean[] toRight = new boolean[n];                             // whether one cow will pass the ball to the right or left. 
        toRight[0] = true;
        for (int i = 1; i < n-1; i++)                                   // if left distance > right distance, pass to the right
            if (dis(i, i-1) > dis(i+1, i)) toRight[i] = true;           // otherwise ball will be to the left. 
        int i = 0, count = 0; 
        while (i < n)
        {
            int right = 0; 
            while (i < n && toRight[i])                                 // count the number of right and left cows. 
            {                                                           // everytime a group of cows pass to the right followed by a group passing 
                i++;                                                    // to the left, we need two balls for these two groups. otherwise one is enough.
                right++; 
            }
            int left = 0; 
            while (i < n && !toRight[i])
            {
                i++;
                left++;
            }
            if (left > 1 && right > 1) count += 2;
            else count++;
        }
        return count;
    }

    public static int dis(int x, int y)
    {
        return a[x] - a[y];
    }
}
