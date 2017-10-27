package graphs.undirectedgraphs;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph(6);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);
    }

    @Test
    public void testDepthFirstPaths() {
        int s = 0;
        DepthFirstPaths paths = new DepthFirstPaths(graph, s);
        for (int v = 0; v < graph.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (paths.hasPathTo(v)) {
                for (int x : paths.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();
        }
    }

    @Test
    public void testBreadthFirstPaths() {
        int s = 0;
        BreadthFirstPaths paths = new BreadthFirstPaths(graph, s);
        for (int v = 0; v < graph.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (paths.hasPathTo(v)) {
                for (int x : paths.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();
        }
    }
}
