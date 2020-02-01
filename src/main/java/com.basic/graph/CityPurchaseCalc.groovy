package com.basic.graph

class CityPurchaseCalc {


    static void main(String[] args) {
        Graph graph = new Graph(++3)
        graph.addEdge(1, 2)
        //graph.addEdge(1, 3)
        graph.addEdge(3, 3)

        Set citiesBought = new HashSet()

        for (int i = 1; i < ++3; i++) {
            graph.adjLists[i].each {
                boolean cityAdded = false
                if (i != it) {
                    cityAdded = citiesBought.add(it)
                }
                if (cityAdded) {
                    citiesBought.add(i)
                }
            }
        }

        println("Number of cities bought by the monk=" + citiesBought)
    }
}
