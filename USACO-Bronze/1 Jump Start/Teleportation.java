import java.io.IOException;

/*
USACO 2018 February Contest, Bronze
Problem 1. Teleportation

SAMPLE INPUT:
3 10 8 2
SAMPLE OUTPUT:
3
*/

public class Teleportation {
    public static void main(String args[]) throws IOException {
        Scanner stdin = new Scanner(new File("teleport.in"));

		// Don't teleport.
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int res = Math.abs(a-b);

		// Get teleport.
		int c = stdin.nextInt();
		int d = stdin.nextInt();

		// Teleport to a->c.
		res = Math.min(res, Math.abs(a-c)+Math.abs(d-b));

		// Teleport to a->d.
		res = Math.min(res, Math.abs(a-d)+Math.abs(c-b));

		// Ta da!
		PrintWriter out = new PrintWriter(new FileWriter("teleport.out"));
		out.println(res);
		out.close();
		stdin.close();
    }
}
