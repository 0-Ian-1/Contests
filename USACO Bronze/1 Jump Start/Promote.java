/*
 * pre-homework
 * Jan 2016 Bronze Contest problem 1
 */
import java.util.*;
import java.io.*;
public class Promote
{
    public static void main(String args[]) throws IOException
    {
        // read input from console
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // InputStreamReader reads from console, to test code

        // split string
        StringTokenizer st = new StringTokenizer(br.readLine()); // first line consist of participants before and after contest, 1 2
        int b0 = Integer.parseInt(st.nextToken());               // b0 = participants before contest, 1
        int b1 = Integer.parseInt(st.nextToken());               // b1 = participants after contest, 2

        st = new StringTokenizer(br.readLine());
        int s0 = Integer.parseInt(st.nextToken());               
        int s1 = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine());
        int g0 = Integer.parseInt(st.nextToken());               
        int g1 = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine());
        int p0 = Integer.parseInt(st.nextToken());               
        int p1 = Integer.parseInt(st.nextToken()); 

        int gp = p1 - p0;             // count gold promoted
        int sp = g1 - g0 + gp;        // count silver promoted
        int bp = s1 - s0 + sp; 

        System.out.println(gp);
        System.out.println(sp);
        System.out.println(bp);
        
    }
}