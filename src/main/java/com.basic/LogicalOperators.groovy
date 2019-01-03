package com.basic

class LogicalOperators {

    public static void main(String[] args) {
        List myList = [1, 2, 3, 4, 5]
        List yourList = myList.collect { it * 2 }
        println yourList
        println myList
        println myList.collate(2, false)
        println myList.collate(2, 3, false)
        println myList
        println myList.drop(2)
        println myList
        println yourList == myList
    }
}
