package project;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Implement BFS to find the path
 * 
 * @author Jiamin //reference from Algs4th
 *
 */
public class BFS {
	boolean[] marked;
	int[] edgeTo;
	int[] distTo;

	/**
	 * Constructor of BFS class by taking a digiaph and start point
	 * 
	 * @param a
	 *            Digraph object including vertices and linkage to implement search
	 * @param s
	 *            start point
	 */
	public BFS(Graph a, int s) {
		marked = new boolean[a.V()]; // for markoff detected nodes
		edgeTo = new int[a.V()]; // record adjacent nodes
		Arrays.fill(edgeTo, -1);
		distTo = new int[a.V()]; // record distance
		bfs(a, s);
	}

	/**
	 * Void function that implement bfs by using queue to track the current node and
	 * finding its adjacent node
	 * 
	 * @param a
	 *            Digraph object including vertices and linkage to implement search
	 * @param s
	 *            start point
	 */
	private void bfs(Graph a, int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int v = 0; v < a.V(); v++)
			distTo[v] = Integer.MAX_VALUE;
		distTo[s] = 0;
		marked[s] = true; // mark off
		queue.add(s); // add nodes

		while (queue.size() != 0) {
			int v = queue.poll(); // get current by pop
			for (int w : a.adj()[v]) {
				if (!marked[w]) { // not yet detected
					edgeTo[w] = v; // parent
					distTo[w] = distTo[v] + 1; // distance increment
					marked[w] = true; // mark off
					queue.add(w); // enqueue
				}
			}
		}
	}

	/**
	 * Funtion that traverse the path from end to start and insert pathing node to
	 * the linklist return then return it
	 * 
	 * @param v
	 *            the destination of the path.
	 * @return tem the path of the traversal.
	 */
	public LinkedList<Integer> pathTo(int v) { // get path
		LinkedList<Integer> tem = new LinkedList<Integer>();
		int x;
		for (x = v; distTo[x] != 0 && edgeTo[x] != -1; x = edgeTo[x]) // track by parent
			tem.add(x);
		tem.add(x);

		return tem;
	}
	
	public int[] edgeTo() {
		return this.edgeTo;
	}

	public boolean[] marked() {
		// TODO Auto-generated method stub
		return this.marked;
	}
}
