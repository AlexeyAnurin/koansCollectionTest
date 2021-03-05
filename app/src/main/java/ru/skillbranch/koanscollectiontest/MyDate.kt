package ru.skillbranch.koanscollectiontest

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
       return when {
            year!=other.year -> year-other.year
            month!=other.month -> month-other.month
            else -> dayOfMonth-other.dayOfMonth
        }
    }

}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2

val date1 = MyDate(1,2,3)
val date2 = MyDate(4,5,6)


fun main(args: Array<String>) {
    println("compareTo : ${date1.compareTo(date2)}")
}