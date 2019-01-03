package com.basic

class BitwiseAndDemo {
    static void main(String[] args) {

        //Read the input from scanner
        Scanner scan = new Scanner(System.in)
        int numberOfTestCases = scan.nextLine() as int
        String[] testCasesFromScanner = []
        while ({
            //collect all the test cases
            testCasesFromScanner += scan.nextLine()
            --numberOfTestCases
            numberOfTestCases > 0
        }());
        scan.close()

        //Split the test cases so that it can be used
        LinkedList<int[]> testCases = []
        testCasesFromScanner.each {
            String[] nAndK = it.trim().split(' ')
            int n = Integer.parseInt(nAndK[0])
            int k = Integer.parseInt(nAndK[1])
            println(findMaximum(n, k))
            //int[] nAndKAsInt = [Integer.parseInt(nAndK[0]), Integer.parseInt(nAndK[1])]
            //testCases.add(nAndKAsInt)
        }

        testCases.each {
            LinkedList<List> listOfAAndBs = []
            int k = it[1]
            int n = it[0]
            int max = 0
            for (int i = 1; i < n; i++) {
                int resetMax = combineAllPossibilities(i, n, k)
                if (resetMax > max) {
                    max = resetMax
                }
                //println(combineAllPossibilities(i, n, k))
                //listOfAAndBs += combineAllPossibilities(i, n, k)
            }
            println(max)
            //println(findMaxValueInList(listOfAAndBs, k))
        }
    }

    //recursive function to combine all the As and Bs of each test case
    static int combineAllPossibilities(Integer base, Integer max, int k, LinkedList<List> possibilities = []) {
        if (max <= base) {
            int maxPossibleValue = 0
            possibilities.each {
                innerList ->
                    int temp = innerList[0] & innerList[1]
                    if (temp > maxPossibleValue && temp < k) {
                        maxPossibleValue = temp
                    }
            }
            return maxPossibleValue
        }
        possibilities.add([base, max])
        combineAllPossibilities(base, max - 1, k, possibilities)
    }

    //return the max value if it matches the criteria of <k and also the max of all the bitwise AND
    static int findMaxValueInList(LinkedList<List> listOfAAndBs, int k) {
        int max = 0
        listOfAAndBs.each { innerList ->
            int temp = innerList[0] & innerList[1]
            if (temp > max && temp < k) {
                max = temp
            }
        }
        max
    }

    static findMaximum(int n, int k) {
        int max = 0
        for (int A = 1; A < n; A++) {
            for (int B = A + 1; B <= n; B++) {
                int temp = A & B
                if (temp > max && temp < k) {
                    max = temp
                }
            }
        }
        max
    }
}
