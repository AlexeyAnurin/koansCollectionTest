package ru.skillbranch.koanscollectiontest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Return the set of customers
        println("shop.getSetOfCustomers(): ${shopOne.getSetOfCustomers()}")
        println("shop.getSetOfCustomers(): ${shopOne.customersList.toSet()}")

        // Return the set of cities the customers are from
        println("Shop.getCitiesCustomersAreFrom(): ${shopOne.getCitiesCustomersAreFrom()}")

        // Return a list of the customers who live in the given city
        println("Shop.getCustomersFrom(city: City): ${shopOne.getCustomersFrom(Tokyo)}")

        // Return true if all customers are from the given city
        println("Shop.checkAllCustomersAreFrom(city: City): ${shopOne.checkAllCustomersAreFrom(Tokyo)}")

        // Return true if there is at least one customer from the given city
        println("Shop.hasCustomerFrom(city: City): ${shopOne.hasCustomerFrom(Canberra)}")

        // Return the number of customers from the given city
        println("Shop.countCustomersFrom(city: City): ${shopOne.countCustomersFrom(Canberra)}")

        // Return a customer who lives in the given city, or null if there is none
        println("Shop.findAnyCustomerFrom(city: City): ${shopOne.findAnyCustomerFrom(SilentHill)}")

        // Return all products this customer has ordered
        println("val Customer.orderedProducts: ${shopOne.customersList.map { it.orderedProducts1 }}")
        //  [['ReSharper' for 149.0, 'DotMemory' for 129.0, 'DotTrace' for 159.0], [],
        // ['RubyMine' for 99.0, 'WebStorm' for 49.0], ['IntelliJ IDEA Ultimate' for 199.0],
        // ['ReSharper' for 149.0], ['IntelliJ IDEA Ultimate' for 199.0], ['PhpStorm' for 99.0]]

        // Return all products that were ordered by at least one customer (заказанные хотя бы 1 раз)
        println("val Shop.allOrderedProducts: ${shopOne.allOrderedProducts}")
        //  ['ReSharper' for 149.0, 'DotMemory' for 129.0, 'DotTrace' for 159.0,
        // 'RubyMine' for 99.0, 'WebStorm' for 49.0, 'IntelliJ IDEA Ultimate' for 199.0, 'PhpStorm' for 99.0]


        // Return a customer whose order count is the highest among all customers
        println(
            "fun Shop.getCustomerWithMaximumNumberOfOrders():" +
                    " ${shopOne.getCustomerWithMaximumNumberOfOrders()}"
        )

        //! Хочу как getCustomerWithMaximumNumberOfOrders(), но наибольшее количество всех товаров
        // во всех заказах клиента

        // Return the most expensive product which has been ordered
        println("fun Customer.getMostExpensiveOrderedProduct():" +
                " ${shopOne.customersList.map { it.getMostExpensiveOrderedProduct() }}"
        )

        //! Общая цена заказов по каждому клиенту
        println("fun Customer.getTotalPriceOrderedProduct():" +
                " ${shopOne.customersList.map { it.getTotalPriceOrderedProduct() }}"
        )

        //! Общая цена заказов по каждому клиенту Если доставлено
        println("fun Customer.getTotalPriceOrderedProduct():" +
                " ${shopOne.customersList.map { it.getTotalPriceOrderedProductDelivered() }}"
        )

        // Return a list of customers, sorted by the ascending number of orders they made
        println("fun Shop.getCustomersSortedByNumberOfOrders(): ${shopOne.getCustomersSortedByNumberOfOrders()}")

        // Return a list of customers, sorted by the ascending number of products they made
        println("fun Shop.getCustomersSortedByNumberOfProducts(): ${shopOne.getCustomersSortedByNumberOfProducts()}")

        // Return the sum of prices of all products that a customer has ordered.
        // Note: the customer may order the same product for several times.
        println("fun Customer.getTotalOrderPrice(): ${shopOne.customersList.map { it.getTotalOrderPrice() }}")
        println("fun Customer.getTotalOrderPrice(): ${shopOne.customersList[0].getTotalOrderPrice()}")

        // Return a map of the customers living in each city
        println("fun Shop.groupCustomersByCity(): ${shopOne.groupCustomersByCity()}}")

        //  вернуть у кого больше недоставленных посылок, чем доставленных, использую partition
        println("fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): ${shopOne.getCustomersWithMoreUndeliveredOrdersThanDelivered()}")

        // Return the set of products that were ordered by every customer
        println("fun Shop.getSetOfProductsOrderedByEveryCustomer(): ${shopOne.getSetOfProductsOrderedByEveryCustomer()}")

        // Return the most expensive product among all delivered products.
        println("vvv ${shopOne.customersList.map { it.getMostExpensiveDeliveredProduct() }}")
        //  То же самое, но не в виде вызова функции расширения.
        println("vvv ${shopOne.customersList.map { it.ordersList.sortedBy { it.isDelivered } }}")

        println("${shopOne.customersList.map { it.countProducts() }}")

        println("getNumberOfTimesProductWasOrdered : ${shopOne.getNumberOfTimesProductWasOrdered(idea)}")


        /////////////////////JAVA REWRITE ////////////////////////

        val javaRewrite = Rewrite()
        val collection = mutableListOf<String>("string 111", "string 22", "string 3", "string 4", "string 55", "string 66")
        println("doSomethingStrangeWithCollection : ${javaRewrite.doSomethingStrangeWithCollection(collection)}")

///////////////////////////////////

val doSomethingTestClass = DoSomethingTestClass()
        println("doSomethingStrangeWithCollection kotlin : ${doSomethingTestClass.doSomethingStrangeWithCollection(collection)}")

        /////////FOLD  FOLD  FOLD  FOLD  FOLD  FOLD  /////////////////////////////////////////////

        val list = listOf(1, 2, 3, 4, 5)


// 15 + 1 + 2 + 3 + 4 + 5
        println("Fold : ${list.fold(15) { accumulator, element -> accumulator + element }}") // 30



    }
}