package com.basic.graph

class Graph {

    int numberOfVertices
    LinkedList<Integer>[] adjLists

    Graph(int _numberOfVertices) {
        numberOfVertices = _numberOfVertices
        adjLists = new LinkedList<Integer>[_numberOfVertices]
        for (int i = 0; i < numberOfVertices; i++)
            adjLists[i] = new LinkedList<Integer>()
    }


    void addEdge(int src, int dest) {
        adjLists[src].add(dest)
    }

    void displayGraph() {
        for (int i = 0; i < numberOfVertices; i++) {
            println("Vertice - $i")
            print(i + "--")
            adjLists[i].each {
                print(it + "--")
            }
            println()
        }
    }

    static void main(String[] args) {
        Graph graph = new Graph(3)
        graph.addEdge(0, 1)
        graph.addEdge(0, 2)
        graph.addEdge(1, 2)
        graph.addEdge(1, 0)
        graph.addEdge(2, 0)
        graph.displayGraph()
    }

}
