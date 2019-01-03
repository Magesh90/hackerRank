package com.basic

import java.text.SimpleDateFormat

class LibraryManagement {

    static void main(String[] args) {

        Scanner scan = new Scanner(System.in)
        String actualDateAsString = scan.nextLine()
        String expectedDateAsString = scan.nextLine()
        scan.close()
        actualDateAsString = actualDateAsString.replace(' ', '/')
        expectedDateAsString = expectedDateAsString.replace(' ', '/')
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat('dd/MM/yyyy')
        Date actualDate = simpleDateFormat.parse(actualDateAsString)
        Date expectedDate = simpleDateFormat.parse(expectedDateAsString)
        Calendar actualDateCalendar = Calendar.getInstance()
        Calendar expectedDateCalendar = Calendar.getInstance()
        actualDateCalendar.setTime(actualDate)
        expectedDateCalendar.setTime(expectedDate)
        if (actualDateCalendar.get(Calendar.YEAR) == expectedDateCalendar.get(Calendar.YEAR)) {
            if (actualDateCalendar.get(Calendar.MONTH) == expectedDateCalendar.get(Calendar.MONTH)) {
                int diff = (actualDateCalendar.get(Calendar.DATE) - expectedDateCalendar.get(Calendar.DATE))
                if (diff > 0) {
                    println(diff * 15)
                } else {
                    println(0)
                }
            } else if (actualDateCalendar.get(Calendar.MONTH) > expectedDateCalendar.get(Calendar.MONTH)) {
                println((actualDateCalendar.get(Calendar.MONTH) - expectedDateCalendar.get(Calendar.MONTH)) * 500)
            } else {
                println(0)
            }
        } else if (actualDateCalendar.get(Calendar.YEAR) > expectedDateCalendar.get(Calendar.YEAR)) {
            println(10000)
        } else {
            println(0)
        }
    }
}
