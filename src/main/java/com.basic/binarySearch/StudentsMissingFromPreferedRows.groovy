package com.basic.binarySearch

class StudentsMissingFromPreferedRows {

    static void main(String[] args) {

        int numberOfRows = 2
        int numberOfStudents = 5
        List<Integer> preferences = [1, 2, 1, 1, 1]
        int numberOfStudentsNotInPreferredRow = 0
        int numberOfStudentsNotInAnyRow = 0
        Map<Integer, Integer> rowCapacity = [1: 2, 2: 2]

        preferences.each { preferredRow ->
            if (rowCapacity[preferredRow] > 0) {
                rowCapacity[preferredRow]--
            } else {
                if (preferredRow == numberOfRows) {
                    if (rowCapacity[0] > 0) {
                        rowCapacity[0]--
                        numberOfStudentsNotInPreferredRow++
                    } else
                        numberOfStudentsNotInAnyRow++
                } else if (rowCapacity[++preferredRow] > 0) {
                    rowCapacity[preferredRow]--
                    numberOfStudentsNotInPreferredRow++
                } else
                    numberOfStudentsNotInAnyRow++
            }
        }
        println("Number of students not in preferred row=" + (numberOfStudentsNotInAnyRow + numberOfStudentsNotInPreferredRow))
    }
}
