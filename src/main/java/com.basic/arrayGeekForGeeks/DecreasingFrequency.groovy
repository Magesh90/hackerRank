package com.basic.arrayGeekForGeeks

class DecreasingFrequency {

    public static void main(String[] args) {

        int[] a = [5, 8, 3, 8, 5, 5, 8, 3, 2, 3, 5, 3]


        HashMap<Integer, Integer> frequencyMap = new HashMap<>()

        a.each { key ->
            if (frequencyMap[key]) {
                frequencyMap[key]++
            } else {
                frequencyMap[key] = 1
            }
        }

        //[5:4,8:3,9:1] - frequencyMap
        TreeMap<Integer, Integer> sortedFrequency = new TreeMap()
        frequencyMap.each { k, v ->
            println("key $k= value $v")
            sortedFrequency.putIfAbsent(v, k) //to keep the first element
        }

        println("after sorting")
        int[] keys = sortedFrequency.keySet()
        for (int i = keys.size() - 1; i >= 0; i--) {
            (keys[i]).times { print(sortedFrequency.get(keys[i])) }
        }
    }
}
