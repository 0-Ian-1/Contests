/*
USACO 2018 US Open Contest, Bronze
Problem 1. Team Tic Tac Toe

SAMPLE INPUT:
COW
XXO
ABC
SAMPLE OUTPUT:
0
2
*/
/**
 * String simulation problem. 3*3 char array. 
 * check rows, columns, and diagnals. 
 * individual function, team function
 */
import java.util.*;
import java.io.*;
public class TeamTicTacToe {
    static char[][] t;
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
        t = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            for (int j = 0; j < 3; j++) t[i][j] = s.charAt(j);
        }
        int ind = 0; 
        int team = 0;
        for (int i = 0; i < 3; i++) {
            if (thr(t[i][0], t[i][1], t[i][2])) ind++;
            else if (two(t[i][0], t[i][1], t[i][2])) team++;
            if (thr(t[0][i], t[1][i], t[2][i])) ind++;
            else if (two(t[0][i], t[1][i], t[2][i])) team++;
        }
        if (thr(t[0][0], t[1][1], t[2][2])) ind++;
        else if(two(t[0][0], t[1][1], t[2][2])) team++;
        if(thr(t[0][2], t[1][1], t[2][0])) ind++;
        else if(two(t[0][2], t[1][1], t[2][0])) team++;
        pw.println(ind);
        pw.println(team);
        pw.close();
    }

    public static boolean two(char a, char b, char c) { return a == b || b == c || c == a; }
    public static boolean thr(char a, char b, char c) { return a == b && b == c; }
}
