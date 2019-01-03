package com.basic

class DemoOnMap {
    static void main(String[] args) {
        Map ageName = ['Magesh': 28, 'Ammu': 25]
        Map filteredResult = ageName.findAll { name, age -> age > 25 }
        filteredResult.each { entry ->
            println entry.key
            println entry.value
        }
        assert ageName.values()
        def ranges = 1..4
        List ranges1=[]
        ranges.collect(ranges1, { it -> it * 2 })
        println(ranges1)
    }
}
