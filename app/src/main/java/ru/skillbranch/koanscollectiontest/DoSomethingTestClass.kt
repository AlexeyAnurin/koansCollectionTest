package ru.skillbranch.koanscollectiontest

class DoSomethingTestClass {

  //  fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
    fun doSomethingStrangeWithCollection(collection: Collection<String>): Map<Char?, List<String>> {

        val groupsByLength = collection. groupBy { s -> s.maxBy { s.length } }
return groupsByLength

        // val maximumSizeOfGroup = groupsByLength.values.map { group -> TODO() }.max()

      //  return groupsByLength.values.firstOrNull { group -> TODO() }
    }
}