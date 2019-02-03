package com.basic.analytics


class WeighedMean {

    static void main(String[] args) {

        Scanner scan = new Scanner(System.in)
        int N = scan.nextInt()
        Integer[] X = load(scan, N)
        Integer[] W = load(scan, N)
        scan.close()

        int weightedSum = 0
        int weight = 0
        for (int i = 0; i < N; i++) {
            weightedSum += (X[i] * W[i])
            weight += W[i]
        }

        BigDecimal weightedMean = (weightedSum / weight)
        println(weightedMean.setScale(1, BigDecimal.ROUND_HALF_UP))
    }

    static Integer[] load(Scanner scan, int N) {
        Integer[] tempArray = []
        while ({
            tempArray += scan.nextInt()
            --N > 0
        }());
        tempArray
    }
}
