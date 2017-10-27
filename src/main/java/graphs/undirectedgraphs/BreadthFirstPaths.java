package graphs.undirectedgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.addLast(s);
        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.addLast(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        List<Integer> path = new ArrayList<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.add(0, x);
        }
        path.add(0, s);

        return path;
    }
}
