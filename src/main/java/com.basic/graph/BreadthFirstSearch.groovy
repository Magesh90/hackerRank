package com.basic.graph

class BreadthFirstSearch {

    static void main(String[] args) {
        GraphAsAdjMatrix graph = reInitializeGraph()
        println("------------------------")
        println("Breadth First Search for Graph")
        graph.bfs()
        println("\n------------------------")
        graph = reInitializeGraph()
        println("Depth First Search for Graph")
        graph.dfs()
    }

    private static GraphAsAdjMatrix reInitializeGraph() {
        GraphAsAdjMatrix graph = new GraphAsAdjMatrix(6)
        graph.addVertex('A')
        graph.addVertex('B')
        graph.addVertex('C')
        graph.addVertex('D')
        graph.addVertex('E')
        graph.addVertex('F')

        graph.addEdge(0, 1)
        graph.addEdge(0, 3)
        graph.addEdge(1, 2)
        graph.addEdge(1, 3)
        graph.addEdge(3, 4)
        graph.addEdge(4, 5)
        graph
    }

}

class Vertex {
    String label
    boolean wasVisited

    Vertex(String _label) {
        label = _label
        wasVisited = false
    }
}

class GraphAsAdjMatrix {
    int numberOfVertices
    int[][] adjMatrix
    List<Vertex> vertices
    Queue<Integer> queue
    int nVerts
    Stack<Integer> stack

    GraphAsAdjMatrix(int _numberOfVertices) {
        numberOfVertices = _numberOfVertices
        adjMatrix = new int[numberOfVertices][numberOfVertices]
        vertices = new ArrayList<>(numberOfVertices)
        queue = new LinkedList<>()
        stack = new Stack<>()
        nVerts = 0
    }

    void addVertex(String label) {
        vertices[nVerts++] = new Vertex(label)
    }

    void addEdge(int source, int destination) {
        adjMatrix[source][destination] = 1
        adjMatrix[destination][source] = 1
    }

    void bfs() {
        displayVertex(0)
        queue.add(0)
        int v2
        while (!queue.isEmpty()) {
            int vertex = queue.remove()
            while ((v2 = getUnVisitedAdjVertex(vertex)) != -1) {
                displayVertex(v2)
                queue.add(v2)
            }
        }
    }

    void dfs() {
        displayVertex(0)
        stack.push(0)
        int v2
        while (!stack.isEmpty()) {
            int vertex = stack.peek()
            v2 = getUnVisitedAdjVertex(vertex)
            if (v2 == -1) {
                stack.pop()
            } else {
                displayVertex(v2)
                stack.push(v2)
            }
        }
    }

    void displayVertex(int vertex) {
        vertices[vertex].wasVisited = true
        print(vertices[vertex].label + " ")
    }

    int getUnVisitedAdjVertex(int vertex) {

        for (int j = 0; j < nVerts; j++) {
            if (!vertices[j].wasVisited && adjMatrix[vertex][j] == 1) {
                return j
            }
        }
        return -1
    }

}