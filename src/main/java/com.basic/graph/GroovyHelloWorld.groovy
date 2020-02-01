package com.basic.graph

class GroovyHelloWorld {
    static void main(String[] args) {
                                   // Writing output to STDOUT
        String numberOfTestCases = System.in.newReader().readLine();
        //println("number of test cases " + numberOfTestCases)
        for (int i = 0; i < Integer.parseInt(numberOfTestCases); i++) {
            String numberOfRoads = System.in.newReader().readLine();
           // println("number of roads " + numberOfRoads)
            int _numberOfRoads = Integer.parseInt(numberOfRoads)
            Graph graph = new Graph(++_numberOfRoads)

            for (int road = 1; road < _numberOfRoads; road++) {
                String roadConnection = System.in.newReader().readLine();
                String[] vertices = roadConnection.split(" ")
                graph.addEdge(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]))
            }

            Set citiesBought = new HashSet()

            for (int j = 1; j < _numberOfRoads; j++) {
                graph.adjLists[j].each {
                    boolean cityAdded = false
                    if (j != it) {
                        citiesBought.add(it)
                        cityAdded = true
                    }
                    if (cityAdded) {
                        citiesBought.add(j)
                    }
                }
            }
            println(citiesBought.size())
        }
    }
}
