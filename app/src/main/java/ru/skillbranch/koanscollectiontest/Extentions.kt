package ru.skillbranch.koanscollectiontest

fun Shop.getSetOfCustomers(): Set<Customer> = customersList.toSet()

// Return the set of cities the customers are from
fun Shop.getCitiesCustomersAreFrom(): Set<City> = customersList.map { it.city }.toSet()

// Return a list of the customers who live in the given city
fun Shop.getCustomersFrom(city: City): List<Customer> = customersList.filter { it.city == city }

// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = customersList.all { it.city == city }

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = customersList.any { it.city == city }

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = customersList.count { it.city == city }

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = customersList.find { it.city == city }

// Return all products this customer has ordered
val Customer.orderedProducts1: Set<Product>
    get() {
        return ordersList.flatMap { it.productsList }.toSet()
    }

// Return all products that were ordered by at least one customer
val Shop.allOrderedProducts: Set<Product>
    get() {
        return customersList.flatMap { it.orderedProducts1 }.toSet() //e flatMap - Returns a single
        // list of all elements yielded from results of [transform] function being invoked on
        // each element of original collection.
    }

// Return a customer whose order count is the highest among all customers
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? =
    customersList.maxBy { it.ordersList.size }

// Return the most expensive product which has been ordered
fun Customer.getMostExpensiveOrderedProduct(): Product? =
    ordersList.flatMap { it.productsList }
        .also { println("ordersList.flatMap { it.productsList } : $it ") }.maxBy { it.price }

//  Общая цена заказов по каждому клиенту
fun Customer.getTotalPriceOrderedProduct(): Int? =
    ordersList.flatMap { it.productsList }.sumBy { it.price.toInt() }

//  Общая цена заказов по каждому клиенту ЕСЛИ доставлено
fun Customer.getTotalPriceOrderedProductDelivered(): Int? =
    ordersList.filter { it.isDelivered }.also { println("filter isDelivered: $it") }
        .flatMap { it.productsList }.also { println("flatMap it.productsList: $it") }
        .sumBy { it.price.toInt() }.also { println("sumBy it.price: $it") }

// Return a list of customers, sorted by the ascending number of orders they made
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> =
    customersList.sortedBy { it.ordersList.size }

// Return a list of customers, sorted by the ascending number of products they made
fun Shop.getCustomersSortedByNumberOfProducts(): List<Customer> {
    return customersList.sortedBy { it.ordersList.sumBy { it.productsList.size } }
}

// Return the sum of prices of all products that a customer has ordered.
// Note: the customer may order the same product for several times.
fun Customer.getTotalOrderPrice(): Double =
    ordersList.flatMap { it.productsList }.sumByDouble { it.price }

// Return a map of the customers living in each city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customersList.groupBy { it.city }

//  вернуть у кого больше недоставленных посылок, чем доставленных, использую partition
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> =
    customersList.filter {
        val (delivered, undelivered) = it.ordersList.partition { it.isDelivered }
        undelivered.size > delivered.size
    }.toSet()

// Return the set of products that were ordered by every customer
//fold - задаёт начальное значение, а потом добавляется все значения в списке от первого к последнему.
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
 return customersList.flatMap { it.ordersList.flatMap { it.productsList } }.toSet()
}

// Return the most expensive product among all delivered products. (use the Order.isDelivered flag)
fun Customer.getMostExpensiveDeliveredProduct(): Product? { //  Product?
    println("ordersList.filter : ${ordersList.filter { it.isDelivered }}")
    return ordersList.filter { it.isDelivered }
        .also { println("aaa $it") }
        .flatMap { it.productsList }
        .also { println("bbb $it") }
        .maxBy { it.price }
        .also { println("ccc $it") }
}


// Return how many times the given product was ordered. Note: a customer may order the same product for several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
return customersList.flatMap { it.countProducts() }.count { it == product }
}

fun Customer.countProducts(): List<Product>{
    val countProducts = ordersList.flatMap { it.productsList }.also { println("Customer.countProducts() : $it") }
return countProducts
}
