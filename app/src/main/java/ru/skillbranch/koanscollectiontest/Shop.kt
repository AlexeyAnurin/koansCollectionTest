package ru.skillbranch.koanscollectiontest

data class Shop(val name: String, val customersList: List<Customer>)

data class Customer(val name: String, val city: City, val ordersList: List<Order>) {
    override fun toString() = "$name from ${city.name}"
}

data class Order(val productsList: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double) {
    override fun toString() = "'$name' for $price"
}

data class City(val name: String) {
    override fun toString() = name
}