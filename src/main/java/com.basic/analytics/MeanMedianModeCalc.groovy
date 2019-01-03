package com.basic.analytics

class MeanMedianModeCalc {

    static void main(String[] args) {

        Scanner scan = new Scanner(System.in)
        int count = scan.nextInt()
        Integer[] numberArray = []
        int sum = 0
        Map<Integer, Integer> numberOfOccurrences = [:]
        while ({
            int value = scan.nextInt()
            numberArray += value
            sum += value
            if (numberOfOccurrences[value]) {
                numberOfOccurrences[value]++
            } else {
                numberOfOccurrences[value] = 1
            }
            --count > 0
        }());
        scan.close()
        double mean = sum / numberArray.length
        println(mean.round(1))
        Arrays.sort(numberArray)
        int middleIndex = (numberArray.length / 2)- 1
        double median = (numberArray[middleIndex] + numberArray[middleIndex + 1]) / 2
        println median.round(1)
        int maxOccurrences = numberOfOccurrences.values().max()
        Set<Integer> repeatedNumbers = numberOfOccurrences.findAll {
            key, value ->
                value == maxOccurrences
        }?.keySet()
        println(repeatedNumbers?.min())
    }
}
