
public class ConnectedComponents {
	public static void main(String[] args) {
		UndirectedGraph g = new UndirectedGraph(8);
		g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(0, 5);
        g.addEdge(1, 6);
        g.addEdge(4, 7);
        g.connectedComponents();
	}
}
