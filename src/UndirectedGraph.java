import java.util.Iterator;
import java.util.LinkedList;

public class UndirectedGraph {

	private int V;
	private LinkedList<Integer> adj[];

	UndirectedGraph(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}

	}

	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	public void DFSUtil(int source, boolean[] visited) {

		visited[source] = true;
		System.out.print(source + " ");
		Iterator<Integer> iterator = adj[source].iterator();
		while (iterator.hasNext()) {
			int n = iterator.next();
			if (visited[n] == false) {
				DFSUtil(n, visited);
			}
		}
	}

	public void DFS() {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				DFSUtil(i, visited);
		}
	}


	public void connectedComponents() {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				DFSUtil(i, visited);
				System.out.println();
			}
		}

	}

	public static void main(String[] args) {

		UndirectedGraph g = new UndirectedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS();

	}

}
