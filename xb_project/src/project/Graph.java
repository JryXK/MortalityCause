package project;

import java.util.LinkedList;

/**
 * Digraph class to build a directed graph, including state variable V number of
 * vertices, E number of edges and adj array of linked list.
 * 
 * @author Jiamin
 * 
 */
public class Graph {
	private int V;
	private int E;
	private LinkedList<Integer>[] adj;

	/**
	 * Constructor of Digraph class by taking number of vertices. Then for each
	 * vertices construct a linked list to build for adjacent list.
	 * 
	 * @param V
	 *            number of vertives
	 */
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList();
	}

	/**
	 * link the node with the target node by taking the target and destination.
	 * 
	 * @param v
	 *            target node.
	 * @param w
	 *            destination node.
	 */
	void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	public LinkedList<Integer>[] adj() {
		return adj;
	}
	/**
	 * Accessor to get the number of vertices.
	 * 
	 * @return V
	 */
	public int V() {
		return V;
	}

	/**
	 * Accessor to get the number of edges.
	 * 
	 * @return E
	 */
	public int E() {
		return E;
	}

	/**
	 * Accessor to get the certain linked list for a node
	 * 
	 * @param i
	 *            which node to return
	 * @return adj[i] certain linked list
	 */
	public LinkedList<Integer> adj(int i) {
		return adj[i];
	}

}
